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
public class GuardaImpl extends GuardaPOA{
    boolean flagMudModo = false;
    boolean flagIniGuarda = false;
    int modo = 0;
    
    //Informa a mudança do modo - informe feito pelo guarda
    @Override
    public void informarMudModo(int modo) {
        flagMudModo = true;
        this.modo = modo;
    }

    //Verifica se houve mudança do modo - consulta feita pelo alarme
    @Override
    public boolean verificarMudModo() {
        return flagMudModo;
    }

    //Consulta qual o modo atual - consulta feita pelo alarme
    @Override
    public int consultarModo() {
        flagMudModo = false;
        return modo;
    }

    //Informa que o módulo guarda foi iniciado
    @Override
    public void iniciarGuarda() {
        flagIniGuarda = true;
    }

    //Verifica se o módulo guarda está ativo
    @Override
    public boolean verificarGuarda() {
        return flagIniGuarda;
    }

    //Informa que o módulo guarda foi desativado
    @Override
    public void desativarGuarda() {
        flagIniGuarda = false;
    }
    
}
