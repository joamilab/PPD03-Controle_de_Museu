/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joamila
 * Criado em: 18/04/2016
 * Última atualização em: 24/04/2016
 */
public class AlarmeImpl extends AlarmePOA{
    boolean flagInvasao = false;
    boolean flagIniAlarme = false;
    int modo = 0;

    //Verifica se houve invasão - consulta feita pelo guarda
    @Override
    public boolean verificarInvasao() {
        if(flagInvasao){
            flagInvasao = false;
            return true;
        }
        else 
            return false;
    }    

    //Informa que houve uma invasão - informe feito pelo alarme
    @Override
    public void informarInvasao() {
        flagInvasao = true;
    }

    //Avisa que o módulo alarme foi iniciado
    @Override
    public void iniciarAlarme() {
        flagIniAlarme = true;
    }

    //Avisa que o módulo alarme foi desativado
    @Override
    public void desativarAlarme() {
        flagIniAlarme = false;
    }

    //Verifica se o módulo alarme está ativo
    @Override
    public boolean verificarAlarme() {
        return flagIniAlarme;
    }
}
