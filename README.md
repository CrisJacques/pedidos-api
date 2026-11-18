# Produtos API

![Status](https://img.shields.io/badge/status-em%20construção-yellow)
![Java](https://img.shields.io/badge/Java-25-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.2-6DB33F?logo=springboot&logoColor=white)
![H2](https://img.shields.io/badge/Banco-H2-1A73E8)
![Maven](https://img.shields.io/badge/build-Maven-C71A36?logo=apachemaven&logoColor=white)

> **Projeto em construção:** esta API está em desenvolvimento ativo. Recursos, configurações e documentação podem mudar.

API REST para gerenciamento de produtos, desenvolvida com Java e Spring Boot.

## Funcionalidades

- [x] Cadastro de produtos
- [x] Consulta de todos os produtos
- [x] Consulta de produto por ID
- [x] Busca de produtos por nome
- [x] Atualização de produtos
- [x] Exclusão de produtos
- [ ] Validações completas dos dados de entrada
- [ ] Testes de integração e unitários
- [ ] Documentação interativa da API
- [ ] Persistência em banco de dados externo

## Tecnologias

- Java 25
- Spring Boot 4.1.2
- Spring Web MVC
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- Lombok

## Modelo de dados

| Campo | Tipo | Descrição |
|---|---|---|
| `id` | `String` (UUID) | Identificador único gerado automaticamente |
| `name` | `String` | Nome do produto |
| `description` | `String` | Descrição do produto |
| `price` | `Double` | Preço do produto |

## Pré-requisitos

- JDK 25
- Maven 3.9+ ou o Maven Wrapper incluído no projeto

## Como executar

Clone o repositório e acesse a pasta do projeto:

```bash
git clone https://github.com/CrisJacques/pedidos-api.git
cd pedidos-api
```

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

A aplicação ficará disponível em `http://localhost:8080`.

## Executando os testes

```bash
.\mvnw.cmd test
```

No Linux ou macOS:

```bash
./mvnw test
```

## Banco de dados H2

O projeto utiliza o banco H2 em memória. Os dados são armazenados apenas durante a execução da aplicação.

- Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:produtos`
- Usuário: `sa`
- Senha: vazia

## Endpoints

A base da API é `/products`.

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/products` | Cadastra um produto |
| `GET` | `/products` | Lista todos os produtos |
| `GET` | `/products/{id}` | Busca um produto por ID |
| `GET` | `/products?name={nome}` | Busca produtos por nome |
| `PATCH` | `/products/{id}` | Atualiza um produto |
| `DELETE` | `/products/{id}` | Remove um produto |

### Exemplos

Cadastrar um produto:

```bash
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Notebook","description":"Notebook para uso profissional","price":3500.00}'
```

Listar produtos:

```bash
curl http://localhost:8080/products
```

Buscar por ID:

```bash
curl http://localhost:8080/products/{id}
```

Buscar por nome:

```bash
curl "http://localhost:8080/products?name=Notebook"
```

Atualizar um produto:

```bash
curl -X PATCH http://localhost:8080/products/{id} \
  -H "Content-Type: application/json" \
  -d '{"name":"Notebook Pro","description":"Notebook atualizado","price":4200.00}'
```

Remover um produto:

```bash
curl -X DELETE http://localhost:8080/products/{id}
```

## Respostas de erro

Quando um produto não é encontrado, a API retorna `404 Not Found` com um corpo semelhante a:

```json
{
  "message": "Produto não encontrado",
  "timestamp": "2026-11-18T19:34:16Z",
  "status": 404,
  "path": "/products/{id}"
}
```

## Estrutura do projeto

```text
src
├── main
│   ├── java/com/example/produtosapi
│   │   ├── controller
│   │   ├── model
│   │   ├── repository
│   │   └── service
│   └── resources
└── test
    └── java/com/example/produtosapi
```

## Próximos passos

- Implementar validação com Bean Validation
- Expandir a cobertura de testes
- Adicionar respostas HTTP mais semânticas
- Criar documentação com OpenAPI/Swagger
- Configurar perfis e banco de dados para ambientes externos
- Preparar suporte a Docker
