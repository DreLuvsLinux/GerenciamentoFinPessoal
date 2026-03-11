package view;

import controller.UsuarioController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.Usuario;

public class CadastroUsuarioView {
    
    private UsuarioController controller;
    private Scanner scanner;

    public CadastroUsuarioView(UsuarioController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void cadastrarUsuario() {
        try {

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine();

            System.out.print("Data de nascimento (DD/MM/AAAA): ");
            String dataTexto = scanner.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNascimento = LocalDate.parse(dataTexto, formatter);

            System.out.print("Email: ");
            String email = scanner.nextLine();

            Usuario usuario = new Usuario(nome, cpf, dataNascimento, email);
            controller.adicionar(usuario);

            System.out.println("Usuário cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
