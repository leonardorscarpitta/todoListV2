# 📝 API - Todo V2

Este projeto foi desenvolvido com o objetivo de consolidar conhecimentos em **CRUD**, **validação de dados**, **injeção de dependências**, **testes unitários** e **tratamento de respostas HTTP**, utilizando o **Spring Boot** como framework principal.

---

## 📁 Estrutura do Projeto

A arquitetura da aplicação segue os padrões convencionais do Spring Boot, com separação de responsabilidades por pacotes:

- `config`: configurações globais da aplicação, incluindo o Swagger para documentação automática da API.
- `controller`: camada responsável por expor os endpoints e controlar as requisições HTTP.
- `dto`: camada intermediária para transferência de dados entre cliente e servidor, garantindo segurança e desacoplamento entre as camadas.
- `model`: representação das entidades do sistema.
- `repository`: interfaces responsáveis pela comunicação com o banco de dados.
- `service`: camada de regras de negócio, interligando os controllers aos repositórios.

---

## ⚙️ Tecnologias Utilizadas

- **Java JDK**: 17
- **Framework**: Spring Boot
- **Banco de Dados**: PostgreSQL
- **Documentação**: Swagger UI

---

## 🚀 Endpoints Disponíveis

| Método | Endpoint        | Descrição                                 |
|--------|------------------|---------------------------------------------|
| GET    | `/todo`          | Lista todas as tarefas                     |
| GET    | `/todo/{id}`     | Retorna a tarefa com o ID informado        |
| POST   | `/todo`          | Cria uma nova tarefa                       |
| PUT    | `/todo/{id}`     | Atualiza as informações de uma tarefa      |
| PATCH  | `/todo`          | Alterna o status da tarefa (concluída/pendente) |
| DELETE | `/todo/{id}`     | Deleta uma tarefa                          |

---

## 📚 Documentação da API

A documentação interativa da API pode ser acessada via Swagger, disponível após iniciar a aplicação:

```
http://localhost:8080/swagger-ui/index.html
```

> ⚠️ Certifique-se de substituir o `localhost:8080` pelo IP e porta corretos, se estiver rodando em outro ambiente.