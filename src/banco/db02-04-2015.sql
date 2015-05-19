
CREATE DATABASE delivery
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'pt_BR.UTF-8'
       LC_CTYPE = 'pt_BR.UTF-8'
       CONNECTION LIMIT = -1;

create table pessoas (
id serial primary key not null,
nome varchar(70) not null,
cpf varchar(14) not null,
endereco varchar(150)
);

create table produtos (
id serial primary key not null,
nome varchar(70) not null,
descricao varchar(14) not null,
quantidade int,
valor float not null,
ativo boolean NOT NULL DEFAULT TRUE
);
