/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Joamila
 * Criado em: 18/04/2016
 * Última atualização em: 19/04/2016
 */
public class PortaoImpl extends PortaoPOA{
    boolean flagEntrou = false;
    boolean flagSaiu = false;
    int qtdVisitantes = 0;
    
    //Verifica entrada no museu - consulta feita pelo guarda
    @Override
    public boolean verificarEntrada() {
        if(flagEntrou){
            flagEntrou = false;
            return true;
        }
        else
            return false;    
    }

    //Verifica saída do museu - consulta feita pelo guarda
    @Override
    public boolean verificarSaida() {
        if(flagSaiu){
            flagSaiu = false;
            return true;
        }
        else
            return false;
    }  

    //Registra entrada no museu - informe feito pelo portão
    @Override
    public void registrarEntrada() {
        flagEntrou = true;
        qtdVisitantes += 1;
    }

    //Registra saída do museu - informe feito pelo portão
    @Override
    public void registrarSaida() {
        flagSaiu = true;
        qtdVisitantes -=1;
    }

    //Verifica quantidade de visitantes no momento - consulta feita pelo guarda e alarme
    @Override
    public int verificarVisitantes() {
        return qtdVisitantes;
    }
}
