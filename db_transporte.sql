create database db_transporte;

use db_transporte;

create table endereco (
 id int(11) not null auto_increment primary key,
 rua varchar(20) not null,
 numero varchar(4) not null unique,
 bairro varchar (20) not null,
 cidade varchar (20) not null,
 estado varchar (20) not null);

    INSERT INTO `db_transporte`.`endereco`
(`rua`, `numero`, `bairro`, `cidade`, `estado`)
VALUES("Rua B","15","Serra Alta","Barra do Garcas","MT");

    INSERT INTO `db_transporte`.`endereco`
(`rua`, `numero`, `bairro`, `cidade`, `estado`)
VALUES("Rua C","13","Piracema","Barra do Garcas","MT");


create table telefone (
id int(11) not null auto_increment primary key,
codigoArea varchar(3) not null,
ddd varchar(2) not null,
numero varchar(11) not null);

 INSERT INTO `db_transporte`.`telefone`
(`codigoArea`, `ddd`, `numero`)
VALUES("+55","66","98468-7744");

INSERT INTO `db_transporte`.`telefone`
(`codigoArea`, `ddd`, `numero`)
VALUES("+55","66","98877-1122");

create table cliente (
	id int(11) not null auto_increment primary key,
    nome varchar(200) not null,
    cpf varchar(50) not null unique,
    email varchar(200) not null,
    idTelefone int,
    idEndereco int,
    constraint foreign key(idEndereco) references endereco(id),
    constraint foreign key(idTelefone) references telefone(id));
    
    INSERT INTO `db_transporte`.`cliente`
(nome, cpf, email, telefone, endereco)
VALUES("Cliente Teste","123456789","clienteteste@hotmail.com",1,1);


create table motorista (
 id int(11) not null auto_increment primary key,
 nome varchar(200) not null,
 email varchar(200) not null,
 idTelefone int,
 idEndereco int,
 constraint foreign key(idEndereco) references endereco(id),
 constraint foreign key(idTelefone) references telefone(id),
 cnh varchar(20) not null,
 validadeChn date not null);
  
     INSERT INTO `db_transporte`.`motorista`
(nome, email, IdTelefone, IdEndereco, cnh, validadeChn)
VALUES("Motorista Teste","askdajdsh@hotmail.com",2,2,"254278181471","2025-03-07");

create table veiculo (
id int(11) not null auto_increment primary key,
modelo varchar(25) not null,
marca varchar(25) not null,
ano int(4) not null,
placa varchar(25) not null,
renavam varchar(30) not null,
capacidade float (30));

     INSERT INTO `db_transporte`.`veiculo`
(`modelo`, `marca`, `ano`, `placa`, `renavam`, `capacidade`)
VALUES("T-2000","Mercedez","2021","QED84WD","254278181471","200.000");

create table carga (
id int(11) not null auto_increment primary key,
peso float(5),
altura float(5),
comprimento float(5),
largura float(5),
pesoOcupado float(25),
tipoCarga varchar(25) not null);

     INSERT INTO `db_transporte`.`carga`
(`peso`, `altura`, `comprimento`, `largura`, `pesoOcupado`, `tipoCarga`)
VALUES("200","1,5","2,0","1,5","450","Não Fragil");

create table rota (
id int(11) not null auto_increment primary key,
cidadeSaida varchar(50) not null,
cidadeChegada varchar(50) not null,
distancia float (10),
cidadesParadas varchar(200) not null);

     INSERT INTO `db_transporte`.`rota`
(`cidadeSaida`, `cidadeChegada`, `distancia`, `cidadesParadas`)
VALUES("Barra do Garcas","Vila Rica","700","1,5","Agua Boa, Nova Xavantina");

create table viagem (
id int(11) not null auto_increment primary key,
horaPartida varchar (200) null,
horaChegada varchar (200) null,
dataSaida date not null,
dataChegada date not null,
IdCarga int,
IdVeiculo int,
IdMotorista int,
IdRota int,
frete float (25),
constraint foreign key(idCarga) references carga(id),
constraint foreign key(idVeiculo) references veiculo(id),
constraint foreign key(idMotorista) references motorista(id),
constraint foreign key(idRota) references rota(id));

     INSERT INTO db_transporte.viagem
(horaPartida, horaChegada, dataSaida, dataChegada, Idcarga, Idveiculo, Idmotorista, Idrota, frete)
VALUES("8","205","2021-07-20","2021-07-29", 1, 1 , 1, 1,"950");


