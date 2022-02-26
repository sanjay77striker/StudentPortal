create database studentdetails;
use studentdetails;

select * from student;

create table student(
regno varchar(20) primary key,
name varchar(20),
dob date,
mobile varchar(20),
gender varchar(20),
std int,
hometown varchar(20)
);