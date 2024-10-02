CREATE TABLE customers(
    ctr_id SERIAL PRIMARY KEY ,
    ctr_dni String NOT NULL UNIQUE,
    ctr_f_name String NOT NULL ,
    crt_l_name String NOT NULL ,
    ctr_genre String NOT NULL
);