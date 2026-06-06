package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

}