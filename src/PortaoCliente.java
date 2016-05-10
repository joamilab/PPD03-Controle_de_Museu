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

import Portao.JanelaGUI.*;
import Portao.Controle.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

/**
 *
 * @author Joamila
 * Criado em: 18/04/2016
 * Última atualização em: 24/04/2016
 */
public class PortaoCliente {
    PortaoGUI portao;
    PortaoAcesso portaoAcesso = new PortaoAcesso();
    private int qtdVisitantes;
    ActionListener listenerActionPerf;
    KeyListener listenerKey;
    Portao portao_entrada;
    Guarda guarda_segur;
    
    public PortaoCliente(){
        qtdVisitantes = 0;
        portao = new PortaoGUI();
        portao.setVisible(true);
    }
    
    /**
     * Inicia o listener dos compenentes 
     * @param portaoGUI PortaoGUI
     * @param listenerAct ActionListener
     */
    public void iniciarListenerComponents(PortaoGUI portaoGUI, ActionListener listenerAct){
        portaoGUI.getEntrarButton().addActionListener(listenerAct);
        portaoGUI.getSairButton().addActionListener(listenerAct);
    }
    
    public static void main (String args[]){
        final PortaoCliente portaoCliente = new PortaoCliente();
        
        ORB orb = ORB.init(args, null);
        try {
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
            NamingContext naming = NamingContextHelper.narrow(obj);
            
            //Interface Portao
            NameComponent[] name = {new NameComponent("Portao", "portaoMuseu")};
            org.omg.CORBA.Object objRef = naming.resolve(name);
            naming.rebind(name, objRef);
            portaoCliente.portao_entrada = PortaoHelper.narrow(objRef);
            
            //Interface Guarda
            NameComponent[] nameG = {new NameComponent("Guarda", "guardaMuseu")};
            org.omg.CORBA.Object objRefG = naming.resolve(nameG);
            naming.rebind(nameG, objRefG);
            portaoCliente.guarda_segur = GuardaHelper.narrow(objRefG);
            
        } catch (InvalidName ex) {
            Logger.getLogger(PortaoServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(PortaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Thread thread;
        thread = new Thread(new Runnable(){
            @Override
            public void run() {
                //Configuração inicial 
                portaoCliente.portaoAcesso.iniciarContador(portaoCliente.portao);
                portaoCliente.iniciarListenerComponents(portaoCliente.portao, portaoCliente.listenerActionPerf);
            }
            
        });
        
        portaoCliente.listenerActionPerf = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               java.lang.Object obj = e.getSource();
               //Identifica entrada de pessoas
               if(obj.equals(portaoCliente.portao.getEntrarButton())){
                   if(portaoCliente.qtdVisitantes<9999 && portaoCliente.guarda_segur.verificarGuarda()){
                       portaoCliente.qtdVisitantes += 1;
                       portaoCliente.portao_entrada.registrarEntrada();
                   }
               }
               //Identifica saída de pessoas
               else{
                   if(portaoCliente.qtdVisitantes>0 && portaoCliente.guarda_segur.verificarGuarda()){
                       portaoCliente.qtdVisitantes -=1;
                       portaoCliente.portao_entrada.registrarSaida();
                   }   
               }
               
               //Atualiza o contador
               portaoCliente.portaoAcesso.atualizarContador(portaoCliente.portao, portaoCliente.qtdVisitantes);
            }
        };
        
        thread.start();
    }
    
}
