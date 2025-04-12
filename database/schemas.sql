CREATE DATABASE IF NOT EXISTS moviesdb;
USE moviesdb;

CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    duration INT NOT NULL
);

INSERT INTO movies (name, genre, duration) VALUES
('Inception', 'Sci-Fi', 148),
('The Dark Knight', 'Action', 152),
('Interstellar', 'Sci-Fi', 169),
('The Godfather', 'Crime', 175),
('Pulp Fiction', 'Crime', 154);