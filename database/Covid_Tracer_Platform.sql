-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-04-15 05:38:22.835

-- tables
-- Table: country
CREATE TABLE country (
    country_id int NOT NULL AUTO_INCREMENT,
    iso varchar(50) NOT NULL,
    country varchar(100) NOT NULL,
    longitude real(21,12) NOT NULL,
    latitude real(21,12) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT country_pk PRIMARY KEY (country_id)
);

-- Table: covid_data
CREATE TABLE covid_data (
    covid_data_id int NOT NULL AUTO_INCREMENT,
    country_id int NOT NULL,
    department_id int NULL,
    municipality_id int NULL,
    confirmed int NULL,
    cumulative_confirmed int NOT NULL,
    dead int NULL,
    cumulative_dead int NOT NULL,
    recovered int NULL,
    cumulative_recovered int NULL,
    date timestamp NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT covid_data_pk PRIMARY KEY (covid_data_id)
);

-- Table: data_request
CREATE TABLE data_request (
    data_request_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    country_id int NULL,
    department_id int NULL,
    municipality_id int NULL,
    type int NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT data_request_pk PRIMARY KEY (data_request_id)
);

-- Table: department
CREATE TABLE department (
    department_id int NOT NULL AUTO_INCREMENT,
    country_id int NOT NULL,
    iso varchar(50) NOT NULL,
    department varchar(100) NOT NULL,
    longitude real(21,12) NOT NULL,
    latitude real(21,12) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT department_pk PRIMARY KEY (department_id)
);

-- Table: h_covid_data
CREATE TABLE h_covid_data (
    h_covid_data_id int NOT NULL AUTO_INCREMENT,
    covid_data_id int NOT NULL,
    country_id int NOT NULL,
    department_id int NULL,
    municipality_id int NULL,
    confirmed int NULL,
    cumulative_confirmed int NOT NULL,
    dead int NULL,
    cumulative_dead int NOT NULL,
    recovered int NULL,
    cumulative_recovered int NOT NULL,
    date timestamp NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_covid_data_pk PRIMARY KEY (h_covid_data_id)
);

-- Table: h_data_request
CREATE TABLE h_data_request (
    h_data_request_id int NOT NULL AUTO_INCREMENT,
    data_request_id int NOT NULL,
    user_id int NOT NULL,
    country_id int NULL,
    department_id int NULL,
    municipality_id int NULL,
    type int NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_data_request_pk PRIMARY KEY (h_data_request_id)
);

-- Table: h_user
CREATE TABLE h_user (
    h_user_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    person_id int NOT NULL,
    email varchar(150) NOT NULL,
    user_name varchar(150) NOT NULL,
    password varchar(150) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_user_pk PRIMARY KEY (h_user_id)
);

-- Table: h_vaccine
CREATE TABLE h_vaccine (
    h_vaccine_id int NOT NULL AUTO_INCREMENT,
    vaccine_id int NOT NULL,
    vaccine_type_id int NOT NULL,
    country_id int NOT NULL,
    department_id int NULL,
    vaccinated int NULL,
    cumulative_vaccinated int NOT NULL,
    date timestamp NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_vaccine_pk PRIMARY KEY (h_vaccine_id)
);

-- Table: municipality
CREATE TABLE municipality (
    municipality_id int NOT NULL AUTO_INCREMENT,
    department_id int NOT NULL,
    municipality varchar(100) NOT NULL,
    longitude real(21,12) NOT NULL,
    latitude real(21,12) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT municipality_pk PRIMARY KEY (municipality_id)
);

-- Table: person
CREATE TABLE person (
    person_id int NOT NULL AUTO_INCREMENT COMMENT 'Self-incrementing primary key of person table.',
    first_name varchar(150) NOT NULL,
    first_surname varchar(150) NOT NULL,
    second_surname varchar(150) NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (person_id)
);

-- Table: role
CREATE TABLE role (
    role_id int NOT NULL AUTO_INCREMENT,
    role varchar(100) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (role_id)
);

-- Table: transaction
CREATE TABLE transaction (
    tx_id int NOT NULL AUTO_INCREMENT,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT transaction_pk PRIMARY KEY (tx_id)
);

-- Table: user
CREATE TABLE user (
    user_id int NOT NULL AUTO_INCREMENT,
    person_id int NOT NULL,
    email varchar(150) NOT NULL,
    user_name varchar(150) NOT NULL,
    password varchar(150) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
);

-- Table: user_role
CREATE TABLE user_role (
    user_role_id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    role_id int NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (user_role_id)
);

-- Table: vaccine
CREATE TABLE vaccine (
    vaccine_id int NOT NULL AUTO_INCREMENT,
    vaccine_type_id int NOT NULL,
    country_id int NOT NULL,
    department_id int NULL,
    vaccinated int NULL,
    cumulative_vaccinated int NOT NULL,
    date timestamp NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT vaccine_pk PRIMARY KEY (vaccine_id)
);

-- Table: vaccine_type
CREATE TABLE vaccine_type (
    vaccine_type_id int NOT NULL AUTO_INCREMENT,
    type int NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT vaccine_type_pk PRIMARY KEY (vaccine_type_id)
);

-- foreign keys
-- Reference: covid_data_country (table: covid_data)
ALTER TABLE covid_data ADD CONSTRAINT covid_data_country FOREIGN KEY covid_data_country (country_id)
    REFERENCES country (country_id);

-- Reference: covid_data_department (table: covid_data)
ALTER TABLE covid_data ADD CONSTRAINT covid_data_department FOREIGN KEY covid_data_department (department_id)
    REFERENCES department (department_id);

-- Reference: covid_data_municipality (table: covid_data)
ALTER TABLE covid_data ADD CONSTRAINT covid_data_municipality FOREIGN KEY covid_data_municipality (municipality_id)
    REFERENCES municipality (municipality_id);

-- Reference: data_request_country (table: data_request)
ALTER TABLE data_request ADD CONSTRAINT data_request_country FOREIGN KEY data_request_country (country_id)
    REFERENCES country (country_id);

-- Reference: data_request_department (table: data_request)
ALTER TABLE data_request ADD CONSTRAINT data_request_department FOREIGN KEY data_request_department (department_id)
    REFERENCES department (department_id);

-- Reference: data_request_municipality (table: data_request)
ALTER TABLE data_request ADD CONSTRAINT data_request_municipality FOREIGN KEY data_request_municipality (municipality_id)
    REFERENCES municipality (municipality_id);

-- Reference: data_request_user (table: data_request)
ALTER TABLE data_request ADD CONSTRAINT data_request_user FOREIGN KEY data_request_user (user_id)
    REFERENCES user (user_id);

-- Reference: department_country (table: department)
ALTER TABLE department ADD CONSTRAINT department_country FOREIGN KEY department_country (country_id)
    REFERENCES country (country_id);

-- Reference: municipality_department (table: municipality)
ALTER TABLE municipality ADD CONSTRAINT municipality_department FOREIGN KEY municipality_department (department_id)
    REFERENCES department (department_id);

-- Reference: user_person (table: user)
ALTER TABLE user ADD CONSTRAINT user_person FOREIGN KEY user_person (person_id)
    REFERENCES person (person_id);

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role FOREIGN KEY user_role_role (role_id)
    REFERENCES role (role_id);

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_user FOREIGN KEY user_role_user (user_id)
    REFERENCES user (user_id);

-- Reference: vaccine_country (table: vaccine)
ALTER TABLE vaccine ADD CONSTRAINT vaccine_country FOREIGN KEY vaccine_country (country_id)
    REFERENCES country (country_id);

-- Reference: vaccine_department (table: vaccine)
ALTER TABLE vaccine ADD CONSTRAINT vaccine_department FOREIGN KEY vaccine_department (department_id)
    REFERENCES department (department_id);

-- Reference: vaccine_vaccine_type (table: vaccine)
ALTER TABLE vaccine ADD CONSTRAINT vaccine_vaccine_type FOREIGN KEY vaccine_vaccine_type (vaccine_type_id)
    REFERENCES vaccine_type (vaccine_type_id);

-- End of file.

