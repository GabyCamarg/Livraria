package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class LivroDAO {

    public void listarLivros() {

        try {

            Connection conn = Conexao.conectar();

            String sql = "SELECT * FROM livro";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {

                System.out.println("--------------------");
                System.out.println("ID: " + rs.getInt("id_livro"));
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("Autor: " + rs.getString("autor"));
                System.out.println("Preço: " + rs.getDouble("preco"));
                System.out.println("Estoque: " + rs.getInt("estoque"));
                System.out.println("Categoria: " + rs.getString("categoria"));

            }

            conn.close();

        } catch(Exception e) {

            System.out.println("Erro: " + e.getMessage());

        }

    }

    public void cadastrarLivro(
            String titulo,
            String autor,
            double preco,
            int estoque,
            String categoria) {

        String sql = "INSERT INTO livro (titulo, autor, preco, estoque, categoria) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, titulo);
            stmt.setString(2, autor);
            stmt.setDouble(3, preco);
            stmt.setInt(4, estoque);
            stmt.setString(5, categoria);

            stmt.executeUpdate();

            conn.close();

            System.out.println("Livro cadastrado no banco com sucesso!");

        } catch(Exception e) {

            System.out.println("Erro: " + e.getMessage());

        }

    }

}