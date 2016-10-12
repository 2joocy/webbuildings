create table building(
id int not null auto_increment,
address varchar(45) not null,
zip int not null,
city varchar(45) not null,
contactPerson varchar(45) not null,
contactPhone varchar(45) not null,

PRIMARY KEY (id)
);

create table room(
id int not null auto_increment,
floorNumber int not null,
roomNumber int not null,
amountWindows int not null,
squareMeters int not null,
fk_idBuilding int not null,
FOREIGN KEY (fk_idBuilding) REFERENCES building(id),

PRIMARY KEY (id)
);