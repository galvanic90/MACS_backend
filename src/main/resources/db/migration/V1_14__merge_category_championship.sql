alter table if exists categories_by_championship add column sex smallint check (sex between 0 and 1);
alter table if exists categories_by_championship add column fk_category_age integer;
alter table if exists categories_by_championship add column fk_category_belt_grade integer;
alter table if exists categories_by_championship add column fk_category_weight integer;
alter table if exists categories_by_championship add constraint FKnm5kluqokmaf86hil3decjtlk foreign key (fk_category_age) references category_age;
alter table if exists categories_by_championship add constraint FK85lyiru5jc7qxnui7o0j0awye foreign key (fk_category_belt_grade) references category_belt_grade;
alter table if exists categories_by_championship add constraint FK2pbhxf9ik8ot2khfs9n61thag foreign key (fk_category_weight) references category_weight;
