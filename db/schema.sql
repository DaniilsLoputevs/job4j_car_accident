CREATE TABLE IF NOT EXISTS rules
(
    id   serial primary key,
    name varchar(300) unique
);

CREATE TABLE IF NOT EXISTS type
(
    id   serial primary key,
    name varchar(300)
);

CREATE TABLE IF NOT EXISTS accidents
(
    id      serial primary key,
    name    varchar(300),
    text    varchar(2000),
    address varchar(100),
    type_id integer references type (id)
);


CREATE TABLE IF NOT EXISTS accident_rule
(
    id          integer,
    accident_id integer references accidents (id),
    rule_id     integer references rules (id)
);


CREATE TABLE IF NOT EXISTS users
(
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  boolean default true,
    PRIMARY KEY (username)
);

CREATE TABLE IF NOT EXISTS authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users (username)
);