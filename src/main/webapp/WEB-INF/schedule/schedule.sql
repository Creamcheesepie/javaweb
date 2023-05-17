/* chedule.sql*/

show tables;

create table schedule(
	idx 			int	not null auto_increment primary key,
	midx			int not null,
	mid				varchar(20) not null,					/*회원 아이디(일정 검색시 시 필요*/
	sDate			datetime not null,						/*일정 등록 날짜*/
	part			varchar(10) not null,					/*분류(1.모임, 2.업무, 3.학습, 4.여행...5.기타)*/
	content 	text not null,									/*일정 상세내역*/
	foreign key(midx,mid) references member(idx,mid)
);


create table schedule(
	idx 			int	not null auto_increment primary key,
	mid				varchar(20) not null,					/*회원 아이디(일정 검색시 시 필요*/
	sDate			datetime not null,						/*일정 등록 날짜*/
	part			varchar(10) not null,					/*분류(1.모임, 2.업무, 3.학습, 4.여행...5.기타)*/
	content 	text not null									/*일정 상세내역*/
);

desc schedule;
drop table schedule;

insert into schedule values (default,'admin','2023-05-17','학습','jsp주제발표');
insert into schedule values (default,'admin','2023-05-18','학습','데이터베이스 설계');
insert into schedule values (default,'hkd1234','2023-05-15','업무','탐관오리 사냥');
insert into schedule values (default,'ppman1234','2023-04-17','학습','ppt 리퀘스트업무');
insert into schedule values (default,'admin','2023-08-07','학습','부트스트랩 발표');
insert into schedule values (default,'coldman','2023-05-23','모임','건강관리');
insert into schedule values (default,'admin','2023-04-17','학습','웹개발에 관하여');
insert into schedule values (default,'admin','2023-05-21','기타','jsp프로젝트진행');
insert into schedule values (default,'admin','2023-05-10','모임','백엔드개발자회');
insert into schedule values (default,'ppman1234','2023-05-13','업무','ppt템플릿설명회');
insert into schedule values (default,'ppman1234','2023-05-08','학습','심화디자인과정');
insert into schedule values (default,'ppman1234','2023-04-21','학습','향상된애니메이션ppt');
insert into schedule values (default,'coldman','2023-05-01','학습','애플 개발자가 알려주는 꿀팁수강');
insert into schedule values (default,'admin','2023-05-12','기타','꿀잠을위한 안면모임');
insert into schedule values (default,'admin','2023-05-17','학습','jsp중급코딩');

select * from schedule where mid='admin' and sDate='2023-05-07' order by sDate desc;
select * from schedule where mid='admin' and sDate='2023-05' order by sDate desc; /*요건 안됨 양식을 맞춰야함.*/
select * from schedule where mid='admin' and date_format(sDate,'%Y-%m-%d')='2023-05' order by sDate desc; /*dat>>e<< format (data가 아님!)*/
select * from schedule where mid='admin' and date_format(sDate,'%Y-%m')='2023-05' order by sDate desc;
select * from schedule where mid='admin' and date_format(sDate,'%Y-%m')='2023-05' group by part order by sDate desc;

select * from schedule where mid='admin' and date_format(sDate,'%Y-%m')='2023-05' order by sDate desc , part;



