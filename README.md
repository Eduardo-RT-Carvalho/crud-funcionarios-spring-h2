# Funcionários CRUD com Spring Boot e H2 Database

Este é um projeto simples de CRUD (Create, Read, Update, Delete) em Java usando o framework Spring Boot e o banco de dados H2. O projeto implementa operações básicas para gerenciar informações sobre funcionários.

## Configuração do Projeto

Certifique-se de ter o Java e o Maven instalados em sua máquina.

## Configuração do Banco de Dados H2

O banco de dados utilizado é o H2, um banco de dados em memória. A configuração de login para o H2 pode ser encontrada no arquivo application.yml:

yaml:


    spring:

      datasource:
  
      url: jdbc:h2:mem:testdb
    
      username: login
    
      password:
    
      driverClassName: org.h2.Driver
    

    jpa:
  
      database-platform: org.hibernate.dialect.H2Dialect
    

    h2:
  
      console:
        enabled: true
        path: /h2
      

## Para acessar o console do H2, siga estas etapas:
    
- Execute a aplicação Spring Boot.
- Abra seu navegador e vá para http://localhost:8080/h2.
- No campo "JDBC URL", insira jdbc:h2:mem:testdb.
- Deixe os campos "User Name" e "Password" em branco.
- Clique no botão "Connect".

Isso permitirá que você acesse o console do H2 e visualize o estado atual do banco de dados, além de executar consultas SQL interativamente.
Endpoints
1. Salvar Funcionário

    Endpoint: POST /funcionario
    Descrição: Salva um novo funcionário.
    Request Body:

    json

        {
            "nome": "Nome do Funcionário",
            "cargo": "Cargo do Funcionário",
            "salario": 5000.00
        }

2. Listar Funcionários

    Endpoint: GET /funcionario
    Descrição: Retorna a lista de todos os funcionários.

3. Buscar Funcionário por ID

    Endpoint: GET /funcionario/{id}
    Descrição: Retorna um funcionário específico com base no ID fornecido.

4. Remover Funcionário

    Endpoint: DELETE /funcionario/{id}
    Descrição: Remove um funcionário com base no ID fornecido.


5. Atualizar Funcionário

    Endpoint: PUT /funcionario/{id}
    Descrição: Atualiza as informações de um funcionário com base no ID fornecido.
    Request Body:
   
   json

        {
            "nome": "Novo Nome",
            "cargo": "Novo Cargo",
            "salario": 6000.00
        }


Executando o Projeto

    Clone este repositório.
    Navegue até o diretório do projeto no terminal.
    Execute o comando mvn spring-boot:run.

O aplicativo estará disponível em http://localhost:8080.
