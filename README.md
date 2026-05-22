# Concessionária API

API REST para gerenciamento de clientes e veículos de uma concessionária.

## Tecnologias

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

## Como Executar

Configure o banco no `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/concessionaria
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

Rode o projeto:

```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`

## Endpoints

### Cliente `/api/v1/cliente`
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/api/v1/cliente` | Lista todos os clientes |
| GET | `/api/v1/cliente?nome=` | Busca por nome |
| GET | `/api/v1/cliente?cpf=` | Busca por CPF |
| POST | `/api/v1/cliente` | Cadastra cliente |
| DELETE | `/api/v1/cliente/{id}` | Remove cliente |

### Veículo `/api/v1/veiculo`
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | `/api/v1/veiculo` | Lista todos os veículos |
| GET | `/api/v1/veiculo?placa=` | Busca por placa |
| GET | `/api/v1/veiculo?marca=` | Busca por marca |
| GET | `/api/v1/veiculo?modelo=` | Busca por modelo |
| POST | `/api/v1/veiculo` | Cadastra veículo |
| PUT | `/api/v1/veiculo/{id}` | Atualiza veículo |
| DELETE | `/api/v1/veiculo/{id}` | Remove veículo |

## Documentação

Com a aplicação rodando, acesse o Swagger em:
`http://localhost:8080/swagger-ui.html`

