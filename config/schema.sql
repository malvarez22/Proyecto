DROP TABLE IF EXISTS users;
CREATE TABLE users(
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  email VARCHAR(60),
  first_name VARCHAR(56),
  last_name VARCHAR(56),
  contraseña VARCHAR(30)
)ENGINE=innoDB;


DROP TABLE IF EXISTS owners;
CREATE TABLE owners(  
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,  
  first_name VARCHAR(60),
  last_name VARCHAR(60),
  city VARCHAR(60),
  phone_number INT(25),
  neighborhood VARCHAR(60),
  street VARCHAR(60),
  email VARCHAR(30),
  id_realstates VARCHAR(10)
)ENGINE=innoDB;

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
  id_owners int(11)
)ENGINE=innoDB;

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
  id_isType int(11),
  id_realstate int(11)
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

DROP TABLE IF EXISTS owner_buildings;
CREATE TABLE owner_buildings(
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  first_name VARCHAR(60),
  last_name VARCHAR(60),  
  city VARCHAR(60),
  neighborhood VARCHAR(60),
  street VARCHAR(60),
  email VARCHAR(30),
  phone_number int(25),
  id_building int(11),
  id_realstate int(11)  -- En caso de ser NULL, ownerBuilding es un dueño particular.
)ENGINE=innoDB;

DROP TABLE IF EXISTS ads;
CREATE TABLE ads(  
  id  int(11) NOT NULL  auto_increment PRIMARY KEY,
  descriptive_text VARCHAR(80),
  id_Building int(11),
  id_ownersBuilding int(11),
  id_realstate int(11)  -- En caso de ser NULL, es un anuncio de un dueño particular
)ENGINE=innoDB;
