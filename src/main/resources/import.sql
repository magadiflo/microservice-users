INSERT INTO users(username, password, enabled, name, last_name, email) VALUES('magadiflo', '$2a$10$gVgmPrXYfivKf55bJULutOO.dT54Rju.wLbV72gHUgvXerZ6nP0BK', true, 'Martín', 'Díaz', 'magadiflo@magadiflo.com');
INSERT INTO users(username, password, enabled, name, last_name, email) VALUES('admin', '$2a$10$BlXyOfhh9ntQvjwgMu2BsO0qXHr.Avdvm/takg5qc4KAkIhqVY4CG', true, 'Admin', 'Admin', 'admin@magadiflo.com');

INSERT INTO roles(name) VALUES('ROLE_USER'); 
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO users_roles(user_id, role_id) VALUES(1,1);
INSERT INTO users_roles(user_id, role_id) VALUES(2,2);
INSERT INTO users_roles(user_id, role_id) VALUES(2,1);