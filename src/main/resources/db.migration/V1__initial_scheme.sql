CREATE TABLE customers(
    ctr_id Long PRIMARY KEY ,
    ctr_dni String NOT NULL UNIQUE,
    ctr_f_name String NOT NULL ,
    crt_l_name String NOT NULL ,
    ctr_genre String NOT NULL
);

CREATE TABLE customer_audit(
    id Long PRIMARY KEY,
    customer_id Long NOT NULL,
    user_name String NOT NULL,
    action String NOT NULL,
    local_date_time DATE
);
