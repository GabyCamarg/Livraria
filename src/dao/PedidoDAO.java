package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}