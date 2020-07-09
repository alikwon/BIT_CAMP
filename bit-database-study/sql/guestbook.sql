-- 방명록 테이블
create table guestbook_message (
	message_id number(4) primary key,
	guest_name varchar2(50) not null,
	password varchar2(10) not null,
	message varchar2(2000) not null
);

create sequence message_id_seq 
increment by 1
start with 0
minvalue 0;


insert into guestbook_message 
values (message_id_seq.nextVal, 'test1','1111', 'write test');

select count(*) from guestbook_message;
select * from guestbook_message;

select ROWNUM, message_id, message
from GUESTBOOK_MESSAGE;

DELETE from guestbook_message
where MESSAGE_ID >= 21;

select rownum rnum,message_id,guest_name,password,message  
from (
	select * 
	from guestbook_message m
	order by m.MESSAGE_ID desc
)
where rownum <= 6
;

select message_id,guest_name,password,message
from(
	select rownum rnum,message_id,guest_name,password,message  
	from (
		select * 
		from guestbook_message m
		order by m.MESSAGE_ID desc
	)
	where rownum <= 6
)
where rnum >= 4;

select * from guestbook_message where message_id=19;

drop table guestbook_message;
drop sequence message_id_seq;

delete from GUESTBOOK_MESSAGE;

commit;
ROLLBACK;
