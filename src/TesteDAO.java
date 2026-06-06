import dao.ClienteDAO;

public class TesteDAO {

    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();

        clienteDAO.cadastrarCliente("Maria", "maria@email.com", "42999999999");

        clienteDAO.listarClientes();

    }
}