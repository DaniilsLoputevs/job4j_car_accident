CREATE TABLE IF NOT EXISTS rule
(
    id   serial primary key,
    name varchar(300) unique
);

CREATE TABLE IF NOT EXISTS type
(
    id   serial primary key,
    name varchar(300)
);

CREATE TABLE IF NOT EXISTS accident
(
    id       serial primary key,
    name     varchar(300),
    text     varchar(2000),
    address  varchar(100),
    type_id  integer references type (id)
);


CREATE TABLE IF NOT EXISTS accident_rule
(
    id          integer,
    accident_id integer references accident (id),
    rule_id     integer references rule (id)
);