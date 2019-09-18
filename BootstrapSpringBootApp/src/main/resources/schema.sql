CREATE TABLE users_roles
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES spring_users (user_id),
    FOREIGN KEY (role_id) REFERENCES roles (role_id)
);


CREATE TABLE roles
(
    role_id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    role    VARCHAR(20)
);

CREATE TABLE spring_users
(
    user_id  BIGINT PRIMARY KEY  NOT NULL AUTO_INCREMENT,
    login    VARCHAR(255) UNIQUE NOT NULL,
    email    VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
    active   boolean
);


INSERT INTO roles (role_id, role)
VALUES (1, 'ADMIN');

INSERT INTO roles (role_id, role)
VALUES (2, 'USER');
