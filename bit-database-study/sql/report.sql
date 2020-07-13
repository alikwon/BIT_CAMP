create table report(
	idx number(4) PRIMARY key,
	sname VARCHAR2(20) not null,
	sno VARCHAR2(10) not null,
	reportfile VARCHAR2(100) not null
);

create SEQUENCE report_seq;

insert into report 
values(report_seq.nextval, '길동','1234','/file/123123123_report.ppt');
select * from report;