package model.relatorio;

import controller.TransacaoController;
import model.Transacao;
import model.Usuario;

public class RelatorioReceitas extends Relatorio {

    private TransacaoController controller;

    public RelatorioReceitas(TransacaoController controller) {
        this.controller = controller;
    }

    @Override
    public void gerar(Usuario usuario) {

        System.out.println("\n=== RELATÓRIO DE RECEITAS ===");

        for (Transacao t : controller.listar(usuario)) {
            if (t.getTipo().equalsIgnoreCase("RECEITA")) {
                System.out.println(t);
            }
        }
    }
}