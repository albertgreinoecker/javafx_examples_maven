drop  database IF EXISTS uni;
create database uni;
use uni;

CREATE TABLE Professoren (
        PersNr              int PRIMARY KEY,
        Name              varchar(100) NULL,
        Rang              varchar(100) NULL,
        Raum              varchar(100) NULL
);


insert into Professoren values (2125,'Sokrates','C4','226');
insert into Professoren values (2126,'Russel','C4','232');
insert into Professoren values (2127,'Kopernikus','C3','310');
insert into Professoren values (2133,'Popper','C3','52');
insert into Professoren values (2134,'Augustinus','C3','309');
insert into Professoren values (2136,'Curie','C4','36');
insert into Professoren values (2137,'Kant','C4','7');

CREATE TABLE Studenten (
        MatrNr            int PRIMARY KEY,
        Name              varchar(100) NOT NULL,
        Semester          int NOT NULL
);

insert into Studenten values (24002,'Xenokrates',18);
insert into Studenten values (25403,'Jonas',12);
insert into Studenten values (26120,'Fichte',10);
insert into Studenten values (26830,'Aristoxenos',8);
insert into Studenten values (27550,'Schopenhauer',6);
insert into Studenten values (28106,'Carnap',3);
insert into Studenten values (29120,'Theophrastos',2);
insert into Studenten values (29555,'Feuerbach',2);


CREATE TABLE Vorlesungen (
        VorlNr            int PRIMARY KEY,
        Titel            varchar(100) NOT NULL,
        SWS              int NOT NULL,
        gelesen_von      int NOT NULL
);

insert into Vorlesungen values(5001,'Grundzüge',4,2137);
insert into Vorlesungen values(5041,'Ethik',4,2125);
insert into Vorlesungen values(5043,'Erkenntnistheorie',3,2126);
insert into Vorlesungen values(5049,'Mäeutik',2,2125);
insert into Vorlesungen values(4052,'Logik',4,2125);
insert into Vorlesungen values(5052,'Wissenschaftstheorie',3,2126);
insert into Vorlesungen values(5216,'Bioethik',2,2126);
insert into Vorlesungen values(5259,'Der Wiener Kreis',2,2133);
insert into Vorlesungen values(5022,'Glaube und Wissen',2,2134);
insert into Vorlesungen values(4630,'Die 3 Kritiken',4,2137);


CREATE TABLE hoeren (
        MatrNr            int NOT NULL,
        VorlNr            int NOT NULL
);


insert into hoeren values(26120,5001);
insert into hoeren values(27550,5001);
insert into hoeren values(27550,4052);
insert into hoeren values(28106,5041);
insert into hoeren values(28106,5052);
insert into hoeren values(28106,5216);
insert into hoeren values(28106,5259);
insert into hoeren values(29120,5001);
insert into hoeren values(29120,5041);
insert into hoeren values(29120,5049);
insert into hoeren values(29555,5022);
insert into hoeren values(25403,5022);

CREATE TABLE Assistenten (
        PerslNr          int PRIMARY KEY,
        Name              varchar(100) NOT NULL,
        Fachgebiet        varchar(100) NOT NULL,
        Boss              int NOT NULL
);

insert into Assistenten values(3002,'Platon','Ideenlehre',2125);
insert into Assistenten values(3003,'Aristoteles','Syllogistik',2125);
insert into Assistenten values(3004,'Wittgenstein','Sprachtheorie',2126);
insert into Assistenten values(3005,'Rhetikus','Planetenbewegung',2127);
insert into Assistenten values(3006,'Newton','Keplersche Gesetze',2127);
insert into Assistenten values(3007,'Spinoza','Gott und Natur',2126);
