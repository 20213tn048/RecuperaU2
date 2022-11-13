create database recuperau2;
use recuperau2;

create table docentes(
	id bigint auto_increment not null,
    name varchar (40) not null,
    surname varchar (40) not null,
    lastname varchar (40) not null,
    birthday varchar (30) not null,
    curp varchar (40) not null,
    dni varchar(30) not null,
    primary key (id)
);

create table alumnos(
	id bigint auto_increment not null,
    name varchar (40) not null,
    surname varchar (40) not null,
    lastname varchar (40) not null,
    birthday varchar (30) not null,
    curp varchar (40) not null,
    dni varchar (30) not null,
    primary key (id)
);

create table grupos(
	id bigint auto_increment not null,
    grade varchar (10) not null,
    grup varchar (10) not null,
    division varchar (10) not null,
    primary key (id)
);

create table calificaciones(
	id bigint auto_increment not null,
    grade varchar(10) not null,
    primary key (id)
);

INSERT INTO `recuperau2`.`docentes` (`name`, `surname`, `lastname`, `birthday`, `curp`, `dni`) VALUES ('Miguel', 'Angel', 'Moreno', '2000-06-20', 'CASAR#EAFEA', '123412345');
INSERT INTO `recuperau2`.`alumnos` (`name`, `surname`, `lastname`, `birthday`, `curp`, `dni`) VALUES ('Angel', 'Camargo', 'Silva', '2003-02-18', 'CASA030218HMCMLNA2', '20213tn048');
INSERT INTO `recuperau2`.`grupos` (`grade`, `grup`, `division`) VALUES ('4', 'B', 'DSM');
INSERT INTO `recuperau2`.`calificaciones` (`grade`) VALUES ('9.0');

alter table docentes add idGrupo bigint not null;
alter table docentes add foreign key (idGrupo) references grupos (id);

alter table alumnos add idGrupo bigint not null;
alter table alumnos add foreign key (idGrupo) references grupos (id);
alter table alumnos add idDocente bigint not null;
alter table alumnos add foreign key (idDocente) references docentes (id);

alter table grupos add idDocente bigint not null;
alter table grupos add foreign key (idDocente) references docentes (id);

alter table calificaciones add idAlumno bigint not null;
alter table calificaciones add foreign key (idAlumno) references alumnos (id);

alter table docentes add unique (curp, dni);
alter table alumnos add unique (curp,dni);

UPDATE `recuperau2`.`docentes` SET `idGrupo` = '1' WHERE (`id` = '1');
UPDATE `recuperau2`.`alumnos` SET `idGrupo` = '1', `idDocente` = '1' WHERE (`id` = '1');
UPDATE `recuperau2`.`grupos` SET `idDocente` = '1' WHERE (`id` = '1');
UPDATE `recuperau2`.`calificaciones` SET `idAlumno` = '1' WHERE (`id` = '1');

select * from docentes;
select * from alumnos;
select * from grupos;
select * from calificaciones;

