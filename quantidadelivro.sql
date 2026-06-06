SELECT
	categoria,
    COUNT (*) AS quantidados_livros
FROM livro 
GROUP BY categoria;
