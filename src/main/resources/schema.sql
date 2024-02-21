CREATE TABLE IF NOT EXISTS user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(256),
    email VARCHAR(256),
    password VARCHAR(100),
    role VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS product (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    nickname VARCHAR(256),
    product_name VARCHAR(256),
    color_chart VARCHAR(1000),
    image_data LONGBLOB,
    image_filename VARCHAR(256),
    comment VARCHAR(1000),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

--CREATE TABLE IF NOT EXISTS color_chart (
--    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
--    part VARCHAR(256),
--    maker VARCHAR(256),
--    red INT,
--    green INT,
--    blue INT,
--    coat INT,
--    ratio INT
--);