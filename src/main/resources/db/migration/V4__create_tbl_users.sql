CREATE TABLE tbl_users(
	 id BIGINT(20) NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
)ENGINE = INNODB DEFAULT CHARSET=UTF8; 
