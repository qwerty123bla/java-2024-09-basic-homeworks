create table otus.test (
	id serial4 not null primary key,
	name varchar(256),
	constraint name_un unique(name)
);


create table otus.answer (
	test integer not null references test(id),
	number integer,
	text varchar(1000),
	is_correct boolean
);



create or replace function check_answer() returns trigger AS $check_answer$
declare
	cnt Int;
begin

select count(1) into cnt
	  from otus.answer a
	 where a.test = NEW.test;

	if cnt > 5 then
		RAISE EXCEPTION 'Ответов должно быть не больше пяти';
	end if;

	return new;
end;
$check_answer$ LANGUAGE plpgsql;

create or replace TRIGGER check_answer after insert ON  otus.answer
    FOR EACH ROW EXECUTE PROCEDURE check_answer();