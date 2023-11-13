CREATE TABLE IF NOT EXISTS user (
    nickname VARCHAR(256) PRIMARY KEY,
    email VARCHAR(256),
    password VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS product (
    user_id VARCHAR(256) PRIMARY KEY,
    product_name VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS color_chart (
    product_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    part VARCHAR(256),
    maker VARCHAR(256),
    red INT,
    green INT,
    blue INT,
    coat INT,
    ratio INT
);