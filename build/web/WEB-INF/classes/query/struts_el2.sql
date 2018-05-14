create database struts_el2;

use struts_el2;

create table tema(
	idTema int auto_increment primary key,
	nombre varchar(45) not null
);

create table libro(
	idLibro char(8) not null primary key,
	titulo varchar(45) not null,
	precio double not null,
	cantidad int not null,
	origen varchar(45) not null,
	idTema int,
    foreign key (idTema) references tema(idTema)
);

insert into tema values(null, "Filosofia"),
			(null, "Poesia"),
                        (null, "Arte"),
                        (null, "Novela");
                                    							

/* Listar libros */
delimiter @@
create procedure ListarLibros()
begin 
    select l.idLibro, l.titulo, l.precio, l.cantidad, l.origen, t.nombre from libro l
    inner join tema t
    on l.idTema = t.idTema
    order by l.idLibro asc;
end @@


/* Insertar libro */
delimiter @@
create procedure InsertarLibro(idLibro char(8), titulo varchar(45), precio double, cantidad int, origen varchar(45), idTema int)
begin 
    insert into libro values(idLibro, titulo, precio, cantidad, origen, idTema);
end @@

/* Buscar libro */
delimiter @@
create procedure BuscarLibro(id char(8))
begin 
    select l.idLibro, l.titulo, l.precio, l.cantidad, l.origen, t.nombre from libro l
    inner join tema t
    on l.idTema = t.idTema
    where idLibro = id;
end @@
