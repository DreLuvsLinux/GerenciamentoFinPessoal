package view;

import controller.UsuarioController;
import model.Usuario;
import service.exceptions.CpfInvalidoException;
import service.exceptions.DataInvalidaException;
import service.exceptions.UsuarioJaCadastradoException;
import service.exceptions.UsuarioNaoCadastradoException; // Novas exções importadas.

import java.time.LocalDate;
import java.util.Scanner;

public class UsuarioView {

    private UsuarioController controller;
    private Usuario usuarioLogado;
    private Scanner scanner;

    public UsuarioView(UsuarioController controller, Usuario usuario) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
        this.usuarioLogado = usuario; 
    }

    public void menuInicial() { // Menu inicial implementado

        int opcao;

        do {
            System.out.println("\n=== MENU USUÁRIO ===");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Login");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarUsuario();
                    break;

                case 2:
                    login();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void cadastrarUsuario() { // Cadastro de usuário implementado

        try {

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF (11 números): ");
            String cpf = scanner.nextLine();

            System.out.print("Ano de nascimento: ");
            int ano = scanner.nextInt();

            System.out.print("Mês de nascimento: ");
            int mes = scanner.nextInt();

            System.out.print("Dia de nascimento: ");
            int dia = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            Usuario usuario = new Usuario(
                    nome,
                    cpf,
                    LocalDate.of(ano, mes, dia),
                    email
            );

            controller.adicionar(usuario);

            System.out.println("Usuário cadastrado com sucesso!");

        } catch (UsuarioJaCadastradoException e) {
            System.out.println("Erro: usuário já cadastrado.");

        } catch (CpfInvalidoException e) {
            System.out.println("Erro: CPF inválido.");

        } catch (DataInvalidaException e) {
            System.out.println("Erro: data de nascimento inválida.");
        }
    }

    private void login() { // Login implementado

        try {

            System.out.print("Digite o CPF: ");
            String cpf = scanner.nextLine();

            usuarioLogado = controller.login(cpf);

            menuUsuario();

        } catch (UsuarioNaoCadastradoException e) {

            System.out.println("Erro: usuário não encontrado.");
        }
    }

    public void menuUsuario() {

        int opcao;

        do {
            System.out.println("\nBem-vindo, " + usuarioLogado.getNome() + "!");
            System.out.println("1 - Ver meus dados");
            System.out.println("2 - Editar meus dados");
            System.out.println("3 - Excluir minha conta");
            System.out.println("4 - Transações");
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
                    TransacaoView transacaoView = new TransacaoView(); // Transacao adicionada no menu de usuário
                    transacaoView.menu();
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

            System.out.println("Erro: usuário não encontrado."); // Como é um programa de console vou substituir esse log por um println comúm para ficar menos técnico a o Usuário
        }
    }

    private void excluirConta() {

        try {

            controller.remover(usuarioLogado.getCpf());

            System.out.println("Conta excluída com sucesso.");

        } catch (UsuarioNaoCadastradoException e) {

            System.out.println("Erro: usuário não encontrado.");
        }
    }
}
