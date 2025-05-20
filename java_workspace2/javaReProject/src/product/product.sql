-- DB 설정 구문
-- DB 생성
create database javadb;

-- user 설정
create user 'javauser'@'localhost' identified by 'mysql';

-- 유저 권한 부여
grant all privileges on javadb.* to 'javauser'@'localhost';
flush privileges;
  
create table product(
pno int not null auto_increment,
pname varchar(100) not null,
price int default 0,
regdate datetime default now(),
madeby text,
primary key(pno));