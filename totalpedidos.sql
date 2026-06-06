SELECT
	c.nome,
    COUNT(p.id_pedido) AS total_pedidos
FROM cliente c 
LEFT JOIN pedido p 
ON c.id_cliente = p.id_cliente
GROUP BY c.nome;