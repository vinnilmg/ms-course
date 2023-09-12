INSERT INTO tb_user (name, email, password) VALUES ('Jon Snow', 'jonsnow@email.com', '$2a$12$zvJkC8wtiqScrx0R.AUfcODT3SK10NVu6ZQk2vZNF8IJMvMnDW6Zq');
INSERT INTO tb_user (name, email, password) VALUES ('Luffy', 'pirateking@email.com', '$2a$12$Kfv9kUGh7a3hwymoLc3FxezVdGxjGy4JdGPURAmU/ZpblG5t0/nn6');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
