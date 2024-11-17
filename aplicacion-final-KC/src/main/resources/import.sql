INSERT INTO CLIENTE (nombre, apellido, empresa, puesto, direccion, codigo_postal, provincia, telefono, fecha_nac) VALUES ("Rodrigo", "Perez", "Leroy Merlin", "Contabilidad", "Calle de la Sonrisa, 12", "28330", "Madrid", "63423441", "1985-05-15")
INSERT INTO CLIENTE (nombre, apellido, empresa, puesto, direccion, codigo_postal, provincia, telefono, fecha_nac) VALUES ("Antonio", "Gonzalez", "Bauhaus", "Ventas", "Calle Pez, 05", "28340", "Madrid", "63421233", "1995-10-22")
INSERT INTO CLIENTE (nombre, apellido, empresa, puesto, direccion, codigo_postal, provincia, telefono, fecha_nac) VALUES ("Matilde", "Asensio", "Bauhaus", "RRHH", "Calle de la Agricultura, 01", "28456", "Madrid", "68434521", "2001-06-03")
INSERT INTO CLIENTE (nombre, apellido, empresa, puesto, direccion, codigo_postal, provincia, telefono, fecha_nac) VALUES ("Mario", "Gomez", "Corte Ingles", "Administracion", "Avenida de Andalucia, 03", "28552", "Madrid", "63128943", "1988-09-25")
INSERT INTO CLIENTE (nombre, apellido, empresa, puesto, direccion, codigo_postal, provincia, telefono, fecha_nac) VALUES ("Pablo", "Martinez", "MediaMarkt", "Direccion", "Paseo de Acacias, 33", "28540", "Madrid", "63839050", "1992-04-11")

INSERT INTO ARTICULO (nombre, descripcion, unidad_precio, unidad_stock, tipo, proveedor, fecha) VALUES ('Laptop', 'Laptop de alta gama', 1200.00, 10, 'Electrónica', 'Proveedor SA', '2024-01-01')
INSERT INTO ARTICULO (nombre, descripcion, unidad_precio, unidad_stock, tipo, proveedor, fecha) VALUES ('Monitor', 'Monitor Full HD', 200.00, 25, 'Electrónica', 'Distribuidor SL', '2024-02-01')
INSERT INTO ARTICULO (nombre, descripcion, unidad_precio, unidad_stock, tipo, proveedor, fecha) VALUES ('Teclado', 'Teclado mecánico', 50.00, 50, 'Accesorios', 'Proveedora Corp', '2024-03-01')
INSERT INTO ARTICULO (nombre, descripcion, unidad_precio, unidad_stock, tipo, proveedor, fecha) VALUES ('Ratón', 'Ratón inalámbrico', 30.00, 40, 'Accesorios', 'Proveedor SA', '2024-04-01')
INSERT INTO ARTICULO (nombre, descripcion, unidad_precio, unidad_stock, tipo, proveedor, fecha) VALUES ('Auriculares', 'Auriculares con cancelación de ruido', 100.00, 20, 'Accesorios', 'Distribuidor SL', '2024-06-01')

INSERT INTO COMPRA (cliente_id, articulo_id, fecha, cantidad, total, iva, total_iva) VALUES (1, 1, "2024-01-15", 1, 1200.00, 252.00, 1452.00)
INSERT INTO COMPRA (cliente_id, articulo_id, fecha, cantidad, total, iva, total_iva) VALUES (2, 3, '2024-03-20', 5, 250.00, 52.50, 302.50)


INSERT INTO USUARIOS (username, password, role) VALUES ('admin', '$2a$10$MRPb0.hQNL6g7mJdKmW0aOhgq4dMJjF1Ps2EQzO4.5pprAywcxz/6','ADMIN');