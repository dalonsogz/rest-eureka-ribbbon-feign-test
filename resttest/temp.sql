SELECT * FROM software.juegos;

SELECT * FROM software.juegos order by fecha desc;

#INSERT INTO `juegos` () 
INSERT INTO `juegos` (nombre,num_cds,clase,genero,subgenero,localizacion,valoracion,comentario,fecha,borrable,tamano_instalable,tamano_instalado) 
VALUES ('1000 Motorola Java Phone Games', 0, 'Varios', NULL, 'Móbiles', 'DVD Games 84', 0, NULL, '2008-03-21 00:00:00', 0, NULL, NULL);

delete from juegos;
