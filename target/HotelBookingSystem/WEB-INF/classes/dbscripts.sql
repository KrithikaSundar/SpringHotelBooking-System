create database db;

use db;


create table city(id int NOT NULL AUTO_INCREMENT,cityname varchar(255),PRIMARY KEY(id));


create table hotel(hotelid int NOT NULL AUTO_INCREMENT,hotelname varchar(255),
price double,availablerooms int,id int,checkout date,PRIMARY KEY(hotelid),
FOREIGN KEY(id) REFERENCES city(id));


create table bookedhotels(refno int NOT NULL AUTO_INCREMENT,city varchar(255),
Hotel varchar(255),CheckInDate date,CheckOutDate date,NumberOfRooms int,
price double,PRIMARY KEY(refno));

