create database vendas;

create table produto(
		
		ID int not null auto_increment primary_key,
		Nome Varchar(50),
		Valor Double,
		Saldo int
		
	)