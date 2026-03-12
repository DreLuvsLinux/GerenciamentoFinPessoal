package view;

import java.util.Scanner;

import controller.TransacaoController;
import controller.UsuarioController;
import model.Usuario;
import service.exceptions.UsuarioNaoCadastradoException;

public class LoginView {

    private UsuarioController controller;
    private TransacaoController transacaoController;
    private Scanner scanner;

    public LoginView(UsuarioController controller, TransacaoController transacaoController) {
        this.controller = controller;
        this.transacaoController = transacaoController;
        this.scanner = new Scanner(System.in);
    }

    public void fazerLogin() {

        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        try {
            Usuario usuario = controller.login(cpf);

            System.out.println("Login realizado com sucesso!");

            UsuarioView usuarioView = new UsuarioView(controller, usuario, transacaoController);
            usuarioView.menuUsuario();

        } catch (UsuarioNaoCadastradoException e) {
            System.out.println("Usuário não encontrado.");
        }
    }
}
