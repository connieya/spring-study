create database springmybatis;


use springmybatis;

create table employee
(
	id INT not null primary key AUTO_INCREMENT,
	
	fullname varchar(50) not null ,
	
	email varchar(50) not null ,
	
	gender varchar(50) not null ,
	
	hobbies varchar(50) not null,
	
	country varchar(50) not null,
	
	address varchar(50) not null
);
