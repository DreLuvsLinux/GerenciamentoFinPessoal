package model.relatorio;

import controller.TransacaoController;
import model.Transacao;
import model.Usuario;

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

