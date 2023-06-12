INSERT INTO `usuario` (`username`, `password`, `email`, `tipo`, `admitido`) VALUES ('admin', 'admin', 'administrador@gmail.com', 'ad', 'S'), ('conductorl1', 'conductorL1$$', 'conductorl1@gmail.com', 'c', 'S'), ('daguergom', 'daguergom$$', 'daguergom@gmail.com', 'al', 'S');


INSERT INTO `autobus` (`id`, `capacidad`, `nombre`) VALUES (20, 40, 'Autobús Los Prados'), (21, 55, 'Autobús El Arenal'), (22, 60, 'Autobús Santa Ana'), (23, 45, 'Autobús Montequinto'), (24, 35, 'Autobús Las Torres'), (25, 50, 'Autobús La Motilla'), (26, 40, 'Autobús Ciudad del Sol'), (27, 55, 'Autobús Montecarmelo'), (28, 60, 'Autobús Fuente del Rey');

INSERT INTO `parada` (`id`, `nombre`) VALUES (37, 'Parada Avenida de España'), (38, 'Parada Calle La Mina'), (39, 'Parada Plaza de Abastos'), (40, 'Parada Parque Municipal'), (41, 'Parada Calle Ancha'), (42, 'Parada Plaza de la Constitución'), (43, 'Parada Polígono Industrial'), (44, 'Parada Calle Real'), (45, 'Parada Plaza del Arenal'), (46, 'Parada Calle Sevilla');

INSERT INTO `ruta` (`id`, `nombre`, `hora_salida`, `hora_llegada`) VALUES (24, 'Ruta de la Avenida de España', '08:00', '09:00'), (25, 'Ruta de la Calle La Mina', '09:30', '10:30'), (26, 'Ruta de la Plaza de Abastos', '11:00', '12:00'), (27, 'Ruta del Parque Municipal', '12:30', '13:30'), (28, 'Ruta de la Calle Ancha', '14:00', '15:00'), (29, 'Ruta de la Plaza de la Constitución', '15:30', '16:30'),(30, 'Ruta del Polígono Industrial', '17:00', '18:00'),(31, 'Ruta de la Calle Real', '18:30', '19:30'),(32, 'Ruta de la Plaza del Arenal', '20:00', '21:00'),(33, 'Ruta de la Calle Sevilla', '21:30', '22:30');

INSERT INTO `ruta_autobus` (`id_ruta`, `id_autobus`) VALUES (24, 23),(25, 27),(26, 27),(26, 28),(27, 28),(28, 20),(28, 22),(29, 20),(30, 21),(30, 25),(31, 24),(31, 26),(32, 22),(33, 23),(33, 26);

INSERT INTO `ruta_parada` (`id_ruta`, `id_parada`) VALUES (24, 39),(24, 43),(24, 45),(25, 39),(25, 45),(26, 37),(26, 38),(26, 39),(26, 40),(27, 39),(27, 43),(27, 45),(28, 37),(28, 38),(28, 39),(28, 40),(28, 41),(28, 42),(28, 43),(28, 44),(28, 45),(29, 38),(29, 44),(29, 46),(30, 39),(30, 40),(30, 41),(30, 42),(30, 43),(30, 44),(30, 45),(31, 37),(31, 45),(31, 46),(32, 38),(32, 43),(32, 44),(33, 38),(33, 43),(33, 45);
