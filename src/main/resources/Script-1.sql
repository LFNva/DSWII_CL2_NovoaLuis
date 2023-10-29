CREATE TABLE Producto (
	idproducto INT auto_increment NOT NULL,
	nomproducto varchar(100) NULL,
	descripcion varchar(200) NULL,
	cantidad int NULL,
	fechavencimiento date,
	CONSTRAINT product_pk PRIMARY KEY (idproducto)
);
INSERT INTO producto  (idproducto, nomproducto, descripcion, cantidad, fechavencimiento) 
VALUES (null, 'leche', 'lacteo', 25, '2022/10/12');
INSERT INTO producto  (idproducto, nomproducto, descripcion, cantidad, fechavencimiento) 
VALUES (null, 'carne', 'comida', 15, '2024/02/22');
INSERT INTO producto  (idproducto, nomproducto, descripcion, cantidad, fechavencimiento) 
VALUES (null, 'caramelo', 'dulce', 45, '2022/09/15');
INSERT INTO producto  (idproducto, nomproducto, descripcion, cantidad, fechavencimiento) 
VALUES (null, 'pimienta', 'condimento', 12, '2022/12/25');
