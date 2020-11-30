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


CREATE TABLE IF NOT EXISTS authorities
(
    id        serial primary key,
    authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE IF NOT EXISTS users
(
    id           serial primary key,
    username     VARCHAR(50)  NOT NULL unique,
    password     VARCHAR(100) NOT NULL,
    enabled      boolean default true,
    authority_id int          not null references authorities (id)
);

-- insert into authorities (authority)
-- values ('ROLE_USER');
-- insert into authorities (authority)
-- values ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id)
values ('root', true, '$2a$10$wY1twJhMQjGVxv4y5dBC5ucCBlzkzT4FIGa4FNB/pS9GaXC2wm9/W',
        (select id from authorities where authority = 'ROLE_ADMIN'));