CREATE TABLE Utenti (

IDUtente int auto_increment,
Nome  varchar (50),
Cognome  varchar (50),
Indirizzo   varchar (250),
PagamentoOnline boolean,
Cellulare   varchar (10),
eMail   varchar (50),
NomeUtente   varchar (50),
`Password`varchar (50),
primary key (IDUtente)

);

CREATE TABLE ServiziOfferti (

IDServiziOfferti int auto_increment,
DescrizioneServizio varchar (350),
primary key (IDServiziOfferti)

);

CREATE TABLE Fornitori (

IDFornitore int auto_increment,
NomeFornitore varchar (100),
CodiceFornitore varchar (10),
IndirizzoFornitore varchar (250),
primary key (IDFornitore)

);

CREATE TABLE FornitoriServizi (

IDFornitore int,
IDServizio int,
foreign key (IDFornitore) references Fornitori (IDFornitore),
foreign key (IDServizio) references ServiziOfferti (IDServiziOfferti)

);

CREATE TABLE Prodotto (

IDProdotto int auto_increment,
NomeProdotto varchar (50),
CodiceProdotto varchar (10),
Prezzo double,
Disponibilità int,
Fornitore int ,
foreign key (Fornitore) references Fornitori (IDFornitore)

);

CREATE TABLE Review (

IDReview int auto_increment,
TestoReview varchar (500),
Ordine int,
foreign key (Ordine) references Ordini (IDOrdini)

);











 
