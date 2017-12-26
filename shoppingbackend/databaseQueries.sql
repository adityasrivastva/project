CREATE table category(
	
	id INT  auto_increment
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN, 
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)

)


INSERT INTO category (name,description,image_url,is_active ) values ('Laptop' , 'This is description for Laptop category', 'CAT-1.png', true);
INSERT INTO category (name,description,image_url,is_active ) values ('Television' , 'This is description for Television category', 'CAT-2.png', true);
INSERT INTO category (name,description,image_url,is_active ) values ('Mobile' , 'This is description for Mobile category', 'CAT-3.png', true);



CREATE TABLE user_detail (      
	id INT AUTO_INCREMENT,  
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    role VARCHAR(50),
    enabled BOOLEAN,
    password VARCHAR(50),
    email VARCHAR(100), 
    contact_number VARCHAR(15), 
      
    CONSTRAINT pk_user_id PRIMARY KEY (id) 
);

INSERT into user_detail
(first_name, first_name, role, enabled, password, email, contact_number)
VALUES ('Virat', 'Kohli' ,'ADMIN', true, 'admin', 'ck@gmail.com', '8888888888');

INSERT into user_detail
(first_name, first_name, role, enabled, password, email, contact_number)
VALUES ('Ravindra', 'Jadeja' ,'SUPPLIER', true, '12345', 'rj@gmail.com', '9999999999');

INSERT into user_detail
(first_name, first_name, role, enabled, password, email, contact_number )
VALUES ('Ravichnadra', 'Ashwin' ,'SUPPLIER', true, '12345', 'ra@gmail.com', '7777777777');



CREATE TABLE product (      
	id INT AUTO_INCREMENT,  
    code VARCHAR(20),   
    name VARCHAR(50),
    brand VARCHAR(50),   
    description VARCHAR(255), 
    unit_price DECIMAL (10,2),
    is_active BOOLEAN, 
    category_id INT,
    supplier_id INT,
    purchases INT DEFAULT 0,
    views INT DEFAULT 0,
    
    CONSTRAINT pk_product_id PRIMARY KEY (id) ,
    CONSTRAINT fk_product_category_id  FOREIGN KEY (category_id)  REFERENCES category(id),
    CONSTRAINT fk_product_supplier_id  FOREIGN KEY (supplier_id)  REFERENCES user_detail(id)    
 
);





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