CREATE table category(
	
	id INT  auto_increment
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN, 
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)

)

CREATE TABLE category (      
	id INT AUTO_INCREMENT,  
    name VARCHAR(50),   
    description VARCHAR(255),
    image_url VARCHAR(50),   
    is_active BOOLEAN,   
    CONSTRAINT pk_category_id PRIMARY KEY (id) 
);

INSERT INTO category (name,description,image_url,is_active ) values ('Mobile' , 'This is description for mobile category', 'CAT-3.png', true);










CREATE TABLE EMPLOYEE(
    id INT NOT NULL auto_increment, 
    name VARCHAR(50) NOT NULL,
    joining_date DATE NOT NULL,
    salary DOUBLE NOT NULL,
    ssn VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);