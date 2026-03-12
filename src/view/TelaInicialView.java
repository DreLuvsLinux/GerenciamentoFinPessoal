package view;

import controller.TransacaoController;
import controller.UsuarioController;

import java.util.Scanner;

public class TelaInicialView {

    private UsuarioController controller;
    private TransacaoController transacaoController;
    private Scanner scanner;

    public TelaInicialView() {
        this.scanner = new Scanner(System.in);
        this.controller = new UsuarioController();
        this.transacaoController = new TransacaoController();
    }

    public void iniciar() {
        int opcao;

        do {
            System.out.println("\nGERENCIAMENTO FINANCEIRO PESSOAL");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Login");
            System.out.println("0 - Sair");
            System.out.print("Escolha a opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    CadastroUsuarioView cadastro = new CadastroUsuarioView(controller);
                    cadastro.cadastrarUsuario();
                    break;

                case 2:
                    LoginView loginView = new LoginView(controller, transacaoController);
                    loginView.fazerLogin();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
