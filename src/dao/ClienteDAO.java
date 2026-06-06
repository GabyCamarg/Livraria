package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class ClienteDAO {

    public void listarClientes() {

        try {

            Connection conn = Conexao.conectar();

            String sql = "SELECT * FROM cliente";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {

                System.out.println("--------------------");
                System.out.println("ID: " + rs.getInt("id_cliente"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Telefone: " + rs.getString("telefone"));

            }

            conn.close();

        } catch(Exception e) {

            System.out.println("Erro: " + e.getMessage());

        }

    }

    public void cadastrarCliente(String nome, String email, String telefone) {

    String sql = "INSERT INTO cliente (nome, email, telefone) VALUES (?, ?, ?)";

    try {

        Connection conn = Conexao.conectar();

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, nome);
        stmt.setString(2, email);
        stmt.setString(3, telefone);

        stmt.executeUpdate();

        conn.close();

        System.out.println("Cliente cadastrado no banco com sucesso!");

    } catch(Exception e) {

        System.out.println("Erro: " + e.getMessage());

    }

}

}