package model.relatorio;

import controller.TransacaoController;
import model.Transacao;
import model.Usuario;

/**
Implementação de relatório responsável por listar
todas as receitas registradas pelo usuário.

O relatório percorre as transações do usuário e exibe
apenas aquelas classificadas como receita.

Esta classe demonstra o uso de herança ao estender
a classe abstrata Relatorio. @João Pedro */

public class RelatorioDespesas extends Relatorio { // HERANÇA!!!!

    private TransacaoController controller;

    public RelatorioDespesas(TransacaoController controller) {
        this.controller = controller;
    }

    @Override
    public void gerar(Usuario usuario) {

        System.out.println("\n    RELATÓRIO DE DESPESAS    ");

        for (Transacao t : controller.listar(usuario)) {
            if (t.getTipo().equalsIgnoreCase("DESPESA")) {
                System.out.println(t);
            }
        }
    }

}
