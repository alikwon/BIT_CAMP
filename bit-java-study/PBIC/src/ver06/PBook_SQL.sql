-- Basic 테이블 시퀀스
create sequence PBB_idx_seq 
	start with 0
	minvalue 0
;
-- Company 테이블 시퀀스
create sequence PBC_idx_seq
	start with 0
	minvalue 0
;
-- Univ 테이블 시퀀스
create sequence PBU_idx_seq
	start with 0
	minvalue 0
;
-- Cafe 테이블 시퀀스
create sequence PBF_idx_seq
	start with 0
	minvalue 0
;
-- Basic 테이블
create table phoneinfo_basic(
	idx number(6) primary key,
	name varchar2(20) not null,
	phonenumber varchar2(20) not null,
	email varchar2(20),
	address varchar2(20)
);
-- Univ 테이블
create table phoneinfo_univ(
	idx number(6) primary key,
	major varchar2(20) default 'N',
	year number(2) check(year between 1 and 4),
	ref number(6) not null,
	constraint phoneinfo_univ_idx_fk foreign key(ref) 
		references phoneinfo_basic(idx) on delete cascade
);
-- Company 테이블
create table phoneinfo_com(
	idx number(6) primary key,
	company varchar2(20) default 'N',
	dept varchar2(20) default 'N',
	job varchar2(20) default 'N',
	ref number(6) not null,
	constraint phoneinfo_com_idx_fk foreign key(ref) 
		references phoneinfo_basic(idx) on delete cascade
);
-- Cafe 테이블
create table phoneinfo_cafe(
	idx number(6) primary key,
	cafeName varchar2(20) default 'N' not null,
	nickName varchar2(20) default 'N',
	ref number(6) not null,
	constraint phoneinfo_cafe_idx_fk foreign key(ref)
		references phoneinfo_basic(idx) on delete cascade
);