CREATE TABLE tbl_categories(
	 id BIGINT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(200),
    PRIMARY KEY (id)
)ENGINE = INNODB DEFAULT CHARSET=UTF8; 
