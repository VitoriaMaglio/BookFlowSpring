📚 **BookFlow API**

API REST desenvolvida em Java com Spring Boot para gestão de uma livraria, permitindo o cadastro e consulta de livros, autores, clientes e pedidos.

🚀 Tecnologias utilizadas
Java 17
Spring Boot
Spring Data JPA
PostgreSQL
Flyway (migrations)
Lombok


📦 Funcionalidades
CRUD de Livros
CRUD de Autores
CRUD de Clientes
Criação e consulta de Pedidos
Relacionamentos entre entidades
Filtros de busca avançados
Paginação e ordenação
Projections para otimização de dados


🔗 Relacionamentos
📚 Livro ↔ Autor: N
🛒 Pedido → Cliente: N:1
📦 Pedido → Itens: 1
📖 Item → Livro: N:1
🔍 Filtros de busca

A API possui diversos filtros, como:

- Buscar livros por título
- Buscar livros por avaliação mínima
- Buscar livros por autor
- Buscar livros por média de preço de venda
- Buscar pedidos por livro

📄 Paginação

Exemplo:

GET /books?page=0&size=5&sort=title
📊 Projection

Exemplo de retorno simplificado de livros:

GET /books/simple

Retorna apenas:

{
  "id": 1,
  "title": "Clean Code"
}

🛠️ Configuração do banco

Configure o application.yml:

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/bookflowdb
    username: user_book
    password: 12345

  jpa:
    hibernate:
      ddl-auto: none

  flyway:
    enabled: true
    
▶️ Como executar
Clonar o repositório
Configurar o PostgreSQL
Rodar a aplicação
Testar endpoints via Postman ou Insomnia
📌 Exemplo de requisição
Criar livro
POST /books
{
  "title": "Clean Code",
  "rating": 4.8,
  "price": 120.0,
  "authorIds": [1]
}


📁 Estrutura do projeto
com.api.livraria
├── controller
├── service
├── repository
├── entity
├── dto
├── projection
└── validation

Jsons para testes
POST - Criar livro
{
  "method": "POST",
  "url": "http://localhost:8080/books",
  "body": {
    "title": "Clean Code",
    "rating": 4.8,
    "price": 120.0,
    "authorIds": [1]
  }
}
GET - Listar livros
{
  "method": "GET",
  "url": "http://localhost:8080/books?page=0&size=5"
}
GET - Buscar por título
{
  "method": "GET",
  "url": "http://localhost:8080/books/search/title?title=clean"
}
GET - Buscar por avaliação
{
  "method": "GET",
  "url": "http://localhost:8080/books/search/rating?rating=4.1"
}
GET - Buscar por autor
{
  "method": "GET",
  "url": "http://localhost:8080/books/search/author?name=martin"
}
GET - Buscar por média de preço
{
  "method": "GET",
  "url": "http://localhost:8080/books/search/avg-price?avgPrice=50"
}
GET - Projection (BookSimpleProjection)
{
  "method": "GET",
  "url": "http://localhost:8080/books/simple?page=0&size=5"
}
AUTHORS
POST - Criar autor
{
  "method": "POST",
  "url": "http://localhost:8080/authors",
  "body": {
    "name": "Robert Martin"
  }
}
GET - Listar autores
{
  "method": "GET",
  "url": "http://localhost:8080/authors?page=0&size=5"
}
GET - Buscar autor
{
  "method": "GET",
  "url": "http://localhost:8080/authors/search?name=martin"
}
CUSTOMERS
POST - Criar cliente
{
  "method": "POST",
  "url": "http://localhost:8080/customers",
  "body": {
    "name": "Maria Silva",
    "email": "maria@email.com"
  }
}
GET - Listar clientes
{
  "method": "GET",
  "url": "http://localhost:8080/customers?page=0&size=5"
}
GET - Buscar cliente
{
  "method": "GET",
  "url": "http://localhost:8080/customers/search?name=maria"
}
ORDERS
GET - Listar pedidos
{
  "method": "GET",
  "url": "http://localhost:8080/orders?page=0&size=5"
}
GET - Buscar pedidos por cliente
{
  "method": "GET",
  "url": "http://localhost:8080/orders/customer?customerId=1"
}
GET - Projection (OrderSummaryProjection)
{
  "method": "GET",
  "url": "http://localhost:8080/orders/summary?page=0&size=5"
}
GET - Buscar pedidos por livro
{
  "method": "GET",
  "url": "http://localhost:8080/orders/search/book?bookId=1"
}

Integrantes:
Vitória Valentina Maglio
Marina 
João Pedro Bitencourt
