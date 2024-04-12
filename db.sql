--using postgres db and syntax

CREATE DATABASE UserFuelQuotes;

CREATE TABLE IF NOT EXISTS account (
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE IF NOT EXISTS user_profile (
    user_id SERIAL,
    username VARCHAR(100) NOT NULL,
    full_name VARCHAR(50) NOT NULL,
    address1 VARCHAR(100) NOT NULL,
    address2 VARCHAR(100),
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    zipcode VARCHAR(9) NOT NULL,
    profile_completed BOOLEAN DEFAULT FALSE,
    UNIQUE (user_id),
    FOREIGN KEY (username) REFERENCES account(username)
 );

CREATE TABLE IF NOT EXISTS quote (
   quote_id SERIAL,
   user_id BIGINT,
   address VARCHAR(200) NOT NULL,
   gallons_requested DECIMAL(65, 2) NOT NULL,
   delivery_date DATE NOT NULL,
   price_per_gallon DECIMAL(65, 2),
   total DECIMAL(65, 2),
   UNIQUE (quote_id),
   FOREIGN KEY (user_id) REFERENCES user_profile(user_id)
);