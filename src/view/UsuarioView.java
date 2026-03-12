package view;

import controller.TransacaoController;
import controller.UsuarioController;
import model.Usuario;
import service.exceptions.UsuarioNaoCadastradoException;
import view.RelatorioView;

import java.util.Scanner;

public class UsuarioView {

    private UsuarioController controller;
    private Usuario usuarioLogado;
    private Scanner scanner;
    private TransacaoController transacaoController;

    public UsuarioView(UsuarioController controller, Usuario usuario, TransacaoController transacaoController) {
        this.controller = controller;
        this.usuarioLogado = usuario;
        this.transacaoController = transacaoController;
        this.scanner = new Scanner(System.in);
    }

    public void menuUsuario() {
        int opcao;

        do {
            System.out.println("\nBem-vindo, " + usuarioLogado.getNome() + "!");
            System.out.println("1 - Ver meus dados");
            System.out.println("2 - Editar meus dados");
            System.out.println("3 - Excluir minha conta");
            System.out.println("4 - Transações");
            System.out.println("5 - Definir limite de gastos");
            System.out.println("6 - Verificar limite de gastos");
            System.out.println("7 - Relatórios");
            System.out.println("0 - Logout");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    visualizarDados();
                    break;

                case 2:
                    editarDados();
                    break;

                case 3:
                    excluirConta();
                    return;

                case 4:
                    TransacaoView transacaoView = new TransacaoView(transacaoController, usuarioLogado);
                    transacaoView.menu();
                    break;

                case 5:
                    definirLimite();
                    break;

                case 6:
                    verificarLimite();
                    break;

                case 7:
                    RelatorioView relatorioView = new RelatorioView(transacaoController, usuarioLogado);
                    relatorioView.menu();
                    break;

                case 0:
                    System.out.println("Logout realizado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void visualizarDados() {
        System.out.println("\nMEUS DADOS");
        System.out.println(usuarioLogado);
    }

    private void editarDados() {
        try {
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();
            usuarioLogado.setNome(nome);

            System.out.print("Novo e-mail: ");
            String email = scanner.nextLine();
            usuarioLogado.setEmail(email);

            controller.editar(usuarioLogado);
            System.out.println("Dados atualizados.");

        } catch (UsuarioNaoCadastradoException e) {
            System.out.println("Erro: usuário não cadastrado.");
        }
    }

    private void excluirConta() {
        try {
            controller.remover(usuarioLogado.getCpf());
            System.out.println("Conta excluída com sucesso.");
        } catch (UsuarioNaoCadastradoException e) {
            System.out.println("Erro: usuário não cadastrado.");
        }
    }

    private void definirLimite() {
        System.out.print("Digite o limite de gastos: ");
        double limite = scanner.nextDouble();
        scanner.nextLine();

        usuarioLogado.setLimiteGastos(limite);
        System.out.println("Limite de gastos definido com sucesso.");
    }

    private void verificarLimite() {
        double totalDespesas = transacaoController.totalDespesas(usuarioLogado);

        System.out.println("Limite definido: R$ " + usuarioLogado.getLimiteGastos());
        System.out.println("Total de despesas: R$ " + totalDespesas);

        if (usuarioLogado.getLimiteGastos() > 0 && totalDespesas > usuarioLogado.getLimiteGastos()) {
            System.out.println("Limite de gastos excedido!");
        } else {
            System.out.println("Gastos dentro do limite.");
        }
    }
}
