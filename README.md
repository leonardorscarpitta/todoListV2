# API - Todo V2
Desenvolvi essa aplicação para me aprofundar nos conceitos de CRUD, validação de dados, injeção de dependencias, testes unitários e respostas de requisições.

## Estrutura
A estrutura segue uma arquitetura tradicional de um projeto Spring Boot, separando responsabilidades por pacotes: configuração, controle, DTOs, modelo de dados, repositórios e serviços.
___
`config` - Configuração do SwaggerAPI para auto Documentação.<br>
`controller` - Realização de requisições através dos verbos HTTP, está diretamente ligada à service.<br>
`dto` - Camada que adiciona uma segurança a mais ao evitar que a classe envie dados diretos ao cliente.<br>
`model` - Responsabilidade de abstração dos atributos e métodos.<br>
`repository` - Comunicação direta com o banco de dados.<br>
`service` - Métodos para comunicação com o banco de dados, está diretamente ligada ao repository.<br>

## Informações da aplicação
- Versão JDK 17;
- Banco de dados PostgreSQL;

### Endpoints
`GET: /todo`  - Lista todas as tarefas; <br>
`GET: todo/id` - Lista a tarefa com o ID informado; <br>
`PUT: /todo/id` - Atualiza alguma informação da tarefa; <br>
`POST: /todo`  - Cria uma tarefa nova; <br>
`PATCH: /todo` - Alterna entre os status da tarefa (concluída/pendente); <br>
`DELETE: /todo/id` - Deleta a tarefa; <br>

> [!NOTE]
> A API está documentada no Swagger, ao rodar a aplicação, ela pode ser acessada via `http://<ip>:<porta>/swagger-ui/index.html` - lá você pode acessar mais informações como o corpo da requisição!