package menu;

import java.util.Scanner;


import model.Livro;
import model.CategoriaLivro;
import dao.PedidoDAO;
import dao.ClienteDAO;
import dao.LivroDAO;
import service.ProcessadorPedidos;

public class MenuLivraria {

    Scanner scanner = new Scanner(System.in);

    ClienteDAO clienteDAO = new ClienteDAO();
    LivroDAO livroDAO = new LivroDAO();
    PedidoDAO pedidoDAO = new PedidoDAO();
    ProcessadorPedidos processador = new ProcessadorPedidos();

    int opcao;

    public void iniciar() {

        processador.start();

        do {

            System.out.println("======================");
            System.out.println("      LIVRARIA");
            System.out.println("======================");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Cadastrar Livro");
            System.out.println("4 - Listar Livros");
            System.out.println("5 - Criar Pedido");
            System.out.println("6 - Listar Pedidos");
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

        case 5:
            criarPedido();
            break;

        case 6:
            listarPedidos();
            break;

        case 0:
            processador.encerrar();
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

        System.out.println("Digite seu telefone:");
        String telefone = scanner.nextLine();

        clienteDAO.cadastrarCliente(nome, email, telefone);

}

public void listarClientes() {
    clienteDAO.listarClientes();
}

public void cadastrarLivro() {

    Livro livro = new Livro();

    String titulo;
    String autor;
    double preco;
    int estoque;

    System.out.println("Cadastro de Livros");

    do {

        System.out.println("Digite o título:");
        titulo = scanner.nextLine();

        if(titulo.isBlank()) {
            System.out.println("Título inválido");
        }

} while(titulo.isBlank());

    do {

        System.out.println("Digite o autor:");
        autor = scanner.nextLine();

        if(autor.isBlank()) {
            System.out.println("Autor inválido");
        }

} while(autor.isBlank());

    do {

        System.out.println("Digite o preço:");
        preco = scanner.nextDouble();

        if(preco <= 0) {
            System.out.println("Preço inválido");
        }

} while(preco <= 0);

    do {

        System.out.println("Digite o estoque:");
        estoque = scanner.nextInt();
        scanner.nextLine();

        if(estoque < 0) {
            System.out.println("Estoque inválido");
        }

} while(estoque < 0);

    System.out.println("Categorias:");
    System.out.println("1 - ROMANCE");
    System.out.println("2 - INFANTIL");
    System.out.println("3 - FICCAO");
    System.out.println("4 - TECNOLOGIA");
    System.out.println("5 - TERROR");

    int opcaoCategoria = scanner.nextInt();
    scanner.nextLine();

    switch(opcaoCategoria) {

        case 1:
            livro.categoria = CategoriaLivro.ROMANCE;
            break;

        case 2:
            livro.categoria = CategoriaLivro.INFANTIL;
            break;

        case 3:
            livro.categoria = CategoriaLivro.FICCAO;
            break;

        case 4:
            livro.categoria = CategoriaLivro.TECNOLOGIA;
            break;

        case 5:
            livro.categoria = CategoriaLivro.TERROR;
            break;

        default:
            livro.categoria = CategoriaLivro.FICCAO;
            break;
}

    livroDAO.cadastrarLivro(
    titulo,
    autor,
    preco,
    estoque,
    livro.categoria.name()
);

}

public void listarLivros() {
    livroDAO.listarLivros();
}
public void criarPedido() {

    int idCliente;
    int idLivro;
    int quantidade;

    System.out.println("Digite o ID do cliente:");
    idCliente = scanner.nextInt();

    System.out.println("Digite o ID do livro:");
    idLivro = scanner.nextInt();

    System.out.println("Digite a quantidade:");
    quantidade = scanner.nextInt();
    scanner.nextLine();

    pedidoDAO.criarPedido(idCliente, idLivro, quantidade);
}

public void listarPedidos() {
    pedidoDAO.listarPedidos();
}

}
