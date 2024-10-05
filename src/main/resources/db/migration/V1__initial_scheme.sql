CREATE TABLE customers(
    ctr_id SERIAL PRIMARY KEY ,
    ctr_dni VARCHAR NOT NULL UNIQUE,
    ctr_f_name VARCHAR NOT NULL ,
    ctr_l_name VARCHAR NOT NULL ,
    ctr_genre VARCHAR NOT NULL
);

CREATE TABLE customer_audit(
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    user_name VARCHAR NOT NULL,
    action VARCHAR NOT NULL,
    local_date_time TIMESTAMP
);
