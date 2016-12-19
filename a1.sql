CREATE DATABASE galaxy;

USE galaxy;

CREATE TABLE customer(
	customerId INT NOT NULL,
    name varchar(15) NOT NULL,
    phone varchar(15),
    emailAddress varchar(50),
    PRIMARY KEY(customerId));
    
CREATE TABLE location(
	cinemaId INT NOT NULL,
    cinemaName varchar(50) NOT NULL,
    streetAddress varchar(50),
    city varchar(30),
    phone varchar(15),
    PRIMARY KEY(cinemaId));
    
INSERT INTO location VALUES
	('1', 'Galaxy cinemas Guelph', '485 Woodlawn Road West', 'Guelph', '(519) 763-3935'),
	('2', 'Galaxy Cinemas Pergola Commons', '85 Clair Road East', 'Guelph', '(519) 821-3468'),
	('3', 'Galaxy Cinemas Milton', '1175 Maple Avenue', 'Milton', '(905) 864-1666'),
	('4', 'Galaxy Cinemas Orangeville', '85 Fifth Avenue', 'Orangeville', '(519) 941-2333');

CREATE TABLE movies(
	movieId INT NOT NULL,
    movieTitle varchar(100),
    PRIMARY KEY(movieId));

INSERT INTO movies VALUES
	('1', 'Planes'),
    ('2', 'Riddick'),
	('3', 'City of Bones');

CREATE TABLE showTimes(
	showId INT NOT NULL,
    movieId INT NOT NULL,
    cinemaId INT NOT NULL,
    showDate date,
    showTime time,
    PRIMARY KEY(showId),    
    FOREIGN KEY (movieId) REFERENCES movies(movieId),
    FOREIGN KEY (cinemaId) REFERENCES location(cinemaId));
    
INSERT INTO showTimes VALUES
	('1', '1', '1', '2013-09-20', '17:00:00'),
	('2', '1', '1', '2013-09-20', '19:00:00'),
	('3', '3', '4', '2013-09-20', '17:00:00'),
	('4', '2', '3', '2013-09-20', '15:15:00');

