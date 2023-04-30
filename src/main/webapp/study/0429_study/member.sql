
show databases;

use javaweb;

create table memberStudy(
	idx int not null auto_increment primary key,
	mid varchar(20) not null,
	pwd varchar(20) not null,
	name varchar(20) not null,
	nickName varchar(20) not null,
	createDate datetime default now(),
	lastLoginDate datetime default now(),
	totalLoginCount int default 0,
	point int default 0,
	memberGrade char(1) not null default "e"
);

desc memberStudy;

insert into memberStudy values(default,"admin","1234","관리자","administrator",default,default,default,default,"A");

select * from memberStudy;

create table board(
	idx int not null auto_inclment primary key,
	Mid varchar(20) not null,
	deleteKey int(4) not null,
	title varchar(30) not null,
	article varchar(30000) not null
)
