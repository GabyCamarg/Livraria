import dao.LivroDAO;

public class TesteLivroDAO {

    public static void main(String[] args) {

        LivroDAO livroDAO = new LivroDAO();

        livroDAO.cadastrarLivro(
                "Java Completo",
                "Nelio Alves",
                89.90,
                20,
                "Programacao"
        );

        livroDAO.listarLivros();

    }

}