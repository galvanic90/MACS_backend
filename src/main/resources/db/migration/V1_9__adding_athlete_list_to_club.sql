create table club_athlete_list (club_id integer not null, athlete_list_id integer not null);
alter table if exists club_athlete_list drop constraint if exists UKq79nkst5dyl9v0ovgu9m0pa8r;
alter table if exists club_athlete_list add constraint UKq79nkst5dyl9v0ovgu9m0pa8r unique (athlete_list_id);
alter table if exists club_athlete_list add constraint FK9d4rl15p2701frmywybr11dxw foreign key (athlete_list_id) references athlete;
alter table if exists club_athlete_list add constraint FK7v6h7ibnlrdtsw6d03w6ampd8 foreign key (club_id) references club;
