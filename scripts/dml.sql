INSERT INTO ESPECIALIZACION (DESCRIPCION)
VALUES
    ('Medicina General'),
    ('Pediatría'),
    ('Cardiología'),
    ('Ginecología');

INSERT INTO HORARIO (HORA_INICIO)
VALUES
    ('08:00:00'),
    ('08:20:00'),
    ('08:40:00'),
    ('09:00:00'),
    ('09:20:00'),
    ('09:40:00'),
    ('10:00:00'),
    ('10:20:00'),
    ('10:40:00'),
    ('11:00:00'),
    ('11:20:00'),
    ('11:40:00'),
    ('12:00:00'),
    ('12:20:00'),
    ('12:40:00'),
    ('13:00:00'),
    ('13:20:00'),
    ('13:40:00'),
    ('14:00:00'),
    ('14:20:00'),
    ('14:40:00'),
    ('15:00:00'),
    ('15:20:00'),
    ('15:40:00'),
    ('16:00:00'),
    ('16:20:00'),
    ('16:40:00');

INSERT INTO FECHA (FECHA)
VALUES
    ('2025-11-24'),
    ('2025-11-25'),
    ('2025-11-26'),
    ('2025-11-27'),
    ('2025-11-28');

INSERT INTO PACIENTE
(CEDULA, PASSWORD, NOMBRE, APELLIDO, SEXO, FECHA_NACIMIENTO, DIRECCION, NACIONALIDAD, TELEFONO, CORREO, AFILIACION)
VALUES
('0102030405','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','Juan', 'García', 'MASCULINO', '1990-05-12', 'Av. América y Mariana de Jesús', 'Ecuatoriana', '0987654321', 'juan.garcia@example.com', 'SEGURO GENERAL'),

('1102233445','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','María', 'Pérez', 'FEMENINO', '1985-08-20', 'Calle Larga y Benigno Malo', 'Ecuatoriana', '0950011223', 'maria.perez@example.com', 'SEGURO GENERAL'),

('0923445566','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','Carlos', 'Ramírez', 'MASCULINO', '1998-12-02', 'Cdla. Kennedy Norte', 'Ecuatoriana', '0998844221', 'carlos.ramirez@example.com', 'SEGURO VOLUNTARIO'),

('1723345567','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4','Diana', 'Ortiz', 'FEMENINO', '2001-01-18', 'El Inca, Sector 3', 'Ecuatoriana', '0981122334', 'diana.ortiz@example.com', 'SEGURO CAMPESINO'),

('1309988776','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Luis', 'Mendoza', 'MASCULINO', '1979-03-29', 'Portete y Bolivia', 'Ecuatoriana', '0945566778', 'luis.mendoza@example.com', 'SEGURO GENERAL'),

('0956677889','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Andrea', 'Salinas', 'FEMENINO', '1995-10-10', 'La Aurora, Daule', 'Ecuatoriana', '0980099123', 'andrea.salinas@example.com', 'SEGURO VOLUNTARIO'),

('1401122334','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'José', 'Cedeño', 'MASCULINO', '1988-06-14', 'Av. Libertad, junto al parque', 'Ecuatoriana', '0983214567', 'jose.cedeno@example.com', 'SEGURO CAMPESINO'),

('0609988773','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Paola', 'Reyes', 'FEMENINO', '1993-02-25', 'El Valle, Cuenca', 'Ecuatoriana', '0954433221', 'paola.reyes@example.com', 'SEGURO GENERAL'),

('1711122233','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Ricardo', 'Ramón', 'MASCULINO', '2000-07-11', 'Carcelén Alto', 'Ecuatoriana', '0992211345', 'ricardo.ramon@example.com', 'SEGURO VOLUNTARIO'),

('0911223344','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Sofía', 'Mora', 'FEMENINO', '1997-11-05', 'Samborondón, Ciudad Celeste', 'Ecuatoriana', '0965544332', 'sofia.mora@example.com', 'SEGURO CAMPESINO');

INSERT INTO MEDICO
(CEDULA, PASSWORD, ID_ESPECIALIZACION, NOMBRE, APELLIDO, SEXO, FECHA_NACIMIENTO, JORNADA_INICIO, JORNADA_FIN)
VALUES
    ('0912345678',
     '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',
     1, 'Carlos', 'Ramírez', 'M', '1975-06-10', '08:00:00', '16:00:00'),

    ('0923456789',
     '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',
     3, 'Ana', 'Torres', 'F', '1980-12-05', '09:00:00', '15:00:00');

INSERT INTO OPERADOR
(CEDULA, PASSWORD, NOMBRE, APELLIDO, TELEFONO, CORREO)
VALUES
    ('0934567890',
     '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',
     'Luis', 'Suárez', '0977777777', 'luis.suarez@mail.com');