INSERT INTO stores (id, name, owner, tax_id) VALUES
(1, 'Tech Hub', 'John Doe', '123456789');

INSERT INTO computers (brand, memory, processor_features, operating_system, price, quantity, store_id) VALUES
('Apple MacBook Pro', 16, 'M1 Pro', 'macOS', 1999.99, 5, 1),
('Apple MacBook Air', 8, 'M1', 'macOS', 999.99, 10, 1),
('Apple iMac', 16, 'M1', 'macOS', 1799.99, 3, 1),
('Apple Mac Mini', 8, 'M2', 'macOS', 1299.99, 7, 1),
('System76 Lemur Pro', 16, 'Intel i7', 'Linux', 1099.99, 2, 1),
('Dell XPS 13 Developer Edition', 16, 'Intel i7', 'Linux', 1399.99, 4, 1),
('Dell XPS 15', 16, 'Intel i7', 'Windows 11', 1499.99, 6, 1),
('HP Spectre x360', 16, 'Intel i5', 'Windows 11', 1299.99, 8, 1),
('Lenovo ThinkPad X1 Carbon', 8, 'Intel i5', 'Windows 10', 1299.99, 5, 1);
