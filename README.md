# API - Todo V2
Desenvolvi essa aplicação para me aprofundar nos conceitos de CRUD, validação de dados, injeção de dependencias, testes unitários e respostas de requisições.

## Camadas da aplicação

## Utilizando a aplicação

> [!NOTE]
> Para rodar a aplicação, você deve ter o JDK 17 instalado na máquina!

### Endpoints
`GET: /todo`  - Lista todas as tarefas; <br>
`GET: todo/id` - Lista a tarefa com o ID informado; <br>
`PUT: /todo/id` - Atualiza alguma informação da tarefa; <br>
`POST: /todo`  - Cria uma tarefa nova; <br>
`PATCH: /todo` - Alterna entre os status da tarefa (concluída/pendente); <br>
`DELETE: /todo/id` - Deleta a tarefa; <br>
#### Corpo da requisição
```json
{
    "name": "Nome da tarefa",
    "description": "Descrição da tarefa",
    "status": false,
    "priority": 2 
}
```

## Estrutura do projeto
```
📦 src
 ┗ 📂 main
     ┗ 📂 java
         ┗ 📂 io.github.leonardorscarpitta.simplify
             ┣ 📂 controllers
             ┃ ┣ 📄 ManageHttpStatus.java
             ┃ ┗ 📄 ToDoController.java
             ┣ 📂 models
             ┃ ┗ 📄 ToDoItem.java
             ┣ 📂 repositories
             ┃ ┗ 📄 ToDoItemRepository.java
             ┣ 📂 services
             ┃ ┣ 📂 impl
             ┃ ┗ 📂 interfaces
             ┣ 📂 utils
             ┃ ┗ 📂 domain
             ┃     ┗ 📄 ExceptionHandling.java
             ┣ ┗📂 exceptions
             ┃     ┗ 📄 InvalidValue.java 
             ┗ 📄 SimplifyApplication.java

```