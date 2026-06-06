package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PedidoDAO {

    public void listarPedidos() {

        String sql = """
            SELECT 
                p.id_pedido,
                c.nome AS cliente,
                p.status,
                l.titulo AS livro,
                i.quantidade,
                i.valor_unitario,
                (i.quantidade * i.valor_unitario) AS total
            FROM pedido p
            INNER JOIN cliente c ON p.id_cliente = c.id_cliente
            INNER JOIN item_pedido i ON p.id_pedido = i.id_pedido
            INNER JOIN livro l ON i.id_livro = l.id_livro
            ORDER BY p.id_pedido
        """;

        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("----------------------------");
                System.out.println("Pedido: " + rs.getInt("id_pedido"));
                System.out.println("Cliente: " + rs.getString("cliente"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("Livro: " + rs.getString("livro"));
                System.out.println("Quantidade: " + rs.getInt("quantidade"));
                System.out.println("Valor unitário: " + rs.getDouble("valor_unitario"));
                System.out.println("Total: " + rs.getDouble("total"));
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void criarPedido(int idCliente, int idLivro, int quantidade) {

    try {

        Connection conn = Conexao.conectar();

        conn.setAutoCommit(false);

        String sqlEstoque = "SELECT estoque, preco FROM livro WHERE id_livro = ?";

        PreparedStatement stmtEstoque = conn.prepareStatement(sqlEstoque);
        stmtEstoque.setInt(1, idLivro);

        ResultSet rs = stmtEstoque.executeQuery();

        if(!rs.next()) {
            System.out.println("Livro não encontrado.");
            conn.rollback();
            conn.close();
            return;
        }

        int estoqueAtual = rs.getInt("estoque");
        double preco = rs.getDouble("preco");

        if(estoqueAtual < quantidade) {
            System.out.println("Estoque insuficiente.");
            conn.rollback();
            conn.close();
            return;
        }

        String sqlPedido = "INSERT INTO pedido (status, id_cliente) VALUES ('FILA', ?)";

        PreparedStatement stmtPedido = conn.prepareStatement(
                sqlPedido,
                Statement.RETURN_GENERATED_KEYS
        );

        stmtPedido.setInt(1, idCliente);
        stmtPedido.executeUpdate();

        ResultSet rsPedido = stmtPedido.getGeneratedKeys();
        rsPedido.next();

        int idPedido = rsPedido.getInt(1);

        String sqlItem = "INSERT INTO item_pedido (id_pedido, id_livro, quantidade, valor_unitario) VALUES (?, ?, ?, ?)";

        PreparedStatement stmtItem = conn.prepareStatement(sqlItem);
        stmtItem.setInt(1, idPedido);
        stmtItem.setInt(2, idLivro);
        stmtItem.setInt(3, quantidade);
        stmtItem.setDouble(4, preco);
        stmtItem.executeUpdate();

        String sqlAtualizarEstoque = "UPDATE livro SET estoque = estoque - ? WHERE id_livro = ? AND estoque >= ?";

        PreparedStatement stmtAtualizar = conn.prepareStatement(sqlAtualizarEstoque);
        stmtAtualizar.setInt(1, quantidade);
        stmtAtualizar.setInt(2, idLivro);
        stmtAtualizar.setInt(3, quantidade);

        int linhasAtualizadas = stmtAtualizar.executeUpdate();

        if(linhasAtualizadas == 0) {
            System.out.println("Erro ao atualizar estoque.");
            conn.rollback();
            conn.close();
            return;
        }

        conn.commit();
        conn.close();

        System.out.println("Pedido criado com sucesso!");
        System.out.println("Status: FILA");

    } catch(Exception e) {

        System.out.println("Erro: " + e.getMessage());

    }
}
}