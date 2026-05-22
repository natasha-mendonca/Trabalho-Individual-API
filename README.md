# Trabalho-Individual-API
# Descrição:

API REST desenvolvida em Java com Spring Boot para gerenciamento de clientes e veículos de uma concessionária. O sistema permite o cadastro, consulta, atualização e remoção de registros, com tratamento de erros padronizado e validação de campos obrigatórios.

# Configuração
Crie um banco de dados PostgreSQL e configure o arquivo src/main/resources/application.properties:
propertiesspring.datasource.url=jdbc:postgresql://localhost:5432/concessionaria
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Execução
bash# Clonar o repositório
git clone https://github.com/seu-usuario/concessionaria-api.git

# Acessar o diretório
cd concessionaria-api

# Compilar e executar
mvn spring-boot:run
A aplicação será iniciada em: http://localhost:8080

# Recursos Disponíveis
Cliente
Base URL: /api/v1/cliente
MétodoEndpointDescriçãoGET/api/v1/clienteRetorna todos os clientes cadastradosGET/api/v1/cliente?nome={nome}Retorna cliente filtrado por nomeGET/api/v1/cliente?cpf={cpf}Retorna cliente filtrado por CPFPOST/api/v1/clienteRealiza o cadastro de um novo clienteDELETE/api/v1/cliente/{id}Remove um cliente pelo identificador
Veículo
Base URL: /api/v1/veiculo
MétodoEndpointDescriçãoGET/api/v1/veiculoRetorna todos os veículos cadastradosGET/api/v1/veiculo?placa={placa}Retorna veículo filtrado por placaGET/api/v1/veiculo?marca={marca}Retorna veículos filtrados por marcaGET/api/v1/veiculo?modelo={modelo}Retorna veículos filtrados por modeloPOST/api/v1/veiculoRealiza o cadastro de um novo veículoPUT/api/v1/veiculo/{id}Atualiza os dados de um veículo existenteDELETE/api/v1/veiculo/{id}Remove um veículo pelo identificador

# Respostas HTTP
StatusDescrição200 OKRequisição realizada com sucesso201 CreatedRecurso criado com sucesso204 No ContentRecurso removido com sucesso400 Bad RequestDados inválidos ou campos obrigatórios ausentes404 Not FoundRecurso não encontrado409 ConflictCPF ou placa já cadastrados

# Documentação Interativa
Com a aplicação em execução, a documentação completa via Swagger está disponível em:
http://localhost:8080/swagger-ui.html

# Estrutura do Projeto
src/main/java/org/serratec/trabalhoIndividual/
├── controller/    # Camada de apresentação (endpoints REST)
├── service/       # Camada de negócio
├── repository/    # Camada de acesso a dados
├── entity/        # Entidades mapeadas pelo JPA
├── model/         # DTOs de entrada e saída
└── exception/     # Exceções customizadas e handler global
