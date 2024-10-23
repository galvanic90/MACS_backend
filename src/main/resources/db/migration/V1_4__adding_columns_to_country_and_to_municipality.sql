alter table if exists country add column three_char_country_code varchar(255);
alter table if exists country add column two_char_country_code varchar(255);
create table municipality (id integer not null, name varchar(255), fk_department integer, primary key (id));
create sequence municipality_seq start with 1 increment by 50;
alter table if exists municipality add constraint FKthx6cra4ti5gane6njq0hkprt foreign key (fk_department) references department;
