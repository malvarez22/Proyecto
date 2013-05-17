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


DROP TABLE IF EXISTS isOwner;
CREATE TABLE isOwner(  
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,  
  first_name VARCHAR(60),
  last_name VARCHAR(60),
  city VARCHAR(60),
  phone_number VARCHAR(20),
  neighborhood VARCHAR(60),
  street VARCHAR(60),
  email VARCHAR(30)
)ENGINE=innoDB;


INSERT INTO `isOwner` (`first_name`,`last_name`,`city`,`phone_number`,`neighborhood`,`street`,`email`) VALUES 
 ('', '', '', '', '', '', ''),
 ('', '', '', '', '', '', ''),
 ('', '', '', '', '', '', '');

DROP TABLE IF EXISTS realState;
CREATE TABLE realState(
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  first_name VARCHAR(60),
  city VARCHAR(60),
  neighborhood VARCHAR(60),
  street VARCHAR(60),
  phone_number VARCHAR(20),
  email VARCHAR(20),
  WebSite VARCHAR(30),
  idOwner int(11),
FOREIGN KEY (idOwner) REFERENCES isOwner(id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=innoDB;

DROP TABLE IF EXISTS Building_Owner;
CREATE TABLE Building_Owner(
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  first_name VARCHAR(60),
  last_name VARCHAR(60),  
  city VARCHAR(60),
  neighborhood VARCHAR(60),
  street VARCHAR(60),
  email VARCHAR(30),
  phone_number VARCHAR(20),
  idRealState int(11),
 FOREIGN KEY (idRealState) REFERENCES realState(id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=innoDB;



DROP TABLE IF EXISTS Building;
CREATE TABLE Building(  
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  city VARCHAR(60),
  neighborhood VARCHAR(60),
  street VARCHAR(60),
  descriptive_text VARCHAR(80),
  price int (12),
  isType ENUM ('campo','quinta', 'casa', 'departamento','oficina','cochera'),
  situation ENUM('VENTA','ALQUILER'),
  id_realState int(11),
  id_ownerBuilding int (11),
  FOREIGN KEY (id_realState) REFERENCES realState(id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (id_ownerBuilding) REFERENCES Building_Owner(id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=innoDB;


DROP TABLE IF EXISTS ad;
CREATE TABLE ad(  
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  descriptive_text VARCHAR(80),
  id_Building int(11),
  id_ownerBuilding int(11),
  FOREIGN KEY (id_Building) REFERENCES Building(id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (id_ownerBuilding) REFERENCES Building_Owner(id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=innoDB;

