package view;

import controller.TransacaoController;
import model.Transacao;
import model.Usuario;

import java.util.List;
import java.util.Scanner;

public class TransacaoView {

    private TransacaoController controller;
    private Usuario usuarioLogado;
    private Scanner sc;

    public TransacaoView(TransacaoController controller, Usuario usuarioLogado) {
        this.controller = controller;
        this.usuarioLogado = usuarioLogado;
        this.sc = new Scanner(System.in);
    }

    public void menu() {

        int op;

        do {
            System.out.println("\n   TRANSAÇÕES:   ");
            System.out.println("1 - Registrar transação");
            System.out.println("2 - Ver saldo");
            System.out.println("3 - Listar transações");
            System.out.println("4 - Remover transação");
            System.out.println("0 - Sair");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    registrar();
                    break;

                case 2:
                    System.out.println("Saldo: R$ " + controller.saldo(usuarioLogado));
                    break;

                case 3:
                    listar();
                    break;

                case 4:
                    remover();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (op != 0);
    }

    private void registrar() {

        System.out.println("Valor:");
        double valor = sc.nextDouble();
        sc.nextLine();

        System.out.println("Descrição:");
        String desc = sc.nextLine();

        System.out.println("Tipo (RECEITA/DESPESA):");
        String tipo = sc.nextLine();

        Transacao t = new Transacao(desc, valor, tipo);

        String resultado = controller.registrar(usuarioLogado, t);

        switch (resultado) {
            case "BLOQUEADA":
                System.out.println("Despesa bloqueada: valor acima do limite definido.");
                break;

            case "ATINGIU_LIMITE":
                System.out.println("Transação registrada com sucesso.");
                System.out.println("Aviso: esta despesa atingiu exatamente o limite definido.");
                System.out.println("A próxima despesa desse valor ultrapassará o limite.");
                break;

            case "PROXIMA_DO_LIMITE":
                System.out.println("Transação registrada com sucesso.");
                System.out.println("Aviso: esta despesa está próxima do limite definido.");
                break;

            default:
                System.out.println("Transação registrada com sucesso.");
        }
    }

    private void listar() {
        List<Transacao> transacoes = controller.listar(usuarioLogado);

        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação cadastrada.");
            return;
        }

        for (int i = 0; i < transacoes.size(); i++) {
            System.out.println(i + " - " + transacoes.get(i));
        }
    }

    private void remover() {
        listar();

        System.out.print("Digite o índice da transação a remover: ");
        int indice = sc.nextInt();
        sc.nextLine();

        controller.remover(usuarioLogado, indice);
        System.out.println("Transação removida.");
    }
}
