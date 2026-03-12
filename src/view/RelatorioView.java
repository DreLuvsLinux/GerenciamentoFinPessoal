package view;

import java.util.Scanner;

import controller.TransacaoController;
import model.Usuario;
import model.relatorio.*;

/**
Classe responsável pela interface de interação com o usuário
para geração de relatórios financeiros.

Através desta classe o usuário pode selecionar diferentes
tipos de relatórios disponíveis no sistema, como relatório
de saldo, receitas, despesas ou resumo financeiro.

A seleção do relatório demonstra o uso de polimorfismo,
pois diferentes implementações da classe Relatorio podem
ser utilizadas através da mesma referência. @João Pedro*/

public class RelatorioView {

    private Scanner scanner;
    private TransacaoController controller;
    private Usuario usuario;

    public RelatorioView(TransacaoController controller, Usuario usuario) {
        this.scanner = new Scanner(System.in);
        this.controller = controller;
        this.usuario = usuario;
    }

    public void menu() {

        int op;

        do {

            System.out.println("\n    RELATÓRIOS:    ");
            System.out.println("1 - Relatório de saldo");
            System.out.println("2 - Relatório de receitas");
            System.out.println("3 - Relatório de despesas");
            System.out.println("4 - Relatório financeiro completo");
            System.out.println("0 - Voltar");

            op = scanner.nextInt();
            scanner.nextLine();

            Relatorio relatorio = null; // POLIMORFISMO (sobrescrita) !!

            switch (op) {

                case 1:
                    relatorio = new RelatorioSaldo(controller);
                    break;

                case 2:
                    relatorio = new RelatorioReceitas(controller);
                    break;

                case 3:
                    relatorio = new RelatorioDespesas(controller);
                    break;

                case 4:
                    relatorio = new RelatorioFinanceiroCompleto(controller);
                    break;      

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

            if (relatorio != null) {
                relatorio.gerar(usuario); // Método gerar()
            }

        } while (op != 0);
    }

}


