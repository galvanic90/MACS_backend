create table athlete (id integer not null, birth_date varchar(255), id_number varchar(255), last_name varchar(255), name varchar(255), picture_url varchar(255), sex varchar(255), weight float(53) not null, fk_belt_grade integer, fk_club integer, fk_document_type integer, fk_country integer, primary key (id));
create sequence athlete_seq start with 1 increment by 50;
alter table if exists athlete add constraint FKdy2jjim1bs4uua4isny0x70y9 foreign key (fk_belt_grade) references belt_grade;
alter table if exists athlete add constraint FKeqmqebp2jbghwjsey1fgv42rh foreign key (fk_club) references club;
alter table if exists athlete add constraint FKjqw93h9xfgwbhyo5tiqkiiuql foreign key (fk_document_type) references document_type;
alter table if exists athlete add constraint FKb2gqr88jmxe9m583a8866048r foreign key (fk_country) references country;
