-- Deshabilitar restricciones de claves foráneas temporalmente
SET FOREIGN_KEY_CHECKS = 0;

-- Truncar las tablas en orden inverso a su creación (para evitar problemas con claves foráneas)
TRUNCATE TABLE TRATAMIENTO;
TRUNCATE TABLE DIAGNOSTICO;
TRUNCATE TABLE TURNO;
TRUNCATE TABLE CITA;
TRUNCATE TABLE MEDICO;
TRUNCATE TABLE PACIENTE;
TRUNCATE TABLE OPERADOR;
TRUNCATE TABLE ESPECIALIZACION;
TRUNCATE TABLE MEDICAMENTO;
TRUNCATE TABLE FECHA;
TRUNCATE TABLE HORARIO;

-- Volver a habilitar restricciones de claves foráneas
SET FOREIGN_KEY_CHECKS = 1;

-- Reiniciar los auto_increment
ALTER TABLE TRATAMIENTO AUTO_INCREMENT = 1;
ALTER TABLE DIAGNOSTICO AUTO_INCREMENT = 1;
ALTER TABLE TURNO AUTO_INCREMENT = 1;
ALTER TABLE CITA AUTO_INCREMENT = 1;
ALTER TABLE MEDICO AUTO_INCREMENT = 1;
ALTER TABLE PACIENTE AUTO_INCREMENT = 1;
ALTER TABLE OPERADOR AUTO_INCREMENT = 1;
ALTER TABLE ESPECIALIZACION AUTO_INCREMENT = 1;
ALTER TABLE MEDICAMENTO AUTO_INCREMENT = 1;
ALTER TABLE FECHA AUTO_INCREMENT = 1;
ALTER TABLE HORARIO AUTO_INCREMENT = 1;

-- =============================================================================
-- DATOS MAESTROS
-- =============================================================================

-- ESPECIALIZACIONES (sin duplicados)
INSERT INTO ESPECIALIZACION (DESCRIPCION) VALUES
                                              ('Medicina General'),
                                              ('Pediatría'),
                                              ('Cardiología'),
                                              ('Ginecología'),
                                              ('Dermatología'),
                                              ('Neurología'),
                                              ('Ortopedia'),
                                              ('Oftalmología'),
                                              ('Gastroenterología'),
                                              ('Endocrinología'),
                                              ('Psiquiatría'),
                                              ('Oncología'),
                                              ('Urología'),
                                              ('Neumología');

-- HORARIOS (ordenados lógicamente)
INSERT INTO HORARIO (HORA_INICIO) VALUES
                                      ('08:00:00'), ('08:20:00'), ('08:40:00'),
                                      ('09:00:00'), ('09:20:00'), ('09:40:00'),
                                      ('10:00:00'), ('10:20:00'), ('10:40:00'),
                                      ('11:00:00'), ('11:20:00'), ('11:40:00'),
                                      ('12:00:00'), ('12:20:00'), ('12:40:00'),
                                      ('13:00:00'), ('13:20:00'), ('13:40:00'),
                                      ('14:00:00'), ('14:20:00'), ('14:40:00'),
                                      ('15:00:00'), ('15:20:00'), ('15:40:00'),
                                      ('16:00:00'), ('16:20:00'), ('16:40:00');

-- FECHAS (2 semanas laborales consecutivas)
INSERT INTO FECHA (FECHA) VALUES
-- Semana 1
('2025-11-17'), ('2025-11-18'), ('2025-11-19'), ('2025-11-20'), ('2025-11-21'),
-- Semana 2
('2025-11-24'), ('2025-11-25'), ('2025-11-26'), ('2025-11-27'), ('2025-11-28');

-- MEDICAMENTOS (organizados por categorías)
INSERT INTO MEDICAMENTO (DESCRIPCION, PRINCIPIO_ACTIVO) VALUES
-- Analgésicos/Antiinflamatorios
('Paracetamol 500mg', 'Paracetamol'),
('Ibuprofeno 400mg', 'Ibuprofeno'),
('Aspirina 100mg', 'Ácido acetilsalicílico'),
('Naproxeno 250mg', 'Naproxeno'),

-- Antibióticos
('Amoxicilina 500mg', 'Amoxicilina'),
('Azitromicina 250mg', 'Azitromicina'),
('Cefalexina 500mg', 'Cefalexina'),
('Metronidazol 500mg', 'Metronidazol'),

-- Antihistamínicos
('Loratadina 10mg', 'Loratadina'),
('Cetirizina 10mg', 'Cetirizina'),
('Fexofenadina 120mg', 'Fexofenadina'),

-- Gastrointestinales
('Omeprazol 20mg', 'Omeprazol'),
('Lansoprazol 30mg', 'Lansoprazol'),
('Domperidona 10mg', 'Domperidona'),

-- Cardiovasculares
('Atorvastatina 20mg', 'Atorvastatina'),
('Losartán 50mg', 'Losartán'),
('Amlodipino 5mg', 'Amlodipino'),
('Hidroclorotiazida 25mg', 'Hidroclorotiazida'),

-- Respiratorios
('Salbutamol Inhalador', 'Salbutamol'),
('Ambroxol 30mg', 'Ambroxol'),
('Montelukast 10mg', 'Montelukast'),

-- Endocrinos
('Metformina 850mg', 'Metformina'),
('Insulina NPH', 'Insulina humana'),
('Levotiroxina 50mcg', 'Levotiroxina sódica'),

-- Neurológicos/Psiquiátricos
('Diazepam 5mg', 'Diazepam'),
('Clonazepam 2mg', 'Clonazepam'),
('Sertralina 50mg', 'Sertralina'),

-- Otros
('Prednisona 5mg', 'Prednisona'),
('Warfarina 5mg', 'Warfarina');

-- =============================================================================
-- USUARIOS DEL SISTEMA
-- =============================================================================

-- PACIENTES (datos realistas y coherentes)
INSERT INTO PACIENTE (CEDULA, PASSWORD, NOMBRE, APELLIDO, SEXO, FECHA_NACIMIENTO, DIRECCION, NACIONALIDAD, TELEFONO, CORREO, AFILIACION) VALUES
                                                                                                                                             ('0102030405', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Juan', 'García', 'MASCULINO', '1990-05-12', 'Av. América y Mariana de Jesús', 'Ecuatoriana', '0987654321', 'juan.garcia@example.com', 'SEGURO GENERAL'),
                                                                                                                                             ('1102233445', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'María', 'Pérez', 'FEMENINO', '1985-08-20', 'Calle Larga y Benigno Malo', 'Ecuatoriana', '0950011223', 'maria.perez@example.com', 'SEGURO GENERAL'),
                                                                                                                                             ('0923445566', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Carlos', 'Ramírez', 'MASCULINO', '1998-12-02', 'Cdla. Kennedy Norte', 'Ecuatoriana', '0998844221', 'carlos.ramirez@example.com', 'SEGURO VOLUNTARIO'),
                                                                                                                                             ('1723345567', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Diana', 'Ortiz', 'FEMENINO', '2001-01-18', 'El Inca, Sector 3', 'Ecuatoriana', '0981122334', 'diana.ortiz@example.com', 'SEGURO CAMPESINO'),
                                                                                                                                             ('1309988776', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Luis', 'Mendoza', 'MASCULINO', '1979-03-29', 'Portete y Bolivia', 'Ecuatoriana', '0945566778', 'luis.mendoza@example.com', 'SEGURO GENERAL'),
                                                                                                                                             ('0956677889', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Andrea', 'Salinas', 'FEMENINO', '1995-10-10', 'La Aurora, Daule', 'Ecuatoriana', '0980099123', 'andrea.salinas@example.com', 'SEGURO VOLUNTARIO'),
                                                                                                                                             ('1401122334', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'José', 'Cedeño', 'MASCULINO', '1988-06-14', 'Av. Libertad, junto al parque', 'Ecuatoriana', '0983214567', 'jose.cedeno@example.com', 'SEGURO CAMPESINO'),
                                                                                                                                             ('0609988773', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Paola', 'Reyes', 'FEMENINO', '1993-02-25', 'El Valle, Cuenca', 'Ecuatoriana', '0954433221', 'paola.reyes@example.com', 'SEGURO GENERAL'),
                                                                                                                                             ('1711122233', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Ricardo', 'Ramón', 'MASCULINO', '2000-07-11', 'Carcelén Alto', 'Ecuatoriana', '0992211345', 'ricardo.ramon@example.com', 'SEGURO VOLUNTARIO'),
                                                                                                                                             ('0911223344', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Sofía', 'Mora', 'FEMENINO', '1997-11-05', 'Samborondón, Ciudad Celeste', 'Ecuatoriana', '0965544332', 'sofia.mora@example.com', 'SEGURO CAMPESINO');

-- MÉDICOS (especialidades distribuidas lógicamente)
INSERT INTO MEDICO (CEDULA, PASSWORD, ID_ESPECIALIZACION, NOMBRE, APELLIDO, SEXO, FECHA_NACIMIENTO, JORNADA_INICIO, JORNADA_FIN) VALUES
-- Medicina General
('0912345678', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 1, 'Carlos', 'Ramírez', 'MASCULINO', '1975-06-10', '08:00:00', '16:00:00'),
('1023456789', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 1, 'Javier', 'Ortega', 'MASCULINO', '1986-05-05', '09:00:00', '17:00:00'),

-- Pediatría
('0934567890', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 2, 'Laura', 'Mendoza', 'FEMENINO', '1982-03-15', '08:00:00', '16:00:00'),

-- Cardiología
('0923456789', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 3, 'Ana', 'Torres', 'FEMENINO', '1980-12-05', '09:00:00', '15:00:00'),
('0945678901', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 3, 'Roberto', 'Silva', 'MASCULINO', '1978-11-20', '09:00:00', '17:00:00'),

-- Ginecología
('0956789012', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 4, 'Elena', 'Vargas', 'FEMENINO', '1985-07-08', '08:00:00', '14:00:00'),

-- Dermatología
('0967890123', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 5, 'Miguel', 'Castro', 'MASCULINO', '1979-09-12', '10:00:00', '18:00:00'),

-- Neurología
('0978901234', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 6, 'Patricia', 'Rojas', 'FEMENINO', '1983-04-25', '08:00:00', '16:00:00'),

-- Ortopedia
('0989012345', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 7, 'Fernando', 'López', 'MASCULINO', '1980-12-30', '09:00:00', '15:00:00'),

-- Oftalmología
('0990123456', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 8, 'Gabriela', 'Morales', 'FEMENINO', '1977-06-18', '08:00:00', '14:00:00'),

-- Gastroenterología
('1001234567', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 9, 'Diego', 'Herrera', 'MASCULINO', '1981-02-14', '10:00:00', '16:00:00'),

-- Endocrinología
('1012345678', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 10, 'Carolina', 'Paz', 'FEMENINO', '1984-08-22', '08:00:00', '16:00:00');

-- OPERADORES
INSERT INTO OPERADOR (CEDULA, PASSWORD, NOMBRE, APELLIDO, TELEFONO, CORREO) VALUES
                                                                                ('0934567890', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Luis', 'Suárez', '0977777777', 'luis.suarez@mail.com'),
                                                                                ('0945678901', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'María', 'González', '0988888888', 'maria.gonzalez@mail.com');

-- =============================================================================
-- TURNOS (distribución lógica por médico y fecha)
-- =============================================================================

-- =============================================================================
-- TURNOS COMPLETOS PARA TODOS LOS MÉDICOS DURANTE SU JORNADA LABORAL
-- =============================================================================

-- Función auxiliar para generar turnos completos según jornada de cada médico
INSERT INTO TURNO (ID_FECHA, ID_HORARIO, ID_MEDICO) VALUES
-- MÉDICO 1 (Carlos Ramírez - Medicina General) - Jornada: 08:00-16:00 (20 turnos por día)
-- Semana 1
(1, 1, 1), (1, 2, 1), (1, 3, 1), (1, 4, 1), (1, 5, 1), (1, 6, 1), (1, 7, 1), (1, 8, 1), (1, 9, 1), (1, 10, 1), (1, 11, 1), (1, 12, 1), (1, 13, 1), (1, 14, 1), (1, 15, 1), (1, 16, 1), (1, 17, 1), (1, 18, 1), (1, 19, 1), (1, 20, 1),
(2, 1, 1), (2, 2, 1), (2, 3, 1), (2, 4, 1), (2, 5, 1), (2, 6, 1), (2, 7, 1), (2, 8, 1), (2, 9, 1), (2, 10, 1), (2, 11, 1), (2, 12, 1), (2, 13, 1), (2, 14, 1), (2, 15, 1), (2, 16, 1), (2, 17, 1), (2, 18, 1), (2, 19, 1), (2, 20, 1),
(3, 1, 1), (3, 2, 1), (3, 3, 1), (3, 4, 1), (3, 5, 1), (3, 6, 1), (3, 7, 1), (3, 8, 1), (3, 9, 1), (3, 10, 1), (3, 11, 1), (3, 12, 1), (3, 13, 1), (3, 14, 1), (3, 15, 1), (3, 16, 1), (3, 17, 1), (3, 18, 1), (3, 19, 1), (3, 20, 1),
(4, 1, 1), (4, 2, 1), (4, 3, 1), (4, 4, 1), (4, 5, 1), (4, 6, 1), (4, 7, 1), (4, 8, 1), (4, 9, 1), (4, 10, 1), (4, 11, 1), (4, 12, 1), (4, 13, 1), (4, 14, 1), (4, 15, 1), (4, 16, 1), (4, 17, 1), (4, 18, 1), (4, 19, 1), (4, 20, 1),
(5, 1, 1), (5, 2, 1), (5, 3, 1), (5, 4, 1), (5, 5, 1), (5, 6, 1), (5, 7, 1), (5, 8, 1), (5, 9, 1), (5, 10, 1), (5, 11, 1), (5, 12, 1), (5, 13, 1), (5, 14, 1), (5, 15, 1), (5, 16, 1), (5, 17, 1), (5, 18, 1), (5, 19, 1), (5, 20, 1),
-- Semana 2
(6, 1, 1), (6, 2, 1), (6, 3, 1), (6, 4, 1), (6, 5, 1), (6, 6, 1), (6, 7, 1), (6, 8, 1), (6, 9, 1), (6, 10, 1), (6, 11, 1), (6, 12, 1), (6, 13, 1), (6, 14, 1), (6, 15, 1), (6, 16, 1), (6, 17, 1), (6, 18, 1), (6, 19, 1), (6, 20, 1),
(7, 1, 1), (7, 2, 1), (7, 3, 1), (7, 4, 1), (7, 5, 1), (7, 6, 1), (7, 7, 1), (7, 8, 1), (7, 9, 1), (7, 10, 1), (7, 11, 1), (7, 12, 1), (7, 13, 1), (7, 14, 1), (7, 15, 1), (7, 16, 1), (7, 17, 1), (7, 18, 1), (7, 19, 1), (7, 20, 1),
(8, 1, 1), (8, 2, 1), (8, 3, 1), (8, 4, 1), (8, 5, 1), (8, 6, 1), (8, 7, 1), (8, 8, 1), (8, 9, 1), (8, 10, 1), (8, 11, 1), (8, 12, 1), (8, 13, 1), (8, 14, 1), (8, 15, 1), (8, 16, 1), (8, 17, 1), (8, 18, 1), (8, 19, 1), (8, 20, 1),
(9, 1, 1), (9, 2, 1), (9, 3, 1), (9, 4, 1), (9, 5, 1), (9, 6, 1), (9, 7, 1), (9, 8, 1), (9, 9, 1), (9, 10, 1), (9, 11, 1), (9, 12, 1), (9, 13, 1), (9, 14, 1), (9, 15, 1), (9, 16, 1), (9, 17, 1), (9, 18, 1), (9, 19, 1), (9, 20, 1),
(10, 1, 1), (10, 2, 1), (10, 3, 1), (10, 4, 1), (10, 5, 1), (10, 6, 1), (10, 7, 1), (10, 8, 1), (10, 9, 1), (10, 10, 1), (10, 11, 1), (10, 12, 1), (10, 13, 1), (10, 14, 1), (10, 15, 1), (10, 16, 1), (10, 17, 1), (10, 18, 1), (10, 19, 1), (10, 20, 1),

-- MÉDICO 2 (Javier Ortega - Medicina General) - Jornada: 09:00-17:00 (20 turnos por día)
-- Semana 1
(1, 4, 2), (1, 5, 2), (1, 6, 2), (1, 7, 2), (1, 8, 2), (1, 9, 2), (1, 10, 2), (1, 11, 2), (1, 12, 2), (1, 13, 2), (1, 14, 2), (1, 15, 2), (1, 16, 2), (1, 17, 2), (1, 18, 2), (1, 19, 2), (1, 20, 2), (1, 21, 2), (1, 22, 2), (1, 23, 2),
(2, 4, 2), (2, 5, 2), (2, 6, 2), (2, 7, 2), (2, 8, 2), (2, 9, 2), (2, 10, 2), (2, 11, 2), (2, 12, 2), (2, 13, 2), (2, 14, 2), (2, 15, 2), (2, 16, 2), (2, 17, 2), (2, 18, 2), (2, 19, 2), (2, 20, 2), (2, 21, 2), (2, 22, 2), (2, 23, 2),
(3, 4, 2), (3, 5, 2), (3, 6, 2), (3, 7, 2), (3, 8, 2), (3, 9, 2), (3, 10, 2), (3, 11, 2), (3, 12, 2), (3, 13, 2), (3, 14, 2), (3, 15, 2), (3, 16, 2), (3, 17, 2), (3, 18, 2), (3, 19, 2), (3, 20, 2), (3, 21, 2), (3, 22, 2), (3, 23, 2),
(4, 4, 2), (4, 5, 2), (4, 6, 2), (4, 7, 2), (4, 8, 2), (4, 9, 2), (4, 10, 2), (4, 11, 2), (4, 12, 2), (4, 13, 2), (4, 14, 2), (4, 15, 2), (4, 16, 2), (4, 17, 2), (4, 18, 2), (4, 19, 2), (4, 20, 2), (4, 21, 2), (4, 22, 2), (4, 23, 2),
(5, 4, 2), (5, 5, 2), (5, 6, 2), (5, 7, 2), (5, 8, 2), (5, 9, 2), (5, 10, 2), (5, 11, 2), (5, 12, 2), (5, 13, 2), (5, 14, 2), (5, 15, 2), (5, 16, 2), (5, 17, 2), (5, 18, 2), (5, 19, 2), (5, 20, 2), (5, 21, 2), (5, 22, 2), (5, 23, 2),
-- Semana 2
(6, 4, 2), (6, 5, 2), (6, 6, 2), (6, 7, 2), (6, 8, 2), (6, 9, 2), (6, 10, 2), (6, 11, 2), (6, 12, 2), (6, 13, 2), (6, 14, 2), (6, 15, 2), (6, 16, 2), (6, 17, 2), (6, 18, 2), (6, 19, 2), (6, 20, 2), (6, 21, 2), (6, 22, 2), (6, 23, 2),
(7, 4, 2), (7, 5, 2), (7, 6, 2), (7, 7, 2), (7, 8, 2), (7, 9, 2), (7, 10, 2), (7, 11, 2), (7, 12, 2), (7, 13, 2), (7, 14, 2), (7, 15, 2), (7, 16, 2), (7, 17, 2), (7, 18, 2), (7, 19, 2), (7, 20, 2), (7, 21, 2), (7, 22, 2), (7, 23, 2),
(8, 4, 2), (8, 5, 2), (8, 6, 2), (8, 7, 2), (8, 8, 2), (8, 9, 2), (8, 10, 2), (8, 11, 2), (8, 12, 2), (8, 13, 2), (8, 14, 2), (8, 15, 2), (8, 16, 2), (8, 17, 2), (8, 18, 2), (8, 19, 2), (8, 20, 2), (8, 21, 2), (8, 22, 2), (8, 23, 2),
(9, 4, 2), (9, 5, 2), (9, 6, 2), (9, 7, 2), (9, 8, 2), (9, 9, 2), (9, 10, 2), (9, 11, 2), (9, 12, 2), (9, 13, 2), (9, 14, 2), (9, 15, 2), (9, 16, 2), (9, 17, 2), (9, 18, 2), (9, 19, 2), (9, 20, 2), (9, 21, 2), (9, 22, 2), (9, 23, 2),
(10, 4, 2), (10, 5, 2), (10, 6, 2), (10, 7, 2), (10, 8, 2), (10, 9, 2), (10, 10, 2), (10, 11, 2), (10, 12, 2), (10, 13, 2), (10, 14, 2), (10, 15, 2), (10, 16, 2), (10, 17, 2), (10, 18, 2), (10, 19, 2), (10, 20, 2), (10, 21, 2), (10, 22, 2), (10, 23, 2),

-- MÉDICO 3 (Laura Mendoza - Pediatría) - Jornada: 08:00-16:00 (20 turnos por día)
-- Semana 1
(1, 1, 3), (1, 2, 3), (1, 3, 3), (1, 4, 3), (1, 5, 3), (1, 6, 3), (1, 7, 3), (1, 8, 3), (1, 9, 3), (1, 10, 3), (1, 11, 3), (1, 12, 3), (1, 13, 3), (1, 14, 3), (1, 15, 3), (1, 16, 3), (1, 17, 3), (1, 18, 3), (1, 19, 3), (1, 20, 3),
(2, 1, 3), (2, 2, 3), (2, 3, 3), (2, 4, 3), (2, 5, 3), (2, 6, 3), (2, 7, 3), (2, 8, 3), (2, 9, 3), (2, 10, 3), (2, 11, 3), (2, 12, 3), (2, 13, 3), (2, 14, 3), (2, 15, 3), (2, 16, 3), (2, 17, 3), (2, 18, 3), (2, 19, 3), (2, 20, 3),
(3, 1, 3), (3, 2, 3), (3, 3, 3), (3, 4, 3), (3, 5, 3), (3, 6, 3), (3, 7, 3), (3, 8, 3), (3, 9, 3), (3, 10, 3), (3, 11, 3), (3, 12, 3), (3, 13, 3), (3, 14, 3), (3, 15, 3), (3, 16, 3), (3, 17, 3), (3, 18, 3), (3, 19, 3), (3, 20, 3),
(4, 1, 3), (4, 2, 3), (4, 3, 3), (4, 4, 3), (4, 5, 3), (4, 6, 3), (4, 7, 3), (4, 8, 3), (4, 9, 3), (4, 10, 3), (4, 11, 3), (4, 12, 3), (4, 13, 3), (4, 14, 3), (4, 15, 3), (4, 16, 3), (4, 17, 3), (4, 18, 3), (4, 19, 3), (4, 20, 3),
(5, 1, 3), (5, 2, 3), (5, 3, 3), (5, 4, 3), (5, 5, 3), (5, 6, 3), (5, 7, 3), (5, 8, 3), (5, 9, 3), (5, 10, 3), (5, 11, 3), (5, 12, 3), (5, 13, 3), (5, 14, 3), (5, 15, 3), (5, 16, 3), (5, 17, 3), (5, 18, 3), (5, 19, 3), (5, 20, 3),
-- Semana 2
(6, 1, 3), (6, 2, 3), (6, 3, 3), (6, 4, 3), (6, 5, 3), (6, 6, 3), (6, 7, 3), (6, 8, 3), (6, 9, 3), (6, 10, 3), (6, 11, 3), (6, 12, 3), (6, 13, 3), (6, 14, 3), (6, 15, 3), (6, 16, 3), (6, 17, 3), (6, 18, 3), (6, 19, 3), (6, 20, 3),
(7, 1, 3), (7, 2, 3), (7, 3, 3), (7, 4, 3), (7, 5, 3), (7, 6, 3), (7, 7, 3), (7, 8, 3), (7, 9, 3), (7, 10, 3), (7, 11, 3), (7, 12, 3), (7, 13, 3), (7, 14, 3), (7, 15, 3), (7, 16, 3), (7, 17, 3), (7, 18, 3), (7, 19, 3), (7, 20, 3),
(8, 1, 3), (8, 2, 3), (8, 3, 3), (8, 4, 3), (8, 5, 3), (8, 6, 3), (8, 7, 3), (8, 8, 3), (8, 9, 3), (8, 10, 3), (8, 11, 3), (8, 12, 3), (8, 13, 3), (8, 14, 3), (8, 15, 3), (8, 16, 3), (8, 17, 3), (8, 18, 3), (8, 19, 3), (8, 20, 3),
(9, 1, 3), (9, 2, 3), (9, 3, 3), (9, 4, 3), (9, 5, 3), (9, 6, 3), (9, 7, 3), (9, 8, 3), (9, 9, 3), (9, 10, 3), (9, 11, 3), (9, 12, 3), (9, 13, 3), (9, 14, 3), (9, 15, 3), (9, 16, 3), (9, 17, 3), (9, 18, 3), (9, 19, 3), (9, 20, 3),
(10, 1, 3), (10, 2, 3), (10, 3, 3), (10, 4, 3), (10, 5, 3), (10, 6, 3), (10, 7, 3), (10, 8, 3), (10, 9, 3), (10, 10, 3), (10, 11, 3), (10, 12, 3), (10, 13, 3), (10, 14, 3), (10, 15, 3), (10, 16, 3), (10, 17, 3), (10, 18, 3), (10, 19, 3), (10, 20, 3),

-- MÉDICO 4 (Ana Torres - Cardiología) - Jornada: 09:00-15:00 (15 turnos por día)
-- Semana 1
(1, 4, 4), (1, 5, 4), (1, 6, 4), (1, 7, 4), (1, 8, 4), (1, 9, 4), (1, 10, 4), (1, 11, 4), (1, 12, 4), (1, 13, 4), (1, 14, 4), (1, 15, 4), (1, 16, 4), (1, 17, 4), (1, 18, 4),
(2, 4, 4), (2, 5, 4), (2, 6, 4), (2, 7, 4), (2, 8, 4), (2, 9, 4), (2, 10, 4), (2, 11, 4), (2, 12, 4), (2, 13, 4), (2, 14, 4), (2, 15, 4), (2, 16, 4), (2, 17, 4), (2, 18, 4),
(3, 4, 4), (3, 5, 4), (3, 6, 4), (3, 7, 4), (3, 8, 4), (3, 9, 4), (3, 10, 4), (3, 11, 4), (3, 12, 4), (3, 13, 4), (3, 14, 4), (3, 15, 4), (3, 16, 4), (3, 17, 4), (3, 18, 4),
(4, 4, 4), (4, 5, 4), (4, 6, 4), (4, 7, 4), (4, 8, 4), (4, 9, 4), (4, 10, 4), (4, 11, 4), (4, 12, 4), (4, 13, 4), (4, 14, 4), (4, 15, 4), (4, 16, 4), (4, 17, 4), (4, 18, 4),
(5, 4, 4), (5, 5, 4), (5, 6, 4), (5, 7, 4), (5, 8, 4), (5, 9, 4), (5, 10, 4), (5, 11, 4), (5, 12, 4), (5, 13, 4), (5, 14, 4), (5, 15, 4), (5, 16, 4), (5, 17, 4), (5, 18, 4),
-- Semana 2
(6, 4, 4), (6, 5, 4), (6, 6, 4), (6, 7, 4), (6, 8, 4), (6, 9, 4), (6, 10, 4), (6, 11, 4), (6, 12, 4), (6, 13, 4), (6, 14, 4), (6, 15, 4), (6, 16, 4), (6, 17, 4), (6, 18, 4),
(7, 4, 4), (7, 5, 4), (7, 6, 4), (7, 7, 4), (7, 8, 4), (7, 9, 4), (7, 10, 4), (7, 11, 4), (7, 12, 4), (7, 13, 4), (7, 14, 4), (7, 15, 4), (7, 16, 4), (7, 17, 4), (7, 18, 4),
(8, 4, 4), (8, 5, 4), (8, 6, 4), (8, 7, 4), (8, 8, 4), (8, 9, 4), (8, 10, 4), (8, 11, 4), (8, 12, 4), (8, 13, 4), (8, 14, 4), (8, 15, 4), (8, 16, 4), (8, 17, 4), (8, 18, 4),
(9, 4, 4), (9, 5, 4), (9, 6, 4), (9, 7, 4), (9, 8, 4), (9, 9, 4), (9, 10, 4), (9, 11, 4), (9, 12, 4), (9, 13, 4), (9, 14, 4), (9, 15, 4), (9, 16, 4), (9, 17, 4), (9, 18, 4),
(10, 4, 4), (10, 5, 4), (10, 6, 4), (10, 7, 4), (10, 8, 4), (10, 9, 4), (10, 10, 4), (10, 11, 4), (10, 12, 4), (10, 13, 4), (10, 14, 4), (10, 15, 4), (10, 16, 4), (10, 17, 4), (10, 18, 4),

-- MÉDICO 5 (Roberto Silva - Cardiología) - Jornada: 09:00-17:00 (20 turnos por día)
-- Semana 1
(1, 4, 5), (1, 5, 5), (1, 6, 5), (1, 7, 5), (1, 8, 5), (1, 9, 5), (1, 10, 5), (1, 11, 5), (1, 12, 5), (1, 13, 5), (1, 14, 5), (1, 15, 5), (1, 16, 5), (1, 17, 5), (1, 18, 5), (1, 19, 5), (1, 20, 5), (1, 21, 5), (1, 22, 5), (1, 23, 5),
(2, 4, 5), (2, 5, 5), (2, 6, 5), (2, 7, 5), (2, 8, 5), (2, 9, 5), (2, 10, 5), (2, 11, 5), (2, 12, 5), (2, 13, 5), (2, 14, 5), (2, 15, 5), (2, 16, 5), (2, 17, 5), (2, 18, 5), (2, 19, 5), (2, 20, 5), (2, 21, 5), (2, 22, 5), (2, 23, 5),
(3, 4, 5), (3, 5, 5), (3, 6, 5), (3, 7, 5), (3, 8, 5), (3, 9, 5), (3, 10, 5), (3, 11, 5), (3, 12, 5), (3, 13, 5), (3, 14, 5), (3, 15, 5), (3, 16, 5), (3, 17, 5), (3, 18, 5), (3, 19, 5), (3, 20, 5), (3, 21, 5), (3, 22, 5), (3, 23, 5),
(4, 4, 5), (4, 5, 5), (4, 6, 5), (4, 7, 5), (4, 8, 5), (4, 9, 5), (4, 10, 5), (4, 11, 5), (4, 12, 5), (4, 13, 5), (4, 14, 5), (4, 15, 5), (4, 16, 5), (4, 17, 5), (4, 18, 5), (4, 19, 5), (4, 20, 5), (4, 21, 5), (4, 22, 5), (4, 23, 5),
(5, 4, 5), (5, 5, 5), (5, 6, 5), (5, 7, 5), (5, 8, 5), (5, 9, 5), (5, 10, 5), (5, 11, 5), (5, 12, 5), (5, 13, 5), (5, 14, 5), (5, 15, 5), (5, 16, 5), (5, 17, 5), (5, 18, 5), (5, 19, 5), (5, 20, 5), (5, 21, 5), (5, 22, 5), (5, 23, 5);

            INSERT INTO CITA (ID_TURNO, REFERENCIA, CONTRARREFERENCIA, ID_PACIENTE, CANCELADA, ATENDIDA) VALUES
-- Citas atendidas (con historial completo)
(1, NULL, NULL, 1, FALSE, TRUE),   -- Cita completada
(2, NULL, NULL, 2, FALSE, TRUE),   -- Cita completada
(3, NULL, NULL, 3, FALSE, TRUE),   -- Cita completada

-- Citas pendientes (futuras)
(8, NULL, NULL, 4, FALSE, FALSE),  -- Cita pendiente
(12, NULL, NULL, 5, FALSE, FALSE), -- Cita pendiente
(15, NULL, NULL, 6, FALSE, FALSE), -- Cita pendiente

-- Citas canceladas
(5, NULL, NULL, 1, TRUE, FALSE),   -- Cita cancelada
(10, NULL, NULL, 3, TRUE, FALSE),  -- Cita cancelada
(18, NULL, NULL, 5, TRUE, FALSE),  -- Cita cancelada

-- Citas con referencias
(20, 1, 2, 7, FALSE, TRUE),       -- Referencia desde cita 1
(25, 2, 3, 8, FALSE, FALSE),      -- Referencia desde cita 2

-- CITAS PASADAS SIN ATENDER (NUEVAS)
(4, NULL, NULL, 2, FALSE, FALSE),
(6, NULL, NULL, 4, FALSE, FALSE),
(7, NULL, NULL, 6, FALSE, FALSE),
(9, NULL, NULL, 8, FALSE, FALSE),
(11, NULL, NULL, 9, FALSE, FALSE),
(13, NULL, NULL, 10, FALSE, FALSE),
(14, NULL, NULL, 1, FALSE, FALSE),
(16, NULL, NULL, 3, FALSE, FALSE),
(17, NULL, NULL, 5, FALSE, FALSE),
(19, NULL, NULL, 7, FALSE, FALSE);


-- Actualizar turnos con las citas creadas
UPDATE TURNO SET ID_CITA = 1 WHERE ID_TURNO = 1;
UPDATE TURNO SET ID_CITA = 2 WHERE ID_TURNO = 2;
UPDATE TURNO SET ID_CITA = 3 WHERE ID_TURNO = 3;
UPDATE TURNO SET ID_CITA = 4 WHERE ID_TURNO = 8;
UPDATE TURNO SET ID_CITA = 5 WHERE ID_TURNO = 12;
UPDATE TURNO SET ID_CITA = 6 WHERE ID_TURNO = 15;
UPDATE TURNO SET ID_CITA = 7 WHERE ID_TURNO = 5;
UPDATE TURNO SET ID_CITA = 8 WHERE ID_TURNO = 10;
UPDATE TURNO SET ID_CITA = 9 WHERE ID_TURNO = 18;
UPDATE TURNO SET ID_CITA = 10 WHERE ID_TURNO = 20;
UPDATE TURNO SET ID_CITA = 11 WHERE ID_TURNO = 25;

UPDATE TURNO SET ID_CITA = 12 WHERE ID_TURNO = 4;
UPDATE TURNO SET ID_CITA = 13 WHERE ID_TURNO = 6;
UPDATE TURNO SET ID_CITA = 14 WHERE ID_TURNO = 7;
UPDATE TURNO SET ID_CITA = 15 WHERE ID_TURNO = 9;
UPDATE TURNO SET ID_CITA = 16 WHERE ID_TURNO = 11;
UPDATE TURNO SET ID_CITA = 17 WHERE ID_TURNO = 13;
UPDATE TURNO SET ID_CITA = 18 WHERE ID_TURNO = 14;
UPDATE TURNO SET ID_CITA = 19 WHERE ID_TURNO = 16;
UPDATE TURNO SET ID_CITA = 20 WHERE ID_TURNO = 17;
UPDATE TURNO SET ID_CITA = 21 WHERE ID_TURNO = 19;

-- =============================================================================
-- DIAGNÓSTICOS Y TRATAMIENTOS (solo para citas atendidas)
-- =============================================================================

-- Diagnósticos para citas atendidas
INSERT INTO DIAGNOSTICO (ID_CITA, SINTOMAS_IDENTIFICADOS, CONDICION, CERTEZA, TRATAMIENTO) VALUES
                                                                                               (1, 'Fiebre, dolor de cabeza, malestar general, congestión nasal', 'Infección viral respiratoria aguda', 'PROBABLE', 'Reposo, hidratación abundante y medicación sintomática. Control en 48 horas si no mejora.'),
                                                                                               (2, 'Dolor torácico opresivo, palpitaciones, disnea de esfuerzo', 'Taquicardia sinusal por ansiedad', 'DEFINITIVO', 'Control cardiológico periódico, técnicas de relajación y evitar estimulantes.'),
                                                                                               (3, 'Tos productiva con expectoración amarillenta, fiebre de 38.5°C, dolor torácico', 'Bronquitis aguda bacteriana', 'DEFINITIVO', 'Antibiótico terapia, broncodilatadores y expect');