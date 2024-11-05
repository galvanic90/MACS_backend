create table combats_by_championship (id integer not null, combat_number integer, points_blue integer, points_red integer, fk_athlete_blue integer, fk_athlete_red integer, fk_winner integer, primary key (id));
create sequence combats_by_championship_seq start with 1 increment by 50;
alter table if exists combats_by_championship add constraint FKr4idara7djpqkxh86kdax7n8t foreign key (fk_athlete_blue) references registrations_by_championship;
alter table if exists combats_by_championship add constraint FKgtjoanwmkgk75xww77rcc797s foreign key (fk_athlete_red) references registrations_by_championship;
alter table if exists combats_by_championship add constraint FKtkrbr8ajvsbca6bfdw1cu6vqo foreign key (fk_winner) references registrations_by_championship;
