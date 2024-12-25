CREATE TABLE shops (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    owner VARCHAR(255) NOT NULL,
    tax_id VARCHAR(255) NOT NULL
);

CREATE TABLE computers (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    memory INT NOT NULL,
    processor_features VARCHAR(255) NOT NULL,
    operating_system VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    shop_id INT,
    FOREIGN KEY (shop_id) REFERENCES shops(id)
);