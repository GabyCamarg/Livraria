SELECT
	categooria, 
    ROUND( AVG(preco), 2 AS preco_medio
    FROM livro
    GROUP BY categoria;