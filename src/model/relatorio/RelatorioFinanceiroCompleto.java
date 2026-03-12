package model.relatorio;

import controller.TransacaoController;
import model.Transacao;
import model.Usuario;

public class RelatorioFinanceiroCompleto extends Relatorio {

    private TransacaoController controller;

    public RelatorioFinanceiroCompleto(TransacaoController controller) {
        this.controller = controller;
    }

    @Override
    public void gerar(Usuario usuario) {

        double saldo = controller.saldo(usuario);
        double receitas = 0;
        double despesas = 0;

        for (Transacao t : controller.listar(usuario)) {

            if (t.getTipo().equalsIgnoreCase("RECEITA")) {
                receitas += t.getValor();
            }

            if (t.getTipo().equalsIgnoreCase("DESPESA")) {
                despesas += t.getValor();
            }
        }

        System.out.println("\n   RELATÓRIO FINANCEIRO COMPLETO   ");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("----------------------------");
        System.out.println("Total de receitas: R$ " + receitas);
        System.out.println("Total de despesas: R$ " + despesas);
        System.out.println("Saldo atual: R$ " + saldo);
        System.out.println("Limite de gastos: R$ " + usuario.getLimiteGastos());
    }
}