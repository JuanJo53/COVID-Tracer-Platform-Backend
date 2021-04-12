-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-04-12 22:18:05.164

-- tables
-- Table: confirm
CREATE TABLE confirm (
    confirm_id int NOT NULL AUTO_INCREMENT,
    department_id int NOT NULL,
    count int NOT NULL,
    date timestamp NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT confirm_pk PRIMARY KEY (confirm_id)
);

-- Table: data_request
CREATE TABLE data_request (
    download_id int NOT NULL AUTO_INCREMENT,
    department_id int NOT NULL,
    user_user_id int NOT NULL,
    type int NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host int NOT NULL,
    tx_user_id int NOT NULL,
    tx_date int NOT NULL,
    CONSTRAINT data_request_pk PRIMARY KEY (download_id)
);

-- Table: dead
CREATE TABLE dead (
    dead_id int NOT NULL AUTO_INCREMENT,
    department_id int NOT NULL,
    count int NOT NULL,
    date timestamp NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT dead_pk PRIMARY KEY (dead_id)
);

-- Table: departament
CREATE TABLE departament (
    department_id int NOT NULL AUTO_INCREMENT,
    department varchar(100) NOT NULL,
    x real(15,6) NOT NULL,
    y real(15,6) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT departament_pk PRIMARY KEY (department_id)
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

-- Table: province
CREATE TABLE province (
    province_id int NOT NULL AUTO_INCREMENT,
    province varchar(100) NOT NULL,
    x real(15,6) NOT NULL,
    y real(15,6) NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date int NOT NULL,
    CONSTRAINT province_pk PRIMARY KEY (province_id)
);

-- Table: recovered
CREATE TABLE recovered (
    recovered_id int NOT NULL AUTO_INCREMENT,
    department_id int NOT NULL,
    count int NOT NULL,
    date timestamp NOT NULL,
    status int NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(100) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT recovered_pk PRIMARY KEY (recovered_id)
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

-- foreign keys
-- Reference: confirm_departament (table: confirm)
ALTER TABLE confirm ADD CONSTRAINT confirm_departament FOREIGN KEY confirm_departament (department_id)
    REFERENCES departament (department_id);

-- Reference: dead_departament (table: dead)
ALTER TABLE dead ADD CONSTRAINT dead_departament FOREIGN KEY dead_departament (department_id)
    REFERENCES departament (department_id);

-- Reference: download_departament (table: data_request)
ALTER TABLE data_request ADD CONSTRAINT download_departament FOREIGN KEY download_departament (department_id)
    REFERENCES departament (department_id);

-- Reference: download_user (table: data_request)
ALTER TABLE data_request ADD CONSTRAINT download_user FOREIGN KEY download_user (user_user_id)
    REFERENCES user (user_id);

-- Reference: recovered_departament (table: recovered)
ALTER TABLE recovered ADD CONSTRAINT recovered_departament FOREIGN KEY recovered_departament (department_id)
    REFERENCES departament (department_id);

-- Reference: user_person (table: user)
ALTER TABLE user ADD CONSTRAINT user_person FOREIGN KEY user_person (person_id)
    REFERENCES person (person_id);

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role FOREIGN KEY user_role_role (role_id)
    REFERENCES role (role_id);

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_user FOREIGN KEY user_role_user (user_id)
    REFERENCES user (user_id);

-- End of file.

