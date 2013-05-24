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
  phone_number INT(25),
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
  phone_number INT(25),
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
  phone_number INT(25),
  id_realStates int(11),
 FOREIGN KEY (id_realStates) REFERENCES real_states(id) ON UPDATE CASCADE ON DELETE CASCADE
)ENGINE=innoDB;

DROP TABLE IF EXISTS situations;
CREATE TABLE situations(
	id_situations int(5) NOT NULL PRIMARY KEY,
	tipo VARCHAR(34)
)ENGINE=innoDB;

INSERT INTO `situations` (`id_situations`,`tipo`) VALUES 
 ('1','Venta'),
 ('2','Alquiler');
 
DROP TABLE IF EXISTS is_types;
CREATE TABLE is_types(
	idType int(5) NOT NULL PRIMARY KEY,
	tipo VARCHAR(34)
)ENGINE=innoDB;

INSERT INTO `is_types` (`idType`,`tipo`) VALUES 
 ('1','Casa'),
 ('2','Departamento'),
 ('3', 'Oficina'),
 ('4', 'Cochera'),
 ('5', 'Campo');

DROP TABLE IF EXISTS buildings;
CREATE TABLE buildings(  
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  city VARCHAR(60),
  neighborhood VARCHAR(60),
  street VARCHAR(60),
  descriptive_text VARCHAR(80),
  price int (12),
  id_situation int(2),
  id_ownersBuilding int (11),
  id_isType int(5),
  FOREIGN KEY (id_ownersBuilding) REFERENCES owner_buildings(id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (id_isType) REFERENCES is_types(idType) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (id_situation) REFERENCES situations(id_situations) ON UPDATE CASCADE ON DELETE CASCADE
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


