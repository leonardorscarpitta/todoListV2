# API - Todo V2
Desenvolvi essa aplicação para me aprofundar nos conceitos de CRUD, validação de dados, injeção de dependencias, testes unitários e respostas de requisições.

## 1. Rodando a aplicação
___
### 1.1 Requisitos

### 1.2 Endpoints
`GET` `/todo`  - Lista todas as tarefas; <br>
`POST` `/todo`  - Cria uma tarefa nova; <br>
`PUT` `/todo/id` - Atualiza alguma informação da tarefa; <br>
`PATCH` `/todo` - Alterna entre os status da tarefa (concluída/pendente); <br>
`DELETE` `/todo/id` - Deleta a tarefa; <br>
### 1.3 Corpo de requisição
```json
{
    "name": "Nome da tarefa",
    "description": "Descrição da tarefa",
    "status": false,
    "priority": 2 
}
```