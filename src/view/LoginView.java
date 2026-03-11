package view;

import java.util.Scanner;
import controller.UsuarioController;
import model.Usuario;

public class LoginView {

    private UsuarioController controller;
    private Scanner scanner;

    public LoginView(UsuarioController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void fazerLogin() {

        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        Usuario usuario = controller.consultar(cpf);

        if(usuario != null) {

            System.out.println("Login realizado com sucesso!");

            UsuarioView usuarioView = new UsuarioView(controller, usuario);
            usuarioView.menuUsuario();

        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

}
