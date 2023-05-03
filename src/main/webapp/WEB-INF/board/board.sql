show tables;

create table board1 (
	idx int not null auto_increment, /*게시글 고유번호*/
	mid varchar(20) not null, /*게시글 작정자 아이디*/
	nickName varchar(20) not null, /*게시글 작성자 닉네임 */
	title varchar(200) not null, /*게시글 제목*/
	email varchar(50), /*이메일 주소*/
	homePage varchar(50), /*홈페이지 주소*/
	content text not null,	/*게시글 내용*/
	readNum int default 0,	/*글 조회수*/
	hostIp varchar(30) not null, /*작성자 ip*/
	openSw char(2) default 'ok', /*게시글 공개여부*/
	wDate dateTime default now(),   /*오늘의 신문*/
	good int default 0, /*추천 수 누적*/
	
	primary key(idx)
);

desc board1;
                            idx      mid     닉      제목                  이메일  									홈페이지												내용					조회수    	아이피				공개여부    날짜    추천수
insert into board1 values (default,"admin","관리맨","게시판 서비스 시작합니다.","gnldbs1004@gmail.com","gnldbs1004@naver.com","이곳은 게시판 입니다.",default,"192.168.50.88",default,default,default);