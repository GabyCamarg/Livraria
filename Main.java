import model.Cliente;
import model.Livro;
import model.Pedido;
import model.ItemPedido;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Livro> livros = new ArrayList<>();

    ArrayList<Pedido> pedidos = new ArrayList<>();
    ArrayList<ItemPedido> itensPedido = new ArrayList<>();

    int idPedido = 0;
    int idItem = 0;
}

public void menu() {

        Scanner sc = new Scanner(System.in);
        int opcao;

         do {
            System.out.println("==== MENU LIVRARIA ====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Cadastrar Livro");
            System.out.println("4 - Listar Livros");
            System.out.println("5 - Criar Pedido");
            System.out.println("6 - Listar Pedidos");
            System.out.println("0 - Sair");

             opcao = sc.nextInt();

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