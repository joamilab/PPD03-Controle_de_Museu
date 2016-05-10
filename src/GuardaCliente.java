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

import Guarda.JanelaGUI.*;
import Guarda.Controle.*;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Joamila
 * Criado em: 18/04/2016
 * Última atualização em: 24/04/2016
 */
public class GuardaCliente {
    GuardaGUI guarda;
    int modo;
    int qtdVisitantes;
    GuardaAcesso guardaAcesso = new GuardaAcesso();
    ChangeListener listenerCh;
    WindowListener listenerWind;
    Portao portao_entrada;
    Guarda guarda_segur;
    Alarme alarme_segur;
    
    public GuardaCliente(){
        this.guarda = new GuardaGUI();
        this.guarda.setVisible(true);
        
        this.modo = 0;
        this.qtdVisitantes = 0;
    }
    
    /**
     * Inicia os listeners do componente slider e da janela
     * @param guardaGUI GuardaGUI
     * @param listenerCh ChangeListener
     * @param listenerWind Window Listener
     */
    public void iniciarListenerComponents(GuardaGUI guardaGUI, ChangeListener listenerCh, WindowListener listenerWind){
        guardaGUI.getAjustarModoSlider().addChangeListener(listenerCh);
        guardaGUI.addWindowListener(listenerWind);
    }
    
    public static void main (String args[]){
        final GuardaCliente guardaCliente = new GuardaCliente();
        
        ORB orb = ORB.init(args, null);
        try {
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
            NamingContext naming = NamingContextHelper.narrow(obj);
            
            //Interface Portao
            NameComponent[] name = {new NameComponent("Portao", "portaoMuseu")};
            org.omg.CORBA.Object objRef = naming.resolve(name);
            naming.rebind(name, objRef);
            guardaCliente.portao_entrada = PortaoHelper.narrow(objRef);
            
            //Interface Guarda
            NameComponent[] nameG = {new NameComponent("Guarda", "guardaMuseu")};
            org.omg.CORBA.Object objRefG = naming.resolve(nameG);
            naming.rebind(nameG, objRefG);
            guardaCliente.guarda_segur = GuardaHelper.narrow(objRefG);
            
            //Interface Alarme
            NameComponent[] nameA = {new NameComponent("Alarme", "alarmeMuseu")};
            org.omg.CORBA.Object objRefA = naming.resolve(nameA);
            naming.rebind(nameA, objRefA);
            guardaCliente.alarme_segur = AlarmeHelper.narrow(objRefA);
            
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
                guardaCliente.guarda_segur.iniciarGuarda();
                guardaCliente.iniciarListenerComponents(guardaCliente.guarda, guardaCliente.listenerCh,
                        guardaCliente.listenerWind);
                guardaCliente.guarda.getStatusModoLabel().setForeground(Color.ORANGE);
                guardaCliente.guarda.getStatusModoLabel().setText("MODO DIURNO");
                
                //Verifica a quantidade de visitantes e atualiza o contador
                guardaCliente.qtdVisitantes = guardaCliente.portao_entrada.verificarVisitantes();
                guardaCliente.guardaAcesso.atualizarContador(guardaCliente.guarda, guardaCliente.qtdVisitantes);
                
                while(true){
                    //Verifica se houve invasão
                    if(guardaCliente.alarme_segur.verificarInvasao()){
                        guardaCliente.guarda.getAlarmeLabel().
                                setIcon(new javax.swing.ImageIcon(getClass().getResource("/Guarda/JanelaGUI/alarme_small.png")));
                        guardaCliente.guarda.getStatusAlarmeLabel().setForeground(Color.red);
                        guardaCliente.guarda.getStatusAlarmeLabel().setText("ATENÇÃO, INTRUSO DETECTADO!");
                    }
                    
                    if(guardaCliente.modo == 1 && !guardaCliente.alarme_segur.verificarAlarme()){
                        guardaCliente.guarda.getStatusAlarmeLabel().setForeground(Color.red);
                        guardaCliente.guarda.getStatusAlarmeLabel().setText("O ALARME FOI DESATIVADO!");
                    }
                    
                    //Verfica se houve entrada no museu
                    if(guardaCliente.portao_entrada.verificarEntrada()){
                        guardaCliente.qtdVisitantes += 1;
                        guardaCliente.guardaAcesso.atualizarContador(guardaCliente.guarda, guardaCliente.qtdVisitantes);
                        
                        //Verifica se a entrada resultou em invasão
                        if(guardaCliente.alarme_segur.verificarInvasao()){
                            guardaCliente.guarda.getAlarmeLabel().
                                    setIcon(new javax.swing.ImageIcon(getClass().getResource("/Guarda/JanelaGUI/alarme_small.png")));
                            guardaCliente.guarda.getStatusAlarmeLabel().setForeground(Color.red);
                            guardaCliente.guarda.getStatusAlarmeLabel().setText("ATENÇÃO, INTRUSO DETECTADO!");
                        }
                    }
                    
                    //Verifica se houve saída do museu
                    else if(guardaCliente.portao_entrada.verificarSaida()){
                        guardaCliente.qtdVisitantes -= 1;
                        guardaCliente.guardaAcesso.atualizarContador(guardaCliente.guarda, guardaCliente.qtdVisitantes);
                        
                        //Verifica se houve invasão durante a saída
                        if(guardaCliente.alarme_segur.verificarInvasao()){
                            guardaCliente.guarda.getAlarmeLabel().
                                    setIcon(new javax.swing.ImageIcon(getClass().getResource("/Guarda/JanelaGUI/alarme_small.png")));
                            guardaCliente.guarda.getStatusAlarmeLabel().setForeground(Color.red);
                            guardaCliente.guarda.getStatusAlarmeLabel().setText("ATENÇÃO, INTRUSO DETECTADO!");
                        }
                    } 
                }
            }
            
        });
        
        guardaCliente.listenerCh = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valSource = guardaCliente.guarda.getAjustarModoSlider().getValue();
                
                //Mudança no slider para modo diurno
                if(valSource >= 0 && valSource <50){
                    guardaCliente.modo = 0;
                    guardaCliente.guarda.getStatusModoLabel().setForeground(Color.ORANGE);
                    guardaCliente.guarda.getStatusModoLabel().setText("MODO DIURNO");

                    guardaCliente.guarda.getStatusAlarmeLabel().setText("");
                    guardaCliente.guarda.getAlarmeLabel().
                            setIcon(null);
                }
                
                //Mudança no slider para modo noturno
                else if(valSource >=50 && valSource <= 100){
                    guardaCliente.modo = 1;
                    guardaCliente.guarda.getStatusModoLabel().setForeground(Color.BLUE);
                    guardaCliente.guarda.getStatusModoLabel().setText("MODO NOTURNO");
                }
                
                //Informa a mudança do modo
                guardaCliente.guarda_segur.informarMudModo(guardaCliente.modo);
            }
        };
        
        guardaCliente.listenerWind = new WindowListener(){
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {
              guardaCliente.guarda_segur.desativarGuarda();   
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
