#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: CATEGORIE
#------------------------------------------------------------

CREATE TABLE CATEGORIE(
        CATEGORIE_ID  int (11) Auto_increment  NOT NULL ,
        CATEGORIE_NOM Varchar (40) NOT NULL ,
        NB_PLACE      Int NOT NULL ,
        TYPE_PERMIS   Varchar (1) NOT NULL ,
        PRIMARY KEY (CATEGORIE_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: VEHICULE
#------------------------------------------------------------

CREATE TABLE VEHICULE(
        IMMATRICULATION  int (11) Auto_increment  NOT NULL ,
        VEHICULE_COULEUR Varchar (15) NOT NULL ,
        DATE_ACHAT       Date NOT NULL ,
        KILOMETRAGE      Float NOT NULL ,
        CATEGORIE_ID     Int NOT NULL ,
        AGENCE_ID        Int NOT NULL ,
        MARQUE_ID        Varchar (3) NOT NULL ,
        PRIMARY KEY (IMMATRICULATION )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: AGENCE
#------------------------------------------------------------

CREATE TABLE AGENCE(
        AGENCE_ID      int (11) Auto_increment  NOT NULL ,
        NUMERO_RUE     Int ,
        RUE            Varchar (150) NOT NULL ,
        TELEPHONE      Varchar (13) NOT NULL ,
        VILLE_ID       Int NOT NULL ,
        RESPONSABLE_ID Varchar NOT NULL ,
        PRIMARY KEY (AGENCE_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: VILLE
#------------------------------------------------------------

CREATE TABLE VILLE(
        VILLE_ID    Varchar (3) NOT NULL ,
        VILLE_NAME  Varchar (50) ,
        CODE_POSTAL Varchar (10) ,
        PAYS_ID     Varchar (3) NOT NULL ,
        PRIMARY KEY (VILLE_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: PAYS
#------------------------------------------------------------

CREATE TABLE PAYS(
        PAYS_ID   Varchar (3) NOT NULL ,
        PAYS_NAME Varchar (45) NOT NULL ,
        PRIMARY KEY (PAYS_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: CLIENT
#------------------------------------------------------------

CREATE TABLE CLIENT(
        CLIENT_ID     int (11) Auto_increment  NOT NULL ,
        CLIENT_PRENOM Varchar (30) NOT NULL ,
        CLIENT_NOM    Varchar (30) NOT NULL ,
        NUMERO_RUE    Int NOT NULL ,
        RUE           Varchar (100) NOT NULL ,
        CODE_POSTAL   Varchar (10) NOT NULL ,
        VILLE         Varchar (40) NOT NULL ,
        PAYS          Varchar (40) NOT NULL ,
        PRIMARY KEY (CLIENT_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: RESPONSABLE
#------------------------------------------------------------

CREATE TABLE RESPONSABLE(
        RESPONSABLE_ID     Varchar (3) NOT NULL ,
        RESPONSABLE_PRENOM Varchar (60) NOT NULL ,
        RESPONSABLE_NAME   Varchar (60) NOT NULL ,
        PRIMARY KEY (RESPONSABLE_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TARIF
#------------------------------------------------------------

CREATE TABLE TARIF(
        TARIF_ID int (11) Auto_increment  NOT NULL ,
        PRIMARY KEY (TARIF_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: MARQUE
#------------------------------------------------------------

CREATE TABLE MARQUE(
        MARQUE_ID   Varchar (3) NOT NULL ,
        MARQUE_NAME Varchar (25) NOT NULL ,
        PRIMARY KEY (MARQUE_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: MODELE
#------------------------------------------------------------

CREATE TABLE MODELE(
        MODELE_ID   int (11) Auto_increment  NOT NULL ,
        MODELE_NAME Varchar (25) NOT NULL ,
        MARQUE_ID   Varchar (3) NOT NULL ,
        PRIMARY KEY (MODELE_ID )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: DOSSIER
#------------------------------------------------------------

CREATE TABLE DOSSIER(
        dossier_id      int (11) Auto_increment  NOT NULL ,
        date_debut      Date NOT NULL ,
        date_fin        Date NOT NULL ,
        AGENCE_ID       Int NOT NULL ,
        CLIENT_ID       Int NOT NULL ,
        AGENCE_ID_1     Int NOT NULL ,
        AGENCE_ID_2     Int NOT NULL ,
        IMMATRICULATION Int NOT NULL ,
        PRIMARY KEY (AGENCE_ID ,CLIENT_ID ,AGENCE_ID_1 ,AGENCE_ID_2 ,IMMATRICULATION )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: coûte
#------------------------------------------------------------

CREATE TABLE coute(
        composante_journaliere  Float NOT NULL ,
        composante_hebdomadaire Float NOT NULL ,
        composante_km           Int NOT NULL ,
        forfait                 Float ,
        complement_assurance    Float ,
        TARIF_ID                Int NOT NULL ,
        CATEGORIE_ID            Int NOT NULL ,
        PRIMARY KEY (TARIF_ID ,CATEGORIE_ID )
)ENGINE=InnoDB;

ALTER TABLE VEHICULE ADD CONSTRAINT FK_VEHICULE_CATEGORIE_ID FOREIGN KEY (CATEGORIE_ID) REFERENCES CATEGORIE(CATEGORIE_ID);
ALTER TABLE VEHICULE ADD CONSTRAINT FK_VEHICULE_AGENCE_ID FOREIGN KEY (AGENCE_ID) REFERENCES AGENCE(AGENCE_ID);
ALTER TABLE VEHICULE ADD CONSTRAINT FK_VEHICULE_MARQUE_ID FOREIGN KEY (MARQUE_ID) REFERENCES MARQUE(MARQUE_ID);
ALTER TABLE AGENCE ADD CONSTRAINT FK_AGENCE_VILLE_ID FOREIGN KEY (VILLE_ID) REFERENCES VILLE(VILLE_ID);
ALTER TABLE AGENCE ADD CONSTRAINT FK_AGENCE_RESPONSABLE_ID FOREIGN KEY (RESPONSABLE_ID) REFERENCES RESPONSABLE(RESPONSABLE_ID);
ALTER TABLE VILLE ADD CONSTRAINT FK_VILLE_PAYS_ID FOREIGN KEY (PAYS_ID) REFERENCES PAYS(PAYS_ID);
ALTER TABLE MODELE ADD CONSTRAINT FK_MODELE_MARQUE_ID FOREIGN KEY (MARQUE_ID) REFERENCES MARQUE(MARQUE_ID);
ALTER TABLE DOSSIER ADD CONSTRAINT FK_DOSSIER_AGENCE_ID FOREIGN KEY (AGENCE_ID) REFERENCES AGENCE(AGENCE_ID);
ALTER TABLE DOSSIER ADD CONSTRAINT FK_DOSSIER_CLIENT_ID FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT(CLIENT_ID);
ALTER TABLE DOSSIER ADD CONSTRAINT FK_DOSSIER_AGENCE_ID_1 FOREIGN KEY (AGENCE_ID_1) REFERENCES AGENCE(AGENCE_ID);
ALTER TABLE DOSSIER ADD CONSTRAINT FK_DOSSIER_AGENCE_ID_2 FOREIGN KEY (AGENCE_ID_2) REFERENCES AGENCE(AGENCE_ID);
ALTER TABLE DOSSIER ADD CONSTRAINT FK_DOSSIER_IMMATRICULATION FOREIGN KEY (IMMATRICULATION) REFERENCES VEHICULE(IMMATRICULATION);
ALTER TABLE coute ADD CONSTRAINT FK_coute_TARIF_ID FOREIGN KEY (TARIF_ID) REFERENCES TARIF(TARIF_ID);
ALTER TABLE coute ADD CONSTRAINT FK_coute_CATEGORIE_ID FOREIGN KEY (CATEGORIE_ID) REFERENCES CATEGORIE(CATEGORIE_ID);



INSERT INTO CATEGORIE ( CATEGORIE_ID, CATEGORIE_NOM, NB_PLACE, TYPE_PERMIS) VALUES (
'Citadine',5, 'B');
INSERT INTO CATEGORIE ( CATEGORIE_ID, CATEGORIE_NOM, NB_PLACE, TYPE_PERMIS) VALUES (
'Camionette',3, 'B');
INSERT INTO CATEGORIE ( CATEGORIE_ID, CATEGORIE_NOM, NB_PLACE, TYPE_PERMIS) VALUES (
'Mini-Bus',11, 'D1');
INSERT INTO CATEGORIE ( CATEGORIE_ID, CATEGORIE_NOM, NB_PLACE, TYPE_PERMIS) VALUES (
'Berline',5, 'B');
INSERT INTO CATEGORIE ( CATEGORIE_ID, CATEGORIE_NOM, NB_PLACE, TYPE_PERMIS) VALUES (
'Bus',50, 'D');
INSERT INTO CATEGORIE ( CATEGORIE_ID, CATEGORIE_NOM, NB_PLACE, TYPE_PERMIS) VALUES (
'Monospace',7, 'B');
INSERT INTO CATEGORIE ( CATEGORIE_ID, CATEGORIE_NOM, NB_PLACE, TYPE_PERMIS) VALUES (
'Camion', 3, 'CE');

INSERT INTO MARQUE ( MARQUE_ID,  MARQUE_NAME) VALUES (
'REN','Renault');
INSERT INTO MARQUE ( MARQUE_ID,  MARQUE_NAME) VALUES (
'PEU','Peugeot');
INSERT INTO MARQUE ( MARQUE_ID,  MARQUE_NAME) VALUES (
'CIT','Citroën');
INSERT INTO MARQUE ( MARQUE_ID,  MARQUE_NAME) VALUES (
'LAM','Lamborghini');
INSERT INTO MARQUE ( MARQUE_ID,  MARQUE_NAME) VALUES (
'FER','Ferrari');
INSERT INTO MARQUE ( MARQUE_ID,  MARQUE_NAME) VALUES (
'IVE','Iveco');
INSERT INTO MARQUE ( MARQUE_ID,  MARQUE_NAME) VALUES (
'FOR','Ford');

INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'Espace','REN');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'Clio','REN');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'Megane','REN');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'208','PEU');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'3008','PEU');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'108','PEU');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'C1','CIT');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'C3','CIT');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'C4','CIT');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'Aventador','LAM');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'Huracan','LAM');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'Urus','LAM');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'F50','FER');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'F40','FER');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'F30','FER');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'Stralis','IVE');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'Eurocargo','IVE');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'UrbanWay','IVE');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'Daily','IVE');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'Fiesta','FOR');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'KAA','FOR');
INSERT INTO MODELE ( MODELE_ID,  MODELE_NAME, MARQUE_ID) VALUES (
'Kuga','FOR');



INSERT INTO AGENCE ( AGENCE_ID, NUMERO_RUE, RUE, TELEPHONE, VILLE_ID, RESPONSABLE_ID ) VALUES (
4,'Rue du bois de la sivrite','+33899868064','VAN','RBA');
INSERT INTO AGENCE ( AGENCE_ID, NUMERO_RUE, RUE, TELEPHONE, VILLE_ID, RESPONSABLE_ID ) VALUES (
20,'Rue Saint Pierre','+33387389071','MET','LST');
INSERT INTO AGENCE ( AGENCE_ID, NUMERO_RUE, RUE, TELEPHONE, VILLE_ID, RESPONSABLE_ID ) VALUES (
5,'Rue du lotissement Marot','+33553472259','AGE','JMO');
INSERT INTO AGENCE ( AGENCE_ID, NUMERO_RUE, RUE, TELEPHONE, VILLE_ID, RESPONSABLE_ID ) VALUES (
10,'Lebenstrasse','+4930/227-32152','MUN','AHI');
INSERT INTO AGENCE ( AGENCE_ID, NUMERO_RUE, RUE, TELEPHONE, VILLE_ID, RESPONSABLE_ID ) VALUES (
153,'Bundesstrasse','+4930/330-35452','BER','AHI');
INSERT INTO AGENCE ( AGENCE_ID, NUMERO_RUE, RUE, TELEPHONE, VILLE_ID, RESPONSABLE_ID ) VALUES (
25,'Kartoffelstrasse','+4930/210-32552','FRA','AHI');
INSERT INTO AGENCE ( AGENCE_ID, NUMERO_RUE, RUE, TELEPHONE, VILLE_ID, RESPONSABLE_ID ) VALUES (
10,'Rue des horlogers','+41332225569','GEN','LSP');
INSERT INTO AGENCE ( AGENCE_ID, NUMERO_RUE, RUE, TELEPHONE, VILLE_ID, RESPONSABLE_ID ) VALUES (
18,'Rue des chocolats','+41342595569','ZUR','GLA');
INSERT INTO AGENCE ( AGENCE_ID, NUMERO_RUE, RUE, TELEPHONE, VILLE_ID, RESPONSABLE_ID ) VALUES (
51,'Rue de Rex','+41332695569','LUC','EMO');



INSERT INTO VILLE ( VILLE_ID, VILLE_NAME, CODE_POSTAL, PAYS_ID ) VALUES (
'VAN','Vandoeuvre-Les-Nancy','54500','FRA');
INSERT INTO VILLE ( VILLE_ID, VILLE_NAME, CODE_POSTAL, PAYS_ID ) VALUES (
'MET','Metz','57000','FRA');
INSERT INTO VILLE ( VILLE_ID, VILLE_NAME, CODE_POSTAL, PAYS_ID ) VALUES (
'AGE','Agen','47000','FRA');
INSERT INTO VILLE ( VILLE_ID, VILLE_NAME, CODE_POSTAL, PAYS_ID ) VALUES (
'MUN','Munich','80331','ALL');
INSERT INTO VILLE ( VILLE_ID, VILLE_NAME, CODE_POSTAL, PAYS_ID ) VALUES (
'BER','Berlin','10115','ALL');
INSERT INTO VILLE ( VILLE_ID, VILLE_NAME, CODE_POSTAL, PAYS_ID ) VALUES (
'FRA','Francfort','60306','ALL');
INSERT INTO VILLE ( VILLE_ID, VILLE_NAME, CODE_POSTAL, PAYS_ID ) VALUES (
'GEN','Geneve','1201','SUI');
INSERT INTO VILLE ( VILLE_ID, VILLE_NAME, CODE_POSTAL, PAYS_ID ) VALUES (
'ZUR','Zurich','8000','SUI');
INSERT INTO VILLE ( VILLE_ID, VILLE_NAME, CODE_POSTAL, PAYS_ID ) VALUES (
'LUC','Lucerne','6003','SUI');



INSERT INTO PAYS ( PAYS_ID, PAYS_NAME ) VALUES (
'FRA','France');
INSERT INTO PAYS ( PAYS_ID, PAYS_NAME ) VALUES (
'ALL','Allemagne');
INSERT INTO PAYS ( PAYS_ID, PAYS_NAME ) VALUES (
'SUI','Suisse');



INSERT INTO RESPONSABLE ( RESPONSABLE_ID, RESPONSABLE_PRENOM, RESPONSABLE_NAME ) VALUES (
'RBA','Regis','BAMONDE');
INSERT INTO RESPONSABLE ( RESPONSABLE_ID, RESPONSABLE_PRENOM, RESPONSABLE_NAME ) VALUES (
'LST','Laurence','STOFFEL');
INSERT INTO RESPONSABLE ( RESPONSABLE_ID, RESPONSABLE_PRENOM, RESPONSABLE_NAME ) VALUES (
'JMO','Jean-Marc','MOREAU');
INSERT INTO RESPONSABLE ( RESPONSABLE_ID, RESPONSABLE_PRENOM, RESPONSABLE_NAME ) VALUES (
'AHI','Adrien','HIPSTER');
INSERT INTO RESPONSABLE ( RESPONSABLE_ID, RESPONSABLE_PRENOM, RESPONSABLE_NAME ) VALUES (
'LSP','Loic','SPACHER');
INSERT INTO RESPONSABLE ( RESPONSABLE_ID, RESPONSABLE_PRENOM, RESPONSABLE_NAME ) VALUES (
'GLA','Gaetan','LAGRAVIERE');
INSERT INTO RESPONSABLE ( RESPONSABLE_ID, RESPONSABLE_PRENOM, RESPONSABLE_NAME ) VALUES (
'EMO','Elise','MOREAU');



INSERT INTO coute (composante_journaliere, composante_hebdomadaire,composante_km,forfait,complement_assurance,TARIF_ID,CATEGORIE_ID)
VALUES (10,60,16,0.05,15,'Tarif 1','Citadine');
INSERT INTO coute (composante_journaliere, composante_hebdomadaire,composante_km,forfait,complement_assurance,TARIF_ID,CATEGORIE_ID)
VALUES (15,90,20,0.05,15,'Tarif 2','Berline');
INSERT INTO coute (composante_journaliere, composante_hebdomadaire,composante_km,forfait,complement_assurance,TARIF_ID,CATEGORIE_ID)
VALUES (20,120,25,0.05,15,'Tarif 3','Monospace');
INSERT INTO coute (composante_journaliere, composante_hebdomadaire,composante_km,forfait,complement_assurance,TARIF_ID,CATEGORIE_ID)
VALUES (25,150,30,0.05,20,'Tarif 4','Camionette');
INSERT INTO coute (composante_journaliere, composante_hebdomadaire,composante_km,forfait,complement_assurance,TARIF_ID,CATEGORIE_ID)
VALUES (35,210,45,0.1,40,'Tarif 5','Mini-Bus');
INSERT INTO coute (composante_journaliere, composante_hebdomadaire,composante_km,forfait,complement_assurance,TARIF_ID,CATEGORIE_ID)
VALUES (50,300,90,0.1,40,'Tarif 6','Bus');
INSERT INTO coute (composante_journaliere, composante_hebdomadaire,composante_km,forfait,complement_assurance,TARIF_ID,CATEGORIE_ID)
VALUES (65,390,85,0.1,40,'Tarif 7','Camion');
INSERT INTO coute (composante_journaliere, composante_hebdomadaire,composante_km,forfait,complement_assurance,TARIF_ID,CATEGORIE_ID)



INSERT INTO TARIF (TARIF_ID) VALUES ('Tarif 1')
INSERT INTO TARIF (TARIF_ID) VALUES ('Tarif 2')
INSERT INTO TARIF (TARIF_ID) VALUES ('Tarif 3')
INSERT INTO TARIF (TARIF_ID) VALUES ('Tarif 4')
INSERT INTO TARIF (TARIF_ID) VALUES ('Tarif 5')
INSERT INTO TARIF (TARIF_ID) VALUES ('Tarif 6')
INSERT INTO TARIF (TARIF_ID) VALUES ('Tarif 7')
