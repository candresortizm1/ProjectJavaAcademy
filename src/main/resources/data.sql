INSERT IGNORE INTO user (id, document,name, last_name, nickname, address, zip_code, country, state) VALUES
            (1, '1013616596', 'Andres', 'Ortiz', 'candresortizm', 'Calle 27 sur # 22 A - 05', 111811, 'Colombia', 'Bogotá'),
            (2, '1013616597', 'Luis', 'Ortiz', 'luisortizm', 'Calle 27 sur # 22 A - 05', 111811, 'Colombia', 'Bogotá'),
            (3, '1013616598', 'Luz Angela', 'Ortiz', 'luzortizm', 'Calle 27 sur # 22 A - 05', 111811, 'Colombia', 'Bogotá');
INSERT IGNORE INTO receiver_type (id, receiver_type) VALUES
            (1,"Primary Receptor"),
            (2,"CC"),
            (3,"BCC");