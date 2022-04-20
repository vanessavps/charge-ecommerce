#Create DB
CREATE DATABASE IF NOT EXISTS charge_db;
USE charge_db;

#Create tables
CREATE TABLE IF NOT EXISTS product
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(80) NOT NULL,
    price DECIMAL(10, 2) DEFAULT NULL
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS user
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(80) NOT NULL,
    email VARCHAR(255) DEFAULT NULL,
    phone VARCHAR(20)  DEFAULT NULL
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS cart_session
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    user_id     INT,
    total_price DECIMAL(10, 2) DEFAULT 0,
    created_at  DATETIME NOT NULL,
    UNIQUE KEY cart_index (id, user_id),
    CONSTRAINT fk_cart_session
        FOREIGN KEY (user_id)
            REFERENCES user (id)
            ON DELETE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS cart_item
(
    cart_id    INT            NOT NULL,
    product_id INT            NOT NULL,
    quantity   DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (cart_id, product_id),
    CONSTRAINT fk_cart_item
        FOREIGN KEY (cart_id)
            REFERENCES cart_session (id)
            ON DELETE CASCADE,
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        ON DELETE CASCADE
) ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS order_detail
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    user_id     INT,
    total_price DECIMAL(10, 2) DEFAULT NULL,
    created_at  DATETIME    NOT NULL,
    CONSTRAINT fk_order_detail
        FOREIGN KEY (user_id)
            REFERENCES user (id)
            ON DELETE SET NULL
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS order_item
(
    order_id   INT NOT NULL,
    product_id INT,
    paid_price DECIMAL(10, 2) DEFAULT NULL,
    quantity   INT,
    PRIMARY KEY (order_id, product_id),
    CONSTRAINT fk_order_item
        FOREIGN KEY (order_id)
            REFERENCES order_detail (id)
            ON DELETE CASCADE,
            FOREIGN KEY (product_id)
            REFERENCES product (id)
) ENGINE = InnoDB;




