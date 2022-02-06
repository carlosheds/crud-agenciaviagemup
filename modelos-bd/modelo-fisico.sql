create database CrudAgenciaViagemUp;
use CrudAgenciaViagemUp;

create table cliente (
	 id_cliente int primary key identity(1,1),
	 nome varchar(50) not null,
	 idade int not null
);

create table destino (
	id_destino int primary key identity(1,1),
	pais varchar(15) not null,
	estado varchar(15) not null,
	cidade varchar(15) not null
);

create table passagem (
	id_passagem int primary key identity(1,1),
	id_cliente int not null,
	id_destino int not null,
	preco decimal(16,2) not null
);

alter table passagem add foreign key (id_cliente) references cliente (id_cliente);
alter table passagem add foreign key (id_destino) references destino (id_destino);

select * from passagem;

UPDATE passagem SET preco = 1340.90 WHERE id_passagem = 2;