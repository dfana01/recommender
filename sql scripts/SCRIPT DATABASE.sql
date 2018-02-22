/*create database recommendersystemdb
go
use recommendersystemdb
go*/

create table users
(
  user_id int primary key,
  first_name varchar(20),
  last_name varchar(20),
  phone varchar(15),
  email varchar(50)
);


create table credentials
(
   user_id int primary key,
   user_name varchar(20),
   password varchar(30)
);



create table movies
(
   id int primary key,
   title varchar(50),
   genres varchar(30)
);


create table ratings
(
   id int ,
   user_id int,
   movie_id int,
   calification int,
   created datetime
);



create table recommendations
(
  id int,
  user_id int,
  movie_id int,
  created datetime
);


create table links
(
   moview_id int,
   imdb_id int,
   tmpdb_id int
);