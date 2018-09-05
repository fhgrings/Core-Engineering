create database agenda;
use agenda;
create table contatos (
	id int auto_increment primary key,
    nome varchar(200),
    telefone char(11),
    email varchar(100)
);