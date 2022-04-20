DROP table if exists mentors;
CREATE table mentors
(
    id int generated always as identity,
    first_name varchar(40) not null,
    last_name  varchar(40) not null,
    primary key (id)
);

DROP table if exists mentor_audit;
create table mentor_audit(
                             id  int generated always as identity,
                             mentor_id int not null ,
                             last_name varchar(40) not null,
                             changed_on timestamp(6) not null,
                             primary key(id)
);

insert into mentors(first_name, last_name) values ('Mike','Smith');
insert into mentors(first_name, last_name) values ('Tom','Hanks');

create or replace function log_last_name_changes()
    returns trigger
    language plpgsql
as
    $$
begin
    if new.last_name<>old.last_name then
    insert into mentor_audit(mentor_id,last_name,changed_on)values
    (old.id,old.last_name,now());
end if;

return new;
end;
    $$;

create trigger last_name_change
    BEFORE update
    ON mentors
    FOR EACH ROW
    EXECUTE PROCEDURE log_last_name_changes();


create trigger last_name_change2
    AFTER update
    ON mentors
    FOR EACH ROW
    EXECUTE PROCEDURE log_last_name_changes();

UPDATE mentors
SET last_name='wer'
where id=2;

select *
from pg_trigger;

drop trigger if exists last_name_change2 ON mentors;