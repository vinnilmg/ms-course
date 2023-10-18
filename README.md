# MS-COURSE

### Curso
https://www.udemy.com/share/103FNT3@-30JpKbA1NX-PT3aw6c82DDMSEztllLcUilEWFLgCQ8Re1OUA5zt-56brk6xVgPz/

### Descrição dos microsserviços
<h4>hr-api-gateway-zuul</h4>
<p>Centraliza as chamadas aos serviços hr-user, hr-payroll, hr-worker e hr-oauth.</p>

<h4>hr-config-server</h4>
<p>Busca as propriedades de configuração dos projetos, todas estão armazenadas no github.</p>

<h4>hr-eureka-server</h4>
<p>Gerencia o status, localização e balanceamento de carga dos serviços clientes.</p>

<h4>hr-oauth</h4>
<p>Microsserviço responsável pela autenticação do usuário e gerar o JWT.</p>

<h4>hr-payroll</h4>
<p>Microsserviço responsável por gerenciar a folha de pagamento.</p>

<h4>hr-user</h4>
<p>Microsserviço responsável por gerenciar os usuários.</p>

<h4>hr-worker</h4>
<p>Microsserviço responsável por gerenciar os trabalhadores.</p>

### Versões utilizadas
- Java 11
- Spring Boot 2.3.4.RELEASE

### SQL
<h4>Insert de trabalhadores:</h4>

```sql
INSERT INTO tb_worker(name, daily_income) VALUES('Maria', 4500.0);
INSERT INTO tb_worker(name, daily_income) VALUES('Marcio', 15000.0);
INSERT INTO tb_worker(name, daily_income) VALUES('Vini', 10000.0);
```

<h4>Insert de usuários, funcões e many to many:</h4>

```sql
INSERT INTO tb_user (name, email, password) VALUES ('Jon Snow', 'jonsnow@email.com', '$2a$12$5WriKe32Ben26zZADrFp8.t7lXfI5Qgh13yYtaDHODWA.Lfl/fU5S');
INSERT INTO tb_user (name, email, password) VALUES ('Luffy', 'pirateking@email.com', '$2a$12$wixBYwic3YTQE7I9kY6dJOxeQkJNQ7C9CiwZSIqSdjK7AIITQwAlm');

INSERT INTO tb_role (role_name) VALUES ('OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
```

### Eureka Server
Dashboard: http://localhost:8761/

### Rota de autenticação
Endpoint: /hr-oauth/oauth/token

### Variáveis de ambiente
Criar:
```
setx {VARIAVEL} {VALOR}
``` 

Exibir:
```
echo %{VARIAVEL}%
```

### Testando o CORS
```
fetch("http://localhost:8765/hr-worker/workers", {
  "headers": {
    "accept": "*/*",
    "accept-language": "en-US,en;q=0.9,pt-BR;q=0.8,pt;q=0.7",
    "sec-fetch-dest": "empty",
    "sec-fetch-mode": "cors",
    "sec-fetch-site": "cross-site"
  },
  "referrer": "http://localhost:3000",
  "referrerPolicy": "no-referrer-when-downgrade",
  "body": null,
  "method": "GET",
  "mode": "cors",
  "credentials": "omit"
});
```

### Docker
Buildar o projeto:
```
mvnw clean package
```