alter table if exists combats_by_championship add column feed_in boolean not null;
alter table if exists combats_by_championship add column round integer;
alter table if exists combats_by_championship add column fk_categories_by_champ integer not null;
alter table if exists combats_by_championship add constraint FKtqaa1922j9b2epk09i0k9teua foreign key (fk_categories_by_champ) references categories_by_championship;