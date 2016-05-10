/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Portao.Controle;

import Portao.JanelaGUI.*;

/**
 *
 * @author Joamila
 * Criado em: 18/04/2016
 * Última atualização em: 18/04/2016
 */
public class PortaoAcesso {
    String num0Image = "/Portao/JanelaGUI/number0.png";
    String num1Image = "/Portao/JanelaGUI/number1.png";
    String num2Image = "/Portao/JanelaGUI/number2.png";
    String num3Image = "/Portao/JanelaGUI/number3.png";
    String num4Image = "/Portao/JanelaGUI/number4.png";
    String num5Image = "/Portao/JanelaGUI/number5.png";
    String num6Image = "/Portao/JanelaGUI/number6.png";
    String num7Image = "/Portao/JanelaGUI/number7.png";
    String num8Image = "/Portao/JanelaGUI/number8.png";
    String num9Image = "/Portao/JanelaGUI/number9.png";
    
    /**
     * Inicia o contador com todos os mostradores em 0
     * @param portaoGUI PortaoGUI 
     */
    public void iniciarContador(PortaoGUI portaoGUI){
        portaoGUI.getMilharContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
        portaoGUI.getCentenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
        portaoGUI.getDezenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
        portaoGUI.getUnidadeContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
    }
    
    /**
     * Atualiza os mostradores com o número de visitantes no momento
     * @param portaoGUI PortaoGUI
     * @param numero int
     */
    public void atualizarContador(PortaoGUI portaoGUI, int numero){
        int num_aux = numero;
        int unidade = num_aux%10;
        num_aux = num_aux/10;  
        int dezena = num_aux%10;
        num_aux = num_aux/10; 
        int centena = num_aux%10;
        int milhar = num_aux/10;
        
        switch(unidade){
            case 0: 
                portaoGUI.getUnidadeContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
                break;
            case 1: 
                portaoGUI.getUnidadeContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num1Image)));
                break;
            case 2:
                portaoGUI.getUnidadeContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num2Image)));
                break;
            case 3:
                portaoGUI.getUnidadeContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num3Image)));
                break;
            case 4:
                portaoGUI.getUnidadeContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num4Image)));
                break;
            case 5:
                portaoGUI.getUnidadeContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num5Image)));
                break;
            case 6:
                portaoGUI.getUnidadeContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num6Image)));
                break;
            case 7:
                portaoGUI.getUnidadeContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num7Image)));
                break;
            case 8:
                portaoGUI.getUnidadeContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num8Image)));
                break;
            case 9:
                portaoGUI.getUnidadeContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num9Image)));
                break;
        }
        
        switch(dezena){
            case 0: 
                portaoGUI.getDezenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
                break;
            case 1: 
                portaoGUI.getDezenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num1Image)));
                break;
            case 2:
                portaoGUI.getDezenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num2Image)));
                break;
            case 3:
                portaoGUI.getDezenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num3Image)));
                break;
            case 4:
                portaoGUI.getDezenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num4Image)));
                break;
            case 5:
                portaoGUI.getDezenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num5Image)));
                break;
            case 6:
                portaoGUI.getDezenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num6Image)));
                break;
            case 7:
                portaoGUI.getDezenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num7Image)));
                break;
            case 8:
                portaoGUI.getDezenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num8Image)));
                break;
            case 9:
                portaoGUI.getDezenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num9Image)));
                break;
        }
        
        switch(centena){
            case 0: 
                portaoGUI.getCentenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
                break;
            case 1: 
                portaoGUI.getCentenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num1Image)));
                break;
            case 2:
                portaoGUI.getCentenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num2Image)));
                break;
            case 3:
                portaoGUI.getCentenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num3Image)));
                break;
            case 4:
                portaoGUI.getCentenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num4Image)));
                break;
            case 5:
                portaoGUI.getCentenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num5Image)));
                break;
            case 6:
                portaoGUI.getCentenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num6Image)));
                break;
            case 7:
                portaoGUI.getCentenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num7Image)));
                break;
            case 8:
                portaoGUI.getCentenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num8Image)));
                break;
            case 9:
                portaoGUI.getCentenaContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num9Image)));
                break;
        }
        
         switch(milhar){
            case 0: 
                portaoGUI.getMilharContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
                break;
            case 1: 
                portaoGUI.getMilharContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num1Image)));
                break;
            case 2:
                portaoGUI.getMilharContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num2Image)));
                break;
            case 3:
                portaoGUI.getMilharContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num3Image)));
                break;
            case 4:
                portaoGUI.getMilharContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num4Image)));
                break;
            case 5:
                portaoGUI.getMilharContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num5Image)));
                break;
            case 6:
                portaoGUI.getMilharContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num6Image)));
                break;
            case 7:
                portaoGUI.getMilharContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num7Image)));
                break;
            case 8:
                portaoGUI.getMilharContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num8Image)));
                break;
            case 9:
                portaoGUI.getMilharContLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num9Image)));
                break;
        }
    }
}
