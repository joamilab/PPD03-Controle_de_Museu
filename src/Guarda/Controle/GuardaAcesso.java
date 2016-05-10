/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guarda.Controle;

import Guarda.JanelaGUI.*;

/**
 *
 * @author Joamila
 * Criado em: 18/04/2016
 * Última atualização em: 19/04/2016
 */
public class GuardaAcesso {
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
     * @param guardaGUI GuardaGUI
     */
    public void iniciarContador(GuardaGUI guardaGUI){
        guardaGUI.getMilharLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
        guardaGUI.getCentenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
        guardaGUI.getDezenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
        guardaGUI.getUnidadeLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
    }
    
    /**
     * Atualiza os mostradores com o número de visitantes no momento
     * @param guardaGUI GuardaGUI
     * @param numero int
     */
    public void atualizarContador(GuardaGUI guardaGUI, int numero){
        int num_aux = numero;
        int unidade = num_aux%10;
        num_aux = num_aux/10;  
        int dezena = num_aux%10;
        num_aux = num_aux/10; 
        int centena = num_aux%10;
        int milhar = num_aux/10;
        
        switch(unidade){
            case 0: 
                guardaGUI.getUnidadeLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
                break;
            case 1: 
                guardaGUI.getUnidadeLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num1Image)));
                break;
            case 2:
                guardaGUI.getUnidadeLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num2Image)));
                break;
            case 3:
                guardaGUI.getUnidadeLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num3Image)));
                break;
            case 4:
                guardaGUI.getUnidadeLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num4Image)));
                break;
            case 5:
                guardaGUI.getUnidadeLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num5Image)));
                break;
            case 6:
                guardaGUI.getUnidadeLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num6Image)));
                break;
            case 7:
                guardaGUI.getUnidadeLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num7Image)));
                break;
            case 8:
                guardaGUI.getUnidadeLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num8Image)));
                break;
            case 9:
                guardaGUI.getUnidadeLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num9Image)));
                break;
        }
        
        switch(dezena){
            case 0: 
                guardaGUI.getDezenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
                break;
            case 1: 
                guardaGUI.getDezenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num1Image)));
                break;
            case 2:
                guardaGUI.getDezenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num2Image)));
                break;
            case 3:
                guardaGUI.getDezenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num3Image)));
                break;
            case 4:
                guardaGUI.getDezenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num4Image)));
                break;
            case 5:
                guardaGUI.getDezenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num5Image)));
                break;
            case 6:
                guardaGUI.getDezenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num6Image)));
                break;
            case 7:
                guardaGUI.getDezenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num7Image)));
                break;
            case 8:
                guardaGUI.getDezenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num8Image)));
                break;
            case 9:
                guardaGUI.getDezenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num9Image)));
                break;
        }
        
        switch(centena){
            case 0: 
                guardaGUI.getCentenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
                break;
            case 1: 
                guardaGUI.getCentenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num1Image)));
                break;
            case 2:
                guardaGUI.getCentenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num2Image)));
                break;
            case 3:
                guardaGUI.getCentenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num3Image)));
                break;
            case 4:
                guardaGUI.getCentenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num4Image)));
                break;
            case 5:
                guardaGUI.getCentenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num5Image)));
                break;
            case 6:
                guardaGUI.getCentenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num6Image)));
                break;
            case 7:
                guardaGUI.getCentenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num7Image)));
                break;
            case 8:
                guardaGUI.getCentenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num8Image)));
                break;
            case 9:
                guardaGUI.getCentenaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num9Image)));
                break;
        }
        
         switch(milhar){
            case 0: 
                guardaGUI.getMilharLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num0Image)));
                break;
            case 1: 
                guardaGUI.getMilharLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num1Image)));
                break;
            case 2:
                guardaGUI.getMilharLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num2Image)));
                break;
            case 3:
                guardaGUI.getMilharLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num3Image)));
                break;
            case 4:
                guardaGUI.getMilharLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num4Image)));
                break;
            case 5:
                guardaGUI.getMilharLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num5Image)));
                break;
            case 6:
                guardaGUI.getMilharLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num6Image)));
                break;
            case 7:
                guardaGUI.getMilharLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num7Image)));
                break;
            case 8:
                guardaGUI.getMilharLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num8Image)));
                break;
            case 9:
                guardaGUI.getMilharLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(num9Image)));
                break;
        }
    }   
}
