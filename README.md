# 🎮 Lista de Jogos com Gêneros - Spring Boot API

Este projeto é uma API RESTful desenvolvida com **Spring Boot** para gerenciar uma lista de jogos, com seus respectivos gêneros. A aplicação permite o cadastro, listagem e associação de jogos a seus gêneros, garantindo que os gêneros sejam tratados de forma padronizada (nome normalizado em minúsculo).


---

## 📋 Funcionalidades

- ✅ Cadastro de jogos (`POST /jogos`)
- ✅ Listagem de jogos (`GET /jogos`)
- ✅ Cadastro de gêneros (`POST /generos`)
- ✅ Listagem de gêneros (`GET /generos`)
- ✅ Relacionamento entre Jogo e Gênero (ManyToOne)
- ✅ Gêneros com nome original e nome normalizado (evita duplicatas como "Ação" e "ação")

---

## 🧠 Lógica de Gênero

- Ao criar um jogo com um gênero informado, o sistema:
  - Normaliza o nome (converte para minúsculas, remove acentos).
  - Verifica se o gênero já existe.
  - Se existir, associa ao jogo.
  - Se não existir, cria e associa.

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Swagger UI
- H2 Database (banco de dados em memória)
- Hibernate
- Postman (para testes de API)
- Maven