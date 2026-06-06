# Sistema de Gestão de Pedidos - Livraria

## Descrição

Sistema desenvolvido em Java para gerenciamento de clientes, livros e pedidos utilizando banco de dados MySQL e JDBC.

O sistema permite cadastrar clientes e livros, criar pedidos, controlar estoque, processar pedidos em segundo plano através de uma thread e gerar consultas gerenciais.

---

## Tecnologias Utilizadas

* Java
* JDBC
* MySQL
* Git e GitHub
* Programação Orientada a Objetos

---

## Funcionalidades

### Clientes

* Cadastro de clientes
* Listagem de clientes
* Validação de e-mail

### Livros

* Cadastro de livros
* Listagem de livros
* Controle de estoque
* Categorias utilizando ENUM

### Pedidos

* Criação de pedidos
* Associação entre cliente e livro
* Controle de estoque durante a venda
* Status utilizando ENUM

Status disponíveis:

* ABERTO
* FILA
* PROCESSANDO
* FINALIZADO

### Processamento Assíncrono

Uma thread independente monitora pedidos com status FILA.

Fluxo de processamento:

FILA → PROCESSANDO → FINALIZADO

O processamento ocorre em segundo plano sem bloquear o menu principal.

---

## Banco de Dados

Banco utilizado:

```sql
CREATE DATABASE livraria;
```

As principais tabelas são:

* cliente
* livro
* pedido
* item_pedido

---

## Configuração

### 1. Criar o banco de dados

Executar o script SQL disponibilizado no projeto.

### 2. Configurar conexão

Na classe Conexao.java ajustar:

```java
private static final String URL = "jdbc:mysql://localhost:3306/livraria";
private static final String USER = "root";
private static final String PASSWORD = "sua_senha";
```

### 3. Executar o projeto

Executar a classe:

```java
Main.java
```

---

## Estrutura do Projeto

* model

  * Cliente
  * Livro
  * Pedido
  * ItemPedido
  * CategoriaLivro
  * StatusPedido

* dao

  * ClienteDAO
  * LivroDAO
  * PedidoDAO

* connection

  * Conexao

* service

  * ProcessadorPedidos

* menu

  * MenuLivraria

---

## Decisões Arquiteturais

O acesso ao banco de dados foi isolado nas classes DAO para evitar comandos SQL na camada de interface.

A classe MenuLivraria é responsável apenas pela interação com o usuário.

O processamento de pedidos ocorre através da classe ProcessadorPedidos, executada em uma thread separada que gerencia os status dos pedidos diretamente no banco de dados.

---

## Integrantes

* Yasminn da Silva Carvalho
* Gabryele Camargo Oliveira