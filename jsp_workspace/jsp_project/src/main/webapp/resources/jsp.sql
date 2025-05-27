-- 2025-05-22
-- DB 생성
create database jspdb;
-- jspdb => 데이터베이스 생성
-- jspuser / mysql

use mysql
create user 'jspuser'@'localhost' identified by 'mysql';
grant all privileges on jspdb.* to jspuser@localhost;
flush privileges;

--board
create table board(
bno int not null auto_increment,
title varchar(100) not null,
writer varchar(50) not null,
content text,
regdate datetime default now(),
moddate datetime default now(),
primary key(bno));

-- comment
-- 2025-05-22
create table comment(
cno int auto_increment,
bno int not null,
writent varchar(50) not null,
content varchar(1000) not null,
regdate datetime default now(),
primary key(cno);

-- 2025-05-26
alter table board add imageFile varchar(300);