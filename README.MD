# Api de Login com sistema de Produtos (Java 🚀 com Spring Boot 🍃, Spring Security 🛡️ + JWT 🔐 + Oauth2 🛡 e MySQL 🐬)

Este é um projeto Java Spring boot, que consiste em uma API para cadastro e login de usuários, que podem realizar pedidos de acordo com os produtos registrados no sistema, essa Api possui segurança via spring security, jwt e oauth2, cada role tem sua permissão, sendo elas os ADMIN e COMMON.

## Configuração

1. É necessário ter o Java 21 e o MySQL instalados no PC.

2. Clone o repositório para sua máquina local:

    ```bash
    git clone https://github.com/Thullyoo/user-microservice
    ```

3. Navegue até o diretório do projeto:

    ```bash
    cd user-microservice
    ```

4. Instale as dependências com o maven

5. Coloque suas variáveis necessárias no application.properties, as seguintes variáveis são necessárias:
    - spring.datasource.url
    - spring.datasource.username
    - spring.datasource.password

6. É necessário criar duas chaves, sendo a pública e a privada e armazenar elas em application.properties com o nome de app.key para a privada e app.pub para a pública.

6. Inicie a aplicação

A aplicação estará rodando em `http://localhost:8080`.

### Endpoints

- `POST /login`: Logar usuário.  (Não é necessário estar autenticado, pois geram o token para a autenticação)
- `POST /register`: Registrar usuário. (Não é necessário estar autenticado, pois geram o token para a autenticação)
- `POST /product/register`: Registrar produto. (É necessário estar autenticado via Bearer token como usuário com role ADMIN)
- `POST /order/create`: Criar pedido. (É necessário estar autenticado via Bearer token com role COMMON) 
- `GET /users/view`: Visualizar todos os usuários. (É necessário estar autenticado via Bearer token como usuário com role ADMIN)
- `GET /product/view`: Visualizar todos os produtos. (É necessário estar autenticado via Bearer token como usuário com role ADMIN ou COMMON)
- `GET /order/view/all`: Visualizar todos os pedidos. (É necessário estar autenticado via Bearer token como usuário com role ADMIN)
- `GET /order/view`: Visualiza todos os pedidos de um usuário. (É necessário estar autenticado via Bearer token com role COMMON)

### Formato dos dados

As requisições e respostas são no formato JSON. Exemplo de como se deve passar o JSON no POST:

POST /register:

```json
{
    "name": "name",
    "password": "password",
    "email": "email"   
}
```

POST /login:

```json
{
  "email": "email",
  "password": "password"
}
```

POST /product/register

```json
{
  "name": "name",
  "price": 0.0,
  "quantity": 1
}
```

POST /order/create

```json
{
  "productsId": [
    1,
    2
  ],
  "emailUser": "email@email.com"
}
```

GET /order/view

```json
{
  "email": "email@email.com"
}
```


