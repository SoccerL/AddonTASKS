create database detail;
use detail;
create table class (ID int,Name varchar(60),Mark int,Departement varchar(100),Section varchar(10));
insert into class values(1,"Hari",90,"BSc-CS","III-C"),(2,"Imai",89,"BSc-CS","III-C"),
(3,"Dinesh",69,"BSc-CS","III-C");
update student set name="arun" where id=3;
select name from student where mark<60;
select departement from student where mark<60;
select section from student where mark<60;