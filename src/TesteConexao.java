import java.sql.Connection;

import connection.Conexao;

public class TesteConexao {

    public static void main(String[] args) {

        try {

            Connection conn = Conexao.conectar();

            System.out.println("Conectado com sucesso!");

            conn.close();

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());

        }

    }

}