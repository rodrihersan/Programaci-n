-- ============================================
-- BASE DE DATOS: cine
-- ============================================

CREATE DATABASE IF NOT EXISTS cine;
USE cine;

-- ============================================
-- TABLAS
-- ============================================

CREATE TABLE peliculas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(150) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    duracion INT NOT NULL,
    anio INT NOT NULL
);

CREATE TABLE salas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero INT NOT NULL UNIQUE,
    aforo INT NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('Normal', 'VIP'))
);

CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(15) NOT NULL
);

CREATE TABLE sesiones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_pelicula INT NOT NULL,
    id_sala INT NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    precio DECIMAL(5,2) NOT NULL,
    asientos_disponibles INT NOT NULL,
    FOREIGN KEY (id_pelicula) REFERENCES peliculas(id),
    FOREIGN KEY (id_sala) REFERENCES salas(id)
);

CREATE TABLE reservas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_sesion INT NOT NULL,
    id_cliente INT NOT NULL,
    num_entradas INT NOT NULL,
    total DECIMAL(8,2) NOT NULL,
    FOREIGN KEY (id_sesion) REFERENCES sesiones(id),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);

-- ============================================
-- DATOS DE PRUEBA
-- ============================================

INSERT INTO peliculas (titulo, genero, duracion, anio) VALUES
('Dune: Parte Dos', 'Ciencia Ficción', 166, 2024),
('Oppenheimer', 'Drama', 180, 2023),
('El señor de los anillos: La comunidad del anillo', 'Fantasía', 178, 2001),
('Interstellar', 'Ciencia Ficción', 169, 2014),
('Inception', 'Acción', 148, 2010),
('La La Land', 'Musical', 128, 2016);

INSERT INTO salas (numero, aforo, tipo) VALUES
(1, 120, 'Normal'),
(2, 80, 'Normal'),
(3, 40, 'VIP'),
(4, 100, 'Normal'),
(5, 30, 'VIP');

INSERT INTO clientes (nombre, email, telefono) VALUES
('Ana García López', 'ana.garcia@email.com', '612345678'),
('Carlos Martínez Ruiz', 'carlos.martinez@email.com', '623456789'),
('Laura Sánchez Pérez', 'laura.sanchez@email.com', '634567890'),
('Miguel Fernández Gil', 'miguel.fernandez@email.com', '645678901'),
('Sofía Torres Vega', 'sofia.torres@email.com', '656789012');

INSERT INTO sesiones (id_pelicula, id_sala, fecha, hora, precio, asientos_disponibles) VALUES
(1, 1, '2025-05-20', '16:00:00', 9.50, 120),
(1, 3, '2025-05-20', '19:30:00', 14.00, 40),
(2, 2, '2025-05-20', '17:00:00', 9.50, 80),
(3, 4, '2025-05-21', '18:00:00', 9.50, 100),
(4, 5, '2025-05-21', '20:00:00', 14.00, 30),
(5, 1, '2025-05-22', '19:00:00', 9.50, 115),
(6, 2, '2025-05-22', '20:30:00', 9.50, 75);

INSERT INTO reservas (id_sesion, id_cliente, num_entradas, total) VALUES
(1, 1, 2, 19.00),
(2, 2, 1, 14.00),
(6, 3, 3, 28.50),
(3, 4, 2, 19.00),
(5, 5, 2, 28.00);

-- Actualizamos asientos disponibles según las reservas insertadas
UPDATE sesiones SET asientos_disponibles = 116 WHERE id = 1;
UPDATE sesiones SET asientos_disponibles = 39 WHERE id = 2;
UPDATE sesiones SET asientos_disponibles = 78 WHERE id = 3;
UPDATE sesiones SET asientos_disponibles = 112 WHERE id = 6;
UPDATE sesiones SET asientos_disponibles = 28 WHERE id = 5;