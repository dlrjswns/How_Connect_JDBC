select * from all_tables;

create table text(
	a int, 
	b varchar(10)
);

insert into text values(10, '티모');
insert into text values(20, '아리');
insert into text values(30, '아무무');
insert into text values(40, '가렌');
insert into text values(50, '홍길동');
insert into text values(60, '제드');
insert into text values(70, '소라카');

select * from text;

select * from text where b like '아%'

drop table test;