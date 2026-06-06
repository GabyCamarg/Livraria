SELECT 
	p.id_pedido, 
    c.nome AS cliente,
    p.status
FROM pedido p 
INNER JOIN cliente c
ON p.id_cliente = c.id_cliente;