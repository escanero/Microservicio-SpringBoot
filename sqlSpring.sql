
create database apiProducto;
use apiProducto;

select * from productos;

create database usuarioStock;



use usuarioStock;
select * from usuario;

INSERT INTO rol (id, nombre) VALUES (1, 'ROLE_USER');
INSERT INTO rol (id, nombre) VALUES (2, 'ROLE_ADMIN');

INSERT INTO usuario (id, username, password) VALUES (1, 'admin', '$2a$10$4Dmb1b2zuE9vhQA5k2U6WOYQedis7Z/lmSn8ggrZ6vo4KhscKkK5i');
INSERT INTO usuario (id, username, password) VALUES (2, 'user', '$2a$10$4Dmb1b2zuE9vhQA5k2U6WOYQedis7Z/lmSn8ggrZ6vo4KhscKkK5i');

INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1, 2);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (2, 1);



