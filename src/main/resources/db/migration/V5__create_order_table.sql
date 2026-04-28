CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL,
    created_at TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);
