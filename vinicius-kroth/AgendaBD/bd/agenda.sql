CREATE SCHEMA agenda;

DROP TABLE contatos;

CREATE TABLE contato (
id INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(150) NOT NULL , 
numero CHAR(11) UNIQUE,
email VARCHAR(100) UNIQUE,
PRIMARY KEY(id)
);
