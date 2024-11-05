create table registrations_by_championship (id integer not null, fk_athlete integer, fk_categories_by_champ integer, primary key (id));
create sequence registrations_by_championship_seq start with 1 increment by 50;
alter table if exists registrations_by_championship add constraint FKo78pwuofb6wwffww4e2hfjijm foreign key (fk_athlete) references athlete;
alter table if exists registrations_by_championship add constraint FKhrelroxwiqpobvutt82gwnacp foreign key (fk_categories_by_champ) references categories_by_championship;
