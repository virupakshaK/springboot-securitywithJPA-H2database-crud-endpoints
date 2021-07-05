 --DROP TABLE IF EXISTS users;
 --create table users(
 --	  id  INT AUTO_INCREMENT primary key,
 --     username varchar_ignorecase(50) not null,
 --     password varchar_ignorecase(150) not null,
 --     enabled boolean not null,
 --     roles varchar_ignorecase(100) not null);


      
DROP TABLE IF EXISTS Test;

CREATE TABLE Test (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  userName VARCHAR(250) NOT NULL,
  age INT NOT NULL,
  Location VARCHAR(250) DEFAULT NULL
);

