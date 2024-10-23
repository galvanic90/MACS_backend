alter table if exists location add column municipality_id integer;
alter table if exists location drop constraint if exists UKlxduifr1oahk3fyxrnwei7trk;
alter table if exists location add constraint UKlxduifr1oahk3fyxrnwei7trk unique (municipality_id);
alter table if exists location add constraint FKsfehc6uhis4l0rhvmkkyru2lx foreign key (municipality_id) references municipality;
alter table if exists location add column municipality_id integer;
alter table if exists location drop constraint if exists UKlxduifr1oahk3fyxrnwei7trk;
alter table if exists location add constraint UKlxduifr1oahk3fyxrnwei7trk unique (municipality_id);
alter table if exists location add constraint FKsfehc6uhis4l0rhvmkkyru2lx foreign key (municipality_id) references municipality;
