CREATE TABLE tbl_user_roles(
	 id BIGINT(20) NOT NULL AUTO_INCREMENT,
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES tbl_users(id),
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES tbl_roles(id)
) ENGINE = INNODB DEFAULT CHARSET=UTF8; 