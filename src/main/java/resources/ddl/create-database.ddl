CREATE DATABASE IF NOT EXISTS superstore
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;
  
CREATE USER 'superstore'@'localhost' IDENTIFIED BY 'superstore';
CREATE USER 'superstore'@'%' IDENTIFIED BY 'superstore';

GRANT ALL PRIVILEGES ON superstore . * TO 'superstore'@'localhost';
GRANT ALL PRIVILEGES ON superstore . * TO 'superstore'@'%';
FLUSH PRIVILEGES;
