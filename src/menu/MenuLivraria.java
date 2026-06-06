package menu;

import java.util.Scanner;
import java.util.ArrayList;

import model.Cliente;
import model.Livro;
import model.Pedido;
import model.ItemPedido;
import model.CategoriaLivro;
import model.StatusPedido;
import dao.PedidoDAO;
import dao.ClienteDAO;
import dao.LivroDAO;

public class MenuLivraria {

    Scanner scanner = new Scanner(System.in);

    ClienteDAO clienteDAO = new ClienteDAO();
    LivroDAO livroDAO = new LivroDAO();
    PedidoDAO pedidoDAO = new PedidoDAO();

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Livro> livros = new ArrayList<>();
    ArrayList<Pedido> pedidos = new ArrayList<>();
    ArrayList<ItemPedido> itensPedido = new ArrayList<>();

    int opcao;
    int idCliente = 0;
    int idLivro = 0;
    int idPedido = 0;
    int idItem = 0;

    public void iniciar() {

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

        idCliente++;
        cliente.id = idCliente;

        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso!");

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

    livro.titulo = titulo;
    livro.autor = autor;
    livro.preco = preco;
    livro.estoque = estoque;

    idLivro++;
    livro.id = idLivro;

    livros.add(livro);

        System.out.println("Livro cadastrado com sucesso!");

}

public void listarLivros() {
    livroDAO.listarLivros();
}
public void criarPedido() {

    Pedido pedido = new Pedido();
    ItemPedido item = new ItemPedido();

    int idClientePedido;
    int idLivroPedido;
    int quantidade;

    Cliente clienteEscolhido = null;
    Livro livroEscolhido = null;

    System.out.println("Digite o ID do cliente:");
    idClientePedido = scanner.nextInt();

    for(Cliente clienteAtual : clientes) {
        if(clienteAtual.id == idClientePedido) {
            clienteEscolhido = clienteAtual;
        }
    }

    if(clienteEscolhido == null) {
        System.out.println("Cliente não encontrado.");
        scanner.nextLine();
        return;
    }

    System.out.println("Digite o ID do livro:");
    idLivroPedido = scanner.nextInt();

    for(Livro livroAtual : livros) {
        if(livroAtual.id == idLivroPedido) {
            livroEscolhido = livroAtual;
        }
    }

    if(livroEscolhido == null) {
        System.out.println("Livro não encontrado.");
        scanner.nextLine();
        return;
    }

    System.out.println("Digite a quantidade:");
    quantidade = scanner.nextInt();
    scanner.nextLine();

    if(quantidade <= 0) {
        System.out.println("Quantidade inválida.");
        return;
    }

    if(livroEscolhido.estoque < quantidade) {
        System.out.println("Estoque insuficiente.");
        return;
    }

    livroEscolhido.estoque -= quantidade;

    idPedido++;
    pedido.id = idPedido;
    pedido.idCliente = clienteEscolhido.id;
    pedido.nomeCliente = clienteEscolhido.nome;
    pedido.status = StatusPedido.FILA;

    idItem++;
    item.id = idItem;
    item.idPedido = pedido.id;
    item.idLivro = livroEscolhido.id;
    item.tituloLivro = livroEscolhido.titulo;
    item.quantidade = quantidade;
    item.valorUnitario = livroEscolhido.preco;

    pedidos.add(pedido);
    itensPedido.add(item);

    System.out.println("Pedido criado com sucesso!");
    System.out.println("Status: " + pedido.status);
}

public void listarPedidos() {

    if(pedidos.isEmpty()) {
        System.out.println("Nenhum pedido cadastrado.");
    } else {

        for(Pedido pedidoAtual : pedidos) {

            System.out.println("----------------------------");
            System.out.println("Pedido ID: " + pedidoAtual.id);
            System.out.println("Cliente: " + pedidoAtual.nomeCliente);
            System.out.println("Status: " + pedidoAtual.status);

            for(ItemPedido itemAtual : itensPedido) {

                if(itemAtual.idPedido == pedidoAtual.id) {
                    System.out.println("Livro: " + itemAtual.tituloLivro);
                    System.out.println("Quantidade: " + itemAtual.quantidade);
                    System.out.println("Valor unitário: " + itemAtual.valorUnitario);
                    System.out.println("Total: " + (itemAtual.quantidade * itemAtual.valorUnitario));
                }

            }

            System.out.println("----------------------------");
        }
    }
}

}