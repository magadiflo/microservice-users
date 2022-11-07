INSERT INTO users(username, password, enabled, name, last_name, email) VALUES('magadiflo', '12345', true, 'Martín', 'Díaz', 'magadiflo@magadiflo.com');
INSERT INTO users(username, password, enabled, name, last_name, email) VALUES('admin', '12345', true, 'Admin', 'Admin', 'admin@magadiflo.com');

INSERT INTO roles(name) VALUES('ROLE_USER'); 
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO users_roles(user_id, role_id) VALUES(1,1);
INSERT INTO users_roles(user_id, role_id) VALUES(2,2);
INSERT INTO users_roles(user_id, role_id) VALUES(2,1);