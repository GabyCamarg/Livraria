package menu;

import java.util.Scanner;
import java.util.ArrayList;

import model.Cliente;
import model.Livro;

public class MenuLivraria {

    Scanner scanner = new Scanner(System.in);

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Livro> livros = new ArrayList<>();

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

        case 1:
            cadastrarCliente();
            break;

        case 2:
            listarClientes();
            break;

        case 3:
            cadastrarLivro();
            break;

        case 4:
            listarLivros();
            break;

        case 0:
            System.out.println("Encerrado");
            break;

        default:
            System.out.println("Opção inválida");
            break;
}
} while (opcao != 0);
}

public void cadastrarCliente() {

    Cliente cliente = new Cliente();

    String nome;
    String email;

    System.out.println("Cadastro de Clientes");

    do {

        System.out.println("Digite seu nome:");
        nome = scanner.nextLine();

        if(nome.isBlank()) {
            System.out.println("Nome inválido");
        }

} while(nome.isBlank());

    do {

        System.out.println("Digite seu email:");
        email = scanner.nextLine();

        if(email.isBlank() ||
        !email.contains("@") ||
        !email.contains(".")) {

            System.out.println("Email inválido");
        }

} while(email.isBlank() ||
        !email.contains("@") ||
        !email.contains("."));

        cliente.nome = nome;
        cliente.email = email;

        clientes.add(cliente);

}

public void listarClientes() {

}

public void cadastrarLivro() {

}

public void listarLivros() {

}

}