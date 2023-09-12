# MS-COURSE

### Curso
https://www.udemy.com/share/103FNT3@-30JpKbA1NX-PT3aw6c82DDMSEztllLcUilEWFLgCQ8Re1OUA5zt-56brk6xVgPz/

### Descrição

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
INSERT INTO tb_user (name, email, password) VALUES ('Jon Snow', 'jonsnow@email.com', 'g^yf7$fpdyj7+2H9');
INSERT INTO tb_user (name, email, password) VALUES ('Luffy', 'pirateking@email.com', 'n+mWeRrq9B2*f$M&');

INSERT INTO tb_role (role_name) VALUES ('OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
```

### Eureka Server
Dashboard: http://localhost:8761/

### Variáveis de ambiente
Criar:
```
setx {VARIAVEL} {VALOR}
``` 

Exibir:
```
echo %{VARIAVEL}%
``` 