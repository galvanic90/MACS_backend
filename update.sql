create table championship (id integer not null, end_event_date timestamp(6), name varchar(255), start_event_date timestamp(6), fk_club integer not null, fk_location integer not null, primary key (id));
create sequence championship_seq start with 1 increment by 50;
alter table if exists championship add constraint FKio3b5rwak8wl49adodhk7xgmi foreign key (fk_club) references club;
alter table if exists championship add constraint FK6crwfyvqtjqu0w1tauho6vpxv foreign key (fk_location) references location;
