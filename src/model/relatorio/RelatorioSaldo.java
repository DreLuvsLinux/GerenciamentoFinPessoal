package model.relatorio;

import controller.TransacaoController;
import model.Usuario;

public class RelatorioSaldo extends Relatorio {

    private TransacaoController controller;

    public RelatorioSaldo(TransacaoController controller) {
        this.controller = controller;
    }

    @Override
    public void gerar(Usuario usuario) {
        double saldo = controller.saldo(usuario);

        System.out.println("\n    RELATÓRIO DE SALDO    ");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Saldo atual: R$ " + saldo);
    }
}