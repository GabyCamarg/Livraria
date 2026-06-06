CREATE TABLE item_pedido (
    id_item INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_livro INT NOT NULL,
    quantidade INT NOT NULL,
    valor_unitario DECIMAL(10,2) NOT NULL,

    FOREIGN KEY (id_pedido)
    REFERENCES pedido(id_pedido),

    FOREIGN KEY (id_livro)
    REFERENCES livro(id_livro)
);