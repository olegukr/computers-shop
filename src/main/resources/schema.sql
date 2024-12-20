CREATE TABLE stores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    owner VARCHAR(255),
    tax_id VARCHAR(50)
);

CREATE TABLE computers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    memory INT,
    processor_features VARCHAR(255),
    operating_system VARCHAR(255),
    price DECIMAL(10, 2),
    quantity INT,
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES stores(id)
);
