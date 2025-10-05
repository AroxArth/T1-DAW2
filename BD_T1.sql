-- CREATE DATABASE
DROP DATABASE IF EXISTS db_exament1_daw2;
CREATE DATABASE db_exament1_daw2;

-- USE DATABASE
USE db_exament1_daw2;

-- CREATE TABLE users
CREATE TABLE users (
	id INT auto_increment NOT NULL,
	dni VARCHAR(50) NULL,
	nombres VARCHAR(50) NULL,
    apellidos VARCHAR(50) NULL,
    nacimiento DATE NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);


-- INSERT 10 usuarios en la tabla users
INSERT INTO users (dni, nombres, apellidos, nacimiento)
VALUES
('12345678', 'Juan', 'Pérez', '1985-06-15'),
('23456789', 'Ana', 'Gómez', '1992-11-23'),
('34567890', 'Carlos', 'Rodríguez', '1980-03-07'),
('45678901', 'Lucía', 'Martínez', '2000-05-17'),
('56789012', 'Pedro', 'Sánchez', '1995-01-30'),
('67890123', 'María', 'López', '1990-09-12'),
('78901234', 'José', 'García', '1983-12-04'),
('89012345', 'Laura', 'Fernández', '1998-07-19'),
('90123456', 'David', 'Hernández', '1987-02-25'),
('01234567', 'Elena', 'Jiménez', '1993-08-10');
