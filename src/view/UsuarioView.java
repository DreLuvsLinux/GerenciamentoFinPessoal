package view;

import controller.UsuarioController;
import java.util.Scanner;
import model.Usuario;
import service.UsuarioNaoCadastradoException;

public class UsuarioView {

    private UsuarioController controller;
    private Usuario usuarioLogado;
    private Scanner scanner;

    public UsuarioView(UsuarioController controller, Usuario usuario) {
        this.controller = controller;
        this.usuarioLogado = usuario;
        scanner = new Scanner(System.in);
    }

    public void menuUsuario() {
        int opcao;

        do {
            System.out.println("\nBem-vindo, " + usuarioLogado.getNome() + "!");
            System.out.println("1 - Ver meus dados");
            System.out.println("2 - Editar meus dados");
            System.out.println("3 - Excluir minha conta");
            System.out.println("0 - Logout");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    visualizarDados();
                    break;

                case 2:
                    editarDados();
                    break;

                case 3:
                    excluirConta();
                    return;

                case 0:
                    System.out.println("Logout realizado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while(opcao != 0);
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

        } catch (UsuarioNaoCadastradoException ex) {
            System.getLogger(UsuarioView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    private void excluirConta() {

        try {
            controller.remover(usuarioLogado.getCpf());
        } catch (UsuarioNaoCadastradoException e) {
            e.printStackTrace();
        }

        System.out.println("Conta excluída com sucesso.");
    }

}
