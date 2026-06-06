package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

}