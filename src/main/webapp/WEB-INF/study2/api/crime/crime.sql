show tables;

create table crime(
	idx 			int not null auto_increment primary key,
	year 			int ,/*발생년도*/
	police		varchar(20) not null,
	robbery 	int, /*강도건수*/
	murder		int, /*살인건수*/
	theft			int, /*절도건수*/
	violence	int	 /*폭행건수*/
);

desc crime ;

