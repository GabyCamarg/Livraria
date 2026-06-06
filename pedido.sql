CREATE TABLE pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    data_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    status ENUM('ABERTO','FILA','PROCESSANDO','FINALIZADO') NOT NULL,
    id_cliente INT NOT NULL,
    
    FOREIGN KEY (id_cliente)
    REFERENCES cliente(id_cliente)
);