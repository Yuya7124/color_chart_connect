--CREATE TABLE IF NOT EXISTS user {
--    nickname VARCHAR(256) NOT NULL PRIMARY KEY,
--    email VARCHAR(256) NOT NULL,
--    password VARCHAR(100) NOT NULL
--}

--CREATE TABLE IF NOT EXISTS product (
--    user_id VARCHAR(256) NOT NULL,
--    color_chart
--);
--
CREATE TABLE IF NOT EXISTS color_chart (
    product_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    part VARCHAR(256) NOT NULL,
    maker VARCHAR(256) NOT NULL,
    red INT NOT NULL,
    green INT NOT NULL,
    blue INT NOT NULL,
    coat INT NOT NULL,
    ratio INT NOT NULL
);



