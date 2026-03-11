package view;

import controller.TransacaoController;
import model.Transacao;

import java.util.Scanner;

public class TransacaoView {

    private TransacaoController controller = new TransacaoController();
    private Scanner sc = new Scanner(System.in);

    public void menu(){

        int op;

        do{

            System.out.println("\n=== TRANSAÇÕES ===");
            System.out.println("1 - Registrar transação");
            System.out.println("2 - Ver saldo");
            System.out.println("3 - Listar transações");
            System.out.println("0 - Sair");

            op = sc.nextInt();
            sc.nextLine();

            switch(op){

                case 1:
                    registrar();
                    break;

                case 2:
                    System.out.println("Saldo: " + controller.saldo());
                    break;

                case 3:
                    for(Transacao t : controller.listar()){
                        System.out.println(t);
                    }
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        }while(op != 0);
    }

    private void registrar(){

        System.out.println("Valor:");
        double valor = sc.nextDouble();
        sc.nextLine();

        System.out.println("Descrição:");
        String desc = sc.nextLine();

        System.out.println("Tipo (RECEITA/DESPESA):");
        String tipo = sc.nextLine();

        Transacao t = new Transacao(
                valor,
                desc,
                tipo
        );

        controller.registrar(t);

        System.out.println("Transação registrada com sucesso.");
    }
}