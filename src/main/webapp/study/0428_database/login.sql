/*login.sql*/
show databases;

use javaweb;

select*from sungjuk;

create table login(
	idx int not null auto_increment primary key, 
	mid varchar(20) not null,
	pwd varchar(20) not null,
	name varchar(20) not null,
	point int default 100,
	lastDate datetime default now(), 
	todayCount int default 0
);

desc login;

insert into login values (default,"admin","1234","관리자",default,default,default);

select * from login;