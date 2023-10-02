INSERT INTO tb_user (name, email, password) VALUES ('Jon Snow', 'jonsnow@email.com', '$2a$12$5WriKe32Ben26zZADrFp8.t7lXfI5Qgh13yYtaDHODWA.Lfl/fU5S');
INSERT INTO tb_user (name, email, password) VALUES ('Luffy', 'pirateking@email.com', '$2a$12$wixBYwic3YTQE7I9kY6dJOxeQkJNQ7C9CiwZSIqSdjK7AIITQwAlm');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
