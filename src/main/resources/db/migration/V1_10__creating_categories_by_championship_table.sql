create table categories_by_championship (id integer not null, fk_category integer, fk_championship integer, primary key (id));
create sequence categories_by_championship_seq start with 1 increment by 50;
alter table if exists categories_by_championship add constraint FK28r7ys3nhfjnla3qj9anwjiwe foreign key (fk_category) references categories;
alter table if exists categories_by_championship add constraint FKnsdtontkx5599yhkce561haem foreign key (fk_championship) references championship;
