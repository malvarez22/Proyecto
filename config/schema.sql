DROP TABLE IF EXISTS users;
CREATE TABLE users(
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  email VARCHAR(60),
  first_name VARCHAR(56),
  last_name VARCHAR(56)
)ENGINE=innoDB;

INSERT INTO `users` (`email`,`first_name`,`last_name`) VALUES 
 ('', '', ''),
 ('', '', ''),
 ('', '', '');


DROP TABLE IF EXISTS owners;
CREATE TABLE owners(  
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,  
  first_name VARCHAR(60),
  last_name VARCHAR(60),
  city VARCHAR(60),
  phone_number VARCHAR(20),
  neighborhood VARCHAR(60),
  street VARCHAR(60),
  email VARCHAR(30)
)ENGINE=innoDB;


INSERT INTO `owners` (`first_name`,`last_name`,`city`,`phone_number`,`neighborhood`,`street`,`email`) VALUES 
 ('', '', '', '', '', '', ''),
 ('', '', '', '', '', '', ''),
 ('', '', '', '', '', '', '');

DROP TABLE IF EXISTS real_states;
CREATE TABLE real_states(
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  first_name VARCHAR(60),
  city VARCHAR(60),
  neighborhood VARCHAR(60),
  street VARCHAR(60),
  phone_number VARCHAR(20),
  email VARCHAR(20),
  webSite VARCHAR(30),
  id_owners int(11),
FOREIGN KEY (id_owners) REFERENCES owners(id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=innoDB;

DROP TABLE IF EXISTS owner_buildings;
CREATE TABLE owner_buildings(
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  first_name VARCHAR(60),
  last_name VARCHAR(60),  
  city VARCHAR(60),
  neighborhood VARCHAR(60),
  street VARCHAR(60),
  email VARCHAR(30),
  phone_number VARCHAR(20),
  id_realStates int(11),
 FOREIGN KEY (id_realStates) REFERENCES real_states(id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=innoDB;



DROP TABLE IF EXISTS buildings;
CREATE TABLE buildings(  
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  city VARCHAR(60),
  neighborhood VARCHAR(60),
  street VARCHAR(60),
  descriptive_text VARCHAR(80),
  price int (12),
  isType ENUM ('campo','quinta', 'casa', 'departamento','oficina','cochera'),
  situation ENUM('VENTA','ALQUILER'),
  id_ownersBuilding int (11),
  FOREIGN KEY (id_ownersBuilding) REFERENCES owner_buildings(id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=innoDB;


DROP TABLE IF EXISTS ads;
CREATE TABLE ads(  
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  descriptive_text VARCHAR(80),
  id_Building int(11),
  id_ownersBuilding int(11),
  FOREIGN KEY (id_Building) REFERENCES buildings(id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (id_ownersBuilding) REFERENCES owner_buildings(id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=innoDB;


