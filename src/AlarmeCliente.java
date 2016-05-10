/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import Alarme.JanelaGUI.*;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Joamila
 * Criado em: 18/04/2016
 * Última atualização: 24/04/2016
 */
public class AlarmeCliente {
    AlarmeGUI alarme;
    int modo;
    int qtdVisitantes;
    Alarme alarme_segur;
    Guarda guarda_segur;
    Portao portao_acesso;
    WindowListener listenerWind;
    
    public AlarmeCliente(){
        this.modo = 0;
        alarme = new AlarmeGUI();
        alarme.setVisible(true);
    }
    
    /**
     * Inicia o listener da janela
     * @param alarmeGUI AlarmeGUI
     * @param listenerWind WindowListener
     */
    public void iniciarListener(AlarmeGUI alarmeGUI, WindowListener listenerWind){
        alarmeGUI.addWindowListener(listenerWind);
    }
    
    public static void main (String args[]){
        final AlarmeCliente alarmeCliente = new AlarmeCliente();
        
        ORB orb = ORB.init(args, null);
        try {
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
            NamingContext naming = NamingContextHelper.narrow(obj);
            
            //Interface Alarme
            NameComponent[] name = {new NameComponent("Alarme", "alarmeMuseu")};
            org.omg.CORBA.Object objRef = naming.resolve(name);
            naming.rebind(name, objRef);
            alarmeCliente.alarme_segur = AlarmeHelper.narrow(objRef);
            
            //Interface Guarda 
            NameComponent[] nameG = {new NameComponent("Guarda", "guardaMuseu")};
            org.omg.CORBA.Object objRefG = naming.resolve(nameG);
            naming.rebind(nameG, objRefG);
            alarmeCliente.guarda_segur = GuardaHelper.narrow(objRefG);
            
            //Interface Portao
            NameComponent[] nameP = {new NameComponent("Portao", "portaoMuseu")};
            org.omg.CORBA.Object objRefP = naming.resolve(nameP);
            naming.rebind(nameP, objRefP);         
            alarmeCliente.portao_acesso = PortaoHelper.narrow(objRefP);
            
        } catch (InvalidName ex) {
            Logger.getLogger(PortaoServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(PortaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Thread thread;
        thread = new Thread(new Runnable(){
            @Override
            public void run() {
                //Configuração inicial da janela
                alarmeCliente.iniciarListener(alarmeCliente.alarme, alarmeCliente.listenerWind);
                alarmeCliente.alarme_segur.iniciarAlarme();
                alarmeCliente.alarme.getAlarmeLabel().
                    setIcon(new javax.swing.ImageIcon(getClass().getResource("/Alarme/JanelaGUI/alarme_off.png")));
                alarmeCliente.alarme.getAvisoAlarmeLabel().setForeground(Color.ORANGE);
                alarmeCliente.alarme.getAvisoAlarmeLabel().setText("ALARME DESATIVADO");
                
                while(true){
                    //Verfifica se houve mudança de modo (modo = 0: diurno; modo = 1: noturno)
                    if(alarmeCliente.guarda_segur.verificarMudModo()){
                        alarmeCliente.modo = alarmeCliente.guarda_segur.consultarModo();
                        //Modo diurno
                        if(alarmeCliente.modo == 0){
                            alarmeCliente.alarme.getAlarmeLabel().
                                   setIcon(new javax.swing.ImageIcon(getClass().getResource("/Alarme/JanelaGUI/alarme_off.png")));
                            alarmeCliente.alarme.getAvisoAlarmeLabel().setForeground(Color.ORANGE);
                            alarmeCliente.alarme.getAvisoAlarmeLabel().setText("ALARME DESATIVADO");
                        }
                        //Modo noturno
                        else if(alarmeCliente.modo == 1){
                            alarmeCliente.alarme.getAlarmeLabel().
                                   setIcon(new javax.swing.ImageIcon(getClass().getResource("/Alarme/JanelaGUI/alarme_on.png")));
                            alarmeCliente.qtdVisitantes = alarmeCliente.portao_acesso.verificarVisitantes();
                            //Verfica se há intrusos no museu
                            if(alarmeCliente.qtdVisitantes > 0){
                                alarmeCliente.alarme.getAvisoAlarmeLabel().setForeground(Color.red);
                                alarmeCliente.alarme.getAvisoAlarmeLabel().setText("ATENÇÃO, INTRUSO DETECTADO!");
                                
                                alarmeCliente.alarme_segur.informarInvasao();
                            }
                            else{
                               alarmeCliente.alarme.getAvisoAlarmeLabel().setForeground(Color.BLUE);
                                alarmeCliente.alarme.getAvisoAlarmeLabel().setText("ALARME ATIVADO"); 
                            }
                        }
                    }
                    //Verifica qual o modo quando não houve mudança
                    else{
                        alarmeCliente.modo = alarmeCliente.guarda_segur.consultarModo();
                        if(alarmeCliente.modo == 1){
                            alarmeCliente.qtdVisitantes = alarmeCliente.portao_acesso.verificarVisitantes();
                            if(alarmeCliente.qtdVisitantes > 0){
                                alarmeCliente.alarme.getAvisoAlarmeLabel().setForeground(Color.red);
                                alarmeCliente.alarme.getAvisoAlarmeLabel().setText("ATENÇÃO, INTRUSO DETECTADO!");

                                alarmeCliente.alarme_segur.informarInvasao();
                            }
                        }
                    }
                }
            }
            
        });
        
        alarmeCliente.listenerWind = new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {
                alarmeCliente.alarme_segur.desativarAlarme();
            }

            @Override
            public void windowClosed(WindowEvent e) {}

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}
        };
        
        thread.start();
    }
}
