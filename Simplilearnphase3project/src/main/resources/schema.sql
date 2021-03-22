DROP TABLE IF EXISTS sh_admin;
 
CREATE table sh_admin
( 
  id int IDENTITY(1,1) PRIMARY KEY,
  first_name varchar(20) NOT NULL,
  last_name varchar(30) ,
  pwd varchar(30) NOT NULL
  )