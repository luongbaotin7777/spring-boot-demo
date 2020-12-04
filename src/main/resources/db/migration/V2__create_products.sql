CREATE TABLE tbl_products(
	 id BIGINT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price FLOAT(50) NOT NULL,
    description VARCHAR(200),
    category_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_procate FOREIGN KEY (category_id) REFERENCES tbl_categories(id)
) ENGINE = INNODB DEFAULT CHARSET=UTF8; 