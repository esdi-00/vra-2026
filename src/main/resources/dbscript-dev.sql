-- use oraclepdb container
-- alter session set container = oraclepdb;

-- drop user 
drop user vra;

-- create user
create user vra identified by Changeme0;

-- grant basic permissions
grant create session to vra;
grant create table, create view to vra;
alter user vra quota unlimited on users;

-- switch to user 
alter session set current_schema = vra;

-- drp db objects 
drop table item;
drop table customer;
drop table transaction;
drop table transaction_item;

-- create tables
create table item (
    id              number(16)
    ,title          varchar(128)
    ,genre          varchar(16)
    ,description    varchar(64)
    ,copy           number(3)
);

-- create table constraints
alter table item 
add constraint ITEM_PK 
primary key (id);

-- create test data
insert into item (id, title, genre, description, copy) 
values (1, 'The Great Gatsby', 'Fiction', 'A classic novel about the american dream', 10);
insert into item (id, title, genre, description, copy) 
values (2, '1984', 'Dystopian', 'A terrifying vision of a totalitarian future', 15);
insert into item (id, title, genre, description, copy) 
values (3, 'To Kill a Mockingbird', 'Classic', 'A powerful story of race and injustice', 8);
insert into item (id, title, genre, description, copy) 
values (4, 'Dune', 'Science Fiction', 'An epic tale of power and survival on a desert planet', 12);
insert into item (id, title, genre, description, copy) 
values (5, 'The Hobbit', 'Fantasy', 'A Journey through middle earth with bilbo baggins', 20);
insert into item (id, title, genre, description, copy) 
values (6, 'Pride and Prejudice', 'Romance', 'A romantic masterpiece of love and social status', 7);
insert into item (id, title, genre, description, copy) 
values (7, 'Sapiens', 'Non-fiction', 'A brief history of humankind', 14);
insert into item (id, title, genre, description, copy) 
values (8, 'The Matrix', 'SCI-FI Film', 'A computer hacker learns about the true nature of reality', 5);
insert into item (id, title, genre, description, copy) 
values (9, 'The Catcher in The Rye', 'Fiction', 'A story about teenage angst and alienation', 9);
insert into item (id, title, genre, description, copy) 
values (10, 'Steve jobs', 'Biography', 'The definitive biography of the apple co-founder', 11);
commit;