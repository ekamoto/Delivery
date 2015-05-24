
CREATE DATABASE delivery
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'pt_BR.UTF-8'
       LC_CTYPE = 'pt_BR.UTF-8'
       CONNECTION LIMIT = -1;

create table grupoUsuarios (
id serial primary key not null,
descricao varchar(150) not null
);

insert into grupoUsuarios (descricao) values('Cliente');
insert into grupoUsuarios (descricao) values('Entregador');

create table pessoas (
id serial primary key not null,
nome varchar(150) not null,
cpf varchar(14) not null,
endereco varchar(150),
idGrupoUsuarios int not null references grupoUsuarios(id)
);

create table categorias (
id serial primary key not null,
nome varchar(100) not null,
descricao varchar(150) not null
);
insert into categorias (nome, descricao) values('Destilados','Bebidas destiladas');
insert into categorias (nome, descricao) values('Vinhos','Vinhos');

create table produtos (
id serial primary key not null,
nome varchar(100) not null,
descricao varchar(150) not null,
fabricante varchar(100) not null,
quantidade int,
valor float not null,
idCategoria int not null references categorias(id),
status int NOT NULL
);

create table pedidos (
id serial primary key not null,
idCliente int not null references pessoas(id),
idEntregador int not null, /*Não está forenkey por causa da iteração, isso será feito em outra iteração*/
valorPedido float not null,
valorPagamento float not null,
valorTroco float not null,
status int NOT NULL
);

create table itensPedido(
idPedido int not null references pedidos(id),
idProduto int not null references produtos(id),
valorUnitario float not null,
quantidade int not null
);

