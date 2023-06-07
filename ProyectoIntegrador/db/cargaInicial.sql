BEGIN
    -- INSERCCION EN CLIENTE
    INSERT INTO CLIENTE VALUES('12345678A', 'Ana Busado de Hesa', 'C/si', '25', 'ana@outlook.com', '123456789');
    INSERT INTO CLIENTE VALUES('12345679B', 'Alex Cremento', 'C/caca', '250', 'alex@outlook.com', '909009090');
    INSERT INTO CLIENTE VALUES('12345610C', 'Armando Bronca Segura', 'C/por ahi', '16', 'armando@outlook.com', '645234567');
    INSERT INTO CLIENTE VALUES('12345611D', 'Elba Surero', 'AV/PIPAS TIJUAN', '80', 'elba@outlook.com', '789123456');
    INSERT INTO CLIENTE VALUES('12345612E', 'Inés Tornudo', 'C/achus', '9', 'ines@outlook.com', '111111111');
    INSERT INTO CLIENTE VALUES('12345613F', 'Josefa Nática', 'C/capital', '100', 'josefa@outlook.com', '222222222');
    INSERT INTO CLIENTE VALUES('12345614G', 'Helen Chufe', 'AV/electricidad', '25', 'helen@outlook.com', '333333333');
    INSERT INTO CLIENTE VALUES('12345615H', 'Matías Queroso', 'C/asco', '25', 'matias@outlook.com', '123456789');

    -- INSERCCION EN EMPLEADO 
    INSERT INTO EMPLEADO VALUES('ADMINISTRADOR', 'ADMIN', 'C/ADMIN', 'admin', 'Administrador', 'admin@empresa.com', '111122221');
    INSERT INTO EMPLEADO VALUES('87654321A', 'Juanjo Sefina', 'AV/alguacil', '123', 'Administrativo', 'juanjo@gmail.com', '333333334');
    INSERT INTO EMPLEADO VALUES('87654321B', 'Elton Tito', 'AV/asiSi', 'eltonTito', 'Monitor', 'elton@gmail.com', '999999999');
    INSERT INTO EMPLEADO VALUES('87654321C', 'Ema Amado Bustos', 'C/CACA', 'monitorUwU', 'Monitor', 'ema@gmail.com', '909000909');

    -- INSERCCION EN INSTALACION
    INSERT INTO INSTALACION VALUES(1, 'Campo');
    INSERT INTO INSTALACION VALUES(2, 'Pista');
    INSERT INTO INSTALACION VALUES(3, 'Gimnasio');
    INSERT INTO INSTALACION VALUES(4, 'Campo');
    INSERT INTO INSTALACION VALUES(5, 'Piscina');
    INSERT INTO INSTALACION VALUES(6, 'Campo');
    INSERT INTO INSTALACION VALUES(7, 'Pista');
    INSERT INTO INSTALACION VALUES(8, 'Pista');
    INSERT INTO INSTALACION VALUES(9, 'Piscina');
    INSERT INTO INSTALACION VALUES(10, 'Campo');
    INSERT INTO INSTALACION VALUES(11, 'Piscina');
    INSERT INTO INSTALACION VALUES(12, 'Gimnasio');
    INSERT INTO INSTALACION VALUES(13, 'Campo');
    INSERT INTO INSTALACION VALUES(14, 'Piscina');

    -- INSERCCION EN CLASE
    INSERT INTO CLASE VALUES('LUNES', '13:00', '87654321B', 2);
    INSERT INTO CLASE VALUES('MARTES', '13:00', '87654321B', 3);
    INSERT INTO CLASE VALUES('JUEVES', '09:00', '87654321C', 14);
    INSERT INTO CLASE VALUES('VIERNES', '19:00', '87654321C', 7);

    -- INSERCCION EN CLIENTE-INSTALACION
    INSERT INTO CLIENTE_INSTALACION VALUES(17, '08/06/2023', '10:00', 'Sí', '12345678A', 4);
    INSERT INTO CLIENTE_INSTALACION VALUES(20, '10/06/2023', '09:00', 'Sí', '12345679B', 2);
    INSERT INTO CLIENTE_INSTALACION VALUES(10, '07/06/2023', '13:00', 'No', '12345678A', 10);
    INSERT INTO CLIENTE_INSTALACION VALUES(5, '09/06/2023', '12:00', 'Sí', '12345678A', 4);
    INSERT INTO CLIENTE_INSTALACION VALUES(3, '11/06/2023', '14:00', 'Sí', '12345679B', 1);

    -- INSERCCION EN DEPORTE
    INSERT INTO DEPORTE VALUES(1, 'Fútbol');
    INSERT INTO DEPORTE VALUES(2, 'Baloncesto');
    INSERT INTO DEPORTE VALUES(3, 'Tenis');
    INSERT INTO DEPORTE VALUES(4, 'Pádel');
    INSERT INTO DEPORTE VALUES(5, 'Volibol');
    INSERT INTO DEPORTE VALUES(6, 'Piscina');
    INSERT INTO DEPORTE VALUES(7, 'Atletismo');

    -- INSERCCION INSTALACION-DEPORTES
    INSERT INTO INSTALACION_DEPORTE VALUES(1, 1);
    INSERT INTO INSTALACION_DEPORTE VALUES(2, 2);
    INSERT INTO INSTALACION_DEPORTE VALUES(3, 2);
    INSERT INTO INSTALACION_DEPORTE VALUES(4, 2);
    INSERT INTO INSTALACION_DEPORTE VALUES(5, 1);
    INSERT INTO INSTALACION_DEPORTE VALUES(6, 9);
    INSERT INTO INSTALACION_DEPORTE VALUES(7, 2);
END;