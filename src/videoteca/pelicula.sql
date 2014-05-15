drop database if exists Videoteca;
create database if not exists Videoteca;
use Videoteca;

drop table if exists Genero;
create table if not exists Genero (
IdGenero tinyint unsigned auto_increment primary key,
Genero varchar(20)
);

drop table if exists Director;
create table if not exists Director (
IdDirector int unsigned auto_increment primary key,
Nombre varchar(20),
Apellidos varchar(50),
Nacionalidad varchar(25),
AñoNacimiento year,
Oscar boolean
);

drop table if exists Actor;
create table if not exists Actor (
IdActor int unsigned auto_increment primary key,
Nombre varchar(40),
Apellidos varchar(50),
Nacionalidad varchar(25),
AñoNacimiento year,
Oscar boolean
);

drop table if exists Pelicula;
create table if not exists Pelicula ( 
IdPelicula int unsigned auto_increment primary key,
IdDirector int unsigned,
IdGenero tinyint unsigned,
IdActor int unsigned,
Titulo varchar(50) not null,
Productora varchar(50),
FechaEstreno date,
Nacionalidad varchar(40),
Duracion smallint unsigned,
Recaudacion bigint,
Oscars boolean,
RutaImagen varchar(70),
Valoracion int(1) check (Valoracion in(0,1,2,3,4,5)),
constraint fk_idDirector foreign key (IdDirector) references Director(IdDirector),
constraint fk_idGenero foreign key (IdGenero) references Genero(IdGenero),
constraint fk_idActor foreign key (IdActor) references Actor(IdActor)
);

insert into Genero(Genero) values
('Romance'),
('Drama'),
('Ciencia Ficción'),
('Bélico'),
('Animación'),
('Thriller'),
('Comedia'),
('Terror'),
('Biográfica'),
('Fantasía'),
('Musical'),
('Acción');

insert into Director (Nombre, Apellidos, Nacionalidad, AñoNacimiento, Oscar) values 
('James', 'Cameron', 'Canadiense',1954, true),
('Rob', 'Marshall', 'Estadounidense', 1960, false),
('Guy', 'Ritchie', 'Británica', 1968, false),
('Jeffrey Jacob', 'Abrams', 'Estadounidense', 1966, false),
('Stephen', 'Spielberg', 'Estadounidense', 1946, true),
('Martin', 'Scorsese', 'Estadounidense', 1942, true),
('Francis', 'Lawrence', 'Vienés', 1971, false), 
('Gary', 'Ross', 'Estadounidense', 1956, false),
('Christopher', 'Columbus', 'Estadounidense',  1958, false),
('Michael', 'Newell', 'Británica', 1942, false);

insert into Actor (Nombre, Apellidos, Nacionalidad, AñoNacimiento, Oscar) values 
('Kate', 'Winslet', 'Británica', 1975, true),
('Renée', 'Zellweger', 'Estadounidense', 1969, true),
('Robert John', 'Downey Jr', 'Estadounidense', 1965, false),
('Benedict', 'Cumberbatch', 'Británica', 1976, false),
('William John', 'Neeson', 'Irlandesa', 1952, false),
('Leonardo Wilhelm', 'DiCaprio', 'Estadounidense', 1974, false),
('Jennifer Shrader', 'Lawrence', 'Estadounidense', 1990, true),
('Daniel Jacob', 'Radcliffe', 'Británica', 1989, false);

insert into Pelicula(IdDirector, IdGenero, IdActor, Titulo, Productora, FechaEstreno, Nacionalidad, Duracion, Recaudacion, Oscars, RutaImagen, Valoracion) values
(1, 2, 1,'Titanic', '20th Century Fox', '1997-12-19', 'Estadounidense', 194, 2185372302, true, '/resources/Titanic.jpg',5),
(2, 11, 2, 'Chicago', 'Miramax', '2002-12-27', 'Estadounidense', 113, 306776732, true, '/resources/Chicago.jpg',5),
(3, 12, 3, 'Sherlock Holmes: Juego de sombras', 'Warner Bros.', '2011-12-14', 'Estadounidense y Británica', 129, 534848418, false, '/resources/SherlockHolmes.jpg',3),
(4, 3, 4, 'Star Trek: En la oscuridad', 'Bad Robot Productions', '2013-05-02', 'Estadounidense', 133, 497771488, false, '/resources/StarTrek.jpg',3),
(5, 4, 5, 'La lista de Schindler', 'Universal Pictures', '1993-11-30', 'Estadounidense', 195, 321306305, true, '/resources/LaListaDeSchindler.jpg',5),
(6, 7, 6, 'El lobo de Wall Street', 'Paramount Pictures', '2013-12-17', 'Estadounidense', 179, 389600000, false, '/resources/ElLoboDeWallStreet.jpg',4),
(7, 10, 7, 'Los Juegos del Hambre: En Llamas', 'Lionsgate', '2013-11-22', 'Estadounidense', 146, 861819813, false, '/resources/LosJuegosDelHambre.jpg',4), 
(8, 10, 7, 'Los Juegos del Hambre', 'Lionsgate', '2012-03-23', 'Estadounidense', 142, 686533290, false, '/resources/TheHungerGames.jpg',4),
(9, 10, 8, 'Harry Potter y la piedra filosofal', 'Heyday Films', '2001-11-04', 'Británica y Estadounidense', 160, 974733550, false, '/resources/HarryPotter1.jpg', 4),
(9, 10, 8, 'Harry Potter y la cámara secreta', 'Heyday Films', '2002-11-03', 'Británica y Estadounidense', 161, 878979634, false, '/resources/HarryPotter2.jpg', 4),
(9, 10, 8, 'Harry Potter y el prisionero de Azkaban', 'Heyday Fils', '2004-05-31', 'Británica y Estadounidense', 141, 796688549, false, '/resources/HarryPotter3.jpg', 4),
(10, 10, 8, 'Harry Potter y el cáliz de fuego', 'Heyday Films', '2005-11-18', 'Británica y Estadounidense', 155, 896911078, false, '/resources/HarryPotter4.jpg', 4);