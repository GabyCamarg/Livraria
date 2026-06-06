package menu;

import java.util.Scanner;

public class MenuLivraria {

    Scanner scanner = new Scanner(System.in);

    int opcao;

    public void iniciar() {

        do {

            System.out.println("======================");
            System.out.println("      LIVRARIA");
            System.out.println("======================");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Cadastrar Livro");
            System.out.println("4 - Listar Livros");
            System.out.println("0 - Sair");
            System.out.println("======================");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

        switch (opcao) {

            case 0:
                System.out.println("Encerrado");
                break;

            default:
                System.out.println("Opção inválida");
                break;

}
} while (opcao != 0);
}

}