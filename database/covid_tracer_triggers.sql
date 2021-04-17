#DROP TRIGGERS
drop trigger if exists trigger_insert_h_user;
drop trigger if exists trigger_update_h_user;
drop trigger if exists trigger_insert_h_data_request;
drop trigger if exists trigger_update_h_data_request;
drop trigger if exists trigger_insert_h_vaccine;
drop trigger if exists trigger_update_h_vaccine;
drop trigger if exists trigger_insert_h_covid_data;
drop trigger if exists trigger_update_h_covid_data;

# User triggers
DELIMITER |
CREATE TRIGGER trigger_insert_h_user
AFTER INSERT ON user
FOR EACH ROW
BEGIN
	insert into h_user values (null,new.user_id,new.person_id,new.email,new.user_name,new.password,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER trigger_update_h_user
AFTER UPDATE ON user
FOR EACH ROW
BEGIN
	insert into h_user values (null,new.user_id,new.person_id,new.email,new.user_name,new.password,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

# Data_request triggers
DELIMITER |
CREATE TRIGGER trigger_insert_h_data_request
AFTER INSERT ON data_request
FOR EACH ROW
BEGIN
	insert into h_data_request values (null,new.data_request_id,new.user_id,new.country_id,new.department_id,new.municipality_id,new.type,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER trigger_update_h_data_request
AFTER UPDATE ON data_request
FOR EACH ROW
BEGIN
	insert into h_data_request values (null,new.data_request_id,new.user_id,new.country_id,new.department_id,new.municipality_id,new.type,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

#Vaccine triggers
DELIMITER |
CREATE TRIGGER trigger_insert_h_vaccine
AFTER INSERT ON vaccine
FOR EACH ROW
BEGIN
	insert into h_vaccine values (null,new.vaccine_id,new.department_id,new.first_vaccine,new.second_vaccine,new.date,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER trigger_update_h_vaccine
AFTER UPDATE ON vaccine
FOR EACH ROW
BEGIN
		insert into h_vaccine values (null,new.vaccine_id,new.department_id,new.first_vaccine,new.second_vaccine,new.date,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

#Covid_data triggers
DELIMITER |
CREATE TRIGGER trigger_insert_h_covid_data
AFTER INSERT ON covid_data
FOR EACH ROW
BEGIN
	insert into h_covid_data values (null,new.covid_data_id,new.country_id,new.department_id,new.municipality_id,new.confirmed,new.cumulative_confirmed,new.deaths,new.cumulative_deaths,new.recovered,new.cumulative_recovered,new.date,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;

DELIMITER |
CREATE TRIGGER trigger_update_h_covid_data
AFTER UPDATE ON covid_data
FOR EACH ROW
BEGIN
	insert into h_covid_data values (null,new.covid_data_id,new.country_id,new.department_id,new.municipality_id,new.confirmed,new.cumulative_confirmed,new.deaths,new.cumulative_deaths,new.recovered,new.cumulative_recovered,new.date,new.status,new.tx_id,new.tx_host,new.tx_user_id,new.tx_date);
END;
|
DELIMITER ;