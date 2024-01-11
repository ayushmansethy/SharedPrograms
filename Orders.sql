CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(50),
    customer_email VARCHAR(50),
    customer_address VARCHAR(255)
);

CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

CREATE TABLE Items (
    item_id INT PRIMARY KEY,
    order_id INT,
    item_name VARCHAR(50),
    item_price DECIMAL(10, 2),
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id)
);

CREATE TABLE ShippingAddresses (
    address_id INT PRIMARY KEY,
    customer_id INT,
    address_line1 VARCHAR(255),
    address_line2 VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    zip_code VARCHAR(20),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);
