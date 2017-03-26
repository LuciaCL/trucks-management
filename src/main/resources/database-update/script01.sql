--liquibase formatted sql
--changeset lucia:script01cs001
drop table if exists c_interval;
drop table if exists expense;
drop table if exists carrier;
drop table if exists journey;
drop table if exists customer;
drop table if exists section;
drop table if exists trailer;
drop table if exists truck;

create table carrier (
	id int(11) auto_increment,
	dni varchar(6) not null,
	name varchar(25),
	address varchar(50), 
	telephone varchar(10),
	constraint pk_carrier primary key(id)
);

create table c_interval (
	id int(11) auto_increment,
	time_ini bigint(20) not null,
	time_fin bigint(20) not null,
	carrier_id int(11), 
	constraint pk_interval primary key(id),
	constraint fk1_interval_carrier foreign key(carrier_id) references carrier(id)
);

create table customer (
	id int(11) auto_increment,
	cif varchar(12) not null,
	address varchar(25),
	constraint pk_customer primary key(id)	
);

create table journey (
	id int(11) auto_increment,
	origin varchar(25) not null,
	destination varchar(25) not null, 
	price_km numeric,
	customer_id int(11),
	description varchar(255),
	constraint pk_journey primary key(id),	
	constraint fk1_journey_customer foreign key(customer_id) references customer(id)
);

create table truck (
	id int(11) auto_increment,
	plate_number varchar(6) not null,
	tare numeric,
	weight numeric, 
	dimension numeric,
	brand varchar(25),
	model varchar(25),
	constraint pk_truck primary key(id)	
);

create table trailer (
	id int(11) auto_increment,
	plate_number varchar(6) not null,
	tare numeric,
	weight numeric, 
	dimension numeric,
	brand varchar(25),
	model varchar(25),
	constraint pk_trailer primary key(id)	
);

create table expense (
	id int(11) auto_increment,
	cost numeric,
	concept1 varchar(255),
	concept2 varchar(255),
	expense_date bigint(20),
	carrier_id int(11),
	journey_id int(11),
	trailer_id int(11),
	truck_id int(11),
	constraint pk_expense primary key(id),
	constraint fk1_expense_carrier foreign key(carrier_id) references carrier(id),
	constraint fk2_expense_journey foreign key(journey_id) references journey(id),
	constraint fk3_expense_trailer foreign key(trailer_id) references trailer(id),
	constraint fk3_expense_truck foreign key(truck_id) references truck(id)
);

create table section (
	id int(11) auto_increment,
	initial_latitude numeric,
	final_latitude numeric,
	initial_longitude numeric,
	final_longitude numeric,
	initial_point varchar(100),
	final_point varchar(100),
	initial_date bigint(20),
	final_date bigint(20),
	carrier_id int(11),
	journey_id int(11),
	trailer_id int(11),
	truck_id int(11),
	constraint pk_section primary key(id),
	constraint fk1_section_carrier foreign key(carrier_id) references carrier(id),
	constraint fk2_section_journey foreign key(journey_id) references journey(id),
	constraint fk3_section_trailer foreign key(trailer_id) references trailer(id),
	constraint fk3_section_truck foreign key(truck_id) references truck(id)
);

--changeset david:script01cs002
alter table truck modify column tare double;
alter table truck modify column weight double;
alter table truck modify column dimension double;

--changeset lucia:script01cs003
alter table trailer modify column tare double;
alter table trailer modify column weight double;
alter table trailer modify column dimension double;
alter table journey modify column price_km double;

--changeset david:script01:cs004
alter table carrier modify column dni varchar(9) not null;

--changeset lucia:script01:cs005
alter table c_interval modify column id bigint;