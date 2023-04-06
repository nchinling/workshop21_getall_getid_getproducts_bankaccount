create table customers(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
last_name VARCHAR(50),
first_name VARCHAR(50),
email_address VARCHAR(50),
phone_number VARCHAR(50),
citizenship VARCHAR(50)
);

insert into customers(last_name, first_name, email_address, phone_number, citizenship)
values
('chin', 'ng', 'chinng@example.com', '99998888', 'Singaporean'),
('john', 'tan', 'johntan@example.com', '11112222', 'Filipino'),
('ahmad', 'idris', 'ahmadidris@example.com', '33334444', 'Indonesian'),
('meena', 'kaur', 'meenakaur@example.com', '55556666', 'Indian');



create table products(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
product_name VARCHAR(50),
date_created DATE,
value DECIMAL(10, 2),
customer_id INT,
FOREIGN KEY (customer_id) REFERENCES customers(id)
);

insert into products(product_name, date_created, value, customer_id )
values
('Deposit account', '2017-04-06', 1000000, 1),
('Insurance account', '2019-02-03', 200000, 1),
('Equities', '2010-02-01', 20030000, 1),
('Investment account', '2022-02-03', 500000, 1),
('Coco bonds', '2020-12-13', 5000, 1),
('Deposit account', '2017-04-06', 20000, 2),
('Insurance account', '2019-02-03', 100000, 2),
('Equities', '2010-02-01', 99998882, 2),
('Deposit account', '2017-04-06', 1000000, 2),
('Equities', '2010-02-01', 1222245, 3),
('Investment account', '2022-02-03', 9999777, 3),
('Coco bonds', '2020-12-13',7000, 3);


