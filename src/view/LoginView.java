package view;

import java.util.Scanner;
import controller.UsuarioController;
import model.Usuario;
import service.exceptions.UsuarioNaoCadastradoException; // adicionando o lançamento caso usucario nao seja encontrado

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

        try {
            
            Usuario usuario = controller.consultar(cpf);

            System.out.println("Login realizado com sucesso!");

            UsuarioView usuarioView = new UsuarioView(controller, usuario);
            usuarioView.menuUsuario();

        } catch (UsuarioNaoCadastradoException e) {

            System.out.println("Usuário não encontrado.");
        }
    }
}
