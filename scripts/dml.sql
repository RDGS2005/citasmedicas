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
('2025-11-24'), ('2025-11-25'), ('2025-11-26'), ('2025-11-27'), ('2025-11-28'),
-- Semana 2
('2025-12-01'), ('2025-12-02'), ('2025-12-03'), ('2025-12-04'), ('2025-12-05');

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

-- Función auxiliar para generar turnos
INSERT INTO TURNO (ID_FECHA, ID_HORARIO, ID_MEDICO) VALUES
-- Semana 1 - Lunes a Viernes
-- Médico 1 (Medicina General) - Turnos completos
(1, 1, 1), (1, 2, 1), (1, 3, 1), (1, 4, 1), (1, 5, 1), (1, 6, 1), (1, 7, 1), (1, 8, 1),
(2, 9, 1), (2, 10, 1), (2, 11, 1), (2, 12, 1), (2, 13, 1), (2, 14, 1), (2, 15, 1), (2, 16, 1),
(3, 17, 1), (3, 18, 1), (3, 19, 1), (3, 20, 1), (3, 21, 1), (3, 22, 1), (3, 23, 1), (3, 24, 1),
(4, 25, 1), (4, 26, 1), (4, 27, 1), (4, 1, 1), (4, 2, 1), (4, 3, 1), (4, 4, 1), (4, 5, 1),
(5, 6, 1), (5, 7, 1), (5, 8, 1), (5, 9, 1), (5, 10, 1), (5, 11, 1), (5, 12, 1), (5, 13, 1),

-- Médico 2 (Medicina General) - Turnos alternos
(1, 14, 2), (1, 15, 2), (1, 16, 2), (1, 17, 2), (1, 18, 2),
(2, 19, 2), (2, 20, 2), (2, 21, 2), (2, 22, 2), (2, 23, 2),
(3, 24, 2), (3, 25, 2), (3, 26, 2), (3, 27, 2), (3, 1, 2),
(4, 2, 2), (4, 3, 2), (4, 4, 2), (4, 5, 2), (4, 6, 2),
(5, 7, 2), (5, 8, 2), (5, 9, 2), (5, 10, 2), (5, 11, 2),

-- Médico 3 (Pediatría) - Turnos matutinos
(1, 8, 3), (1, 9, 3), (1, 10, 3), (1, 11, 3), (1, 12, 3), (1, 13, 3),
(2, 8, 3), (2, 9, 3), (2, 10, 3), (2, 11, 3), (2, 12, 3), (2, 13, 3),
(3, 8, 3), (3, 9, 3), (3, 10, 3), (3, 11, 3), (3, 12, 3), (3, 13, 3),
(4, 8, 3), (4, 9, 3), (4, 10, 3), (4, 11, 3), (4, 12, 3), (4, 13, 3),
(5, 8, 3), (5, 9, 3), (5, 10, 3), (5, 11, 3), (5, 12, 3), (5, 13, 3),

-- Otros médicos - Turnos específicos
(1, 14, 4), (1, 15, 4), (1, 16, 4), (2, 14, 4), (2, 15, 4), (2, 16, 4),  -- Cardiología
(3, 17, 5), (3, 18, 5), (4, 17, 5), (4, 18, 5), (5, 17, 5), (5, 18, 5),  -- Ginecología
(1, 19, 6), (1, 20, 6), (2, 19, 6), (2, 20, 6), (3, 19, 6), (3, 20, 6),  -- Dermatología
(4, 21, 7), (4, 22, 7), (5, 21, 7), (5, 22, 7), (6, 21, 7), (6, 22, 7),  -- Neurología
(1, 23, 8), (2, 23, 8), (3, 23, 8), (4, 23, 8), (5, 23, 8),              -- Ortopedia
(1, 24, 9), (3, 24, 9), (5, 24, 9), (7, 24, 9), (9, 24, 9),              -- Oftalmología
(2, 25, 10), (4, 25, 10), (6, 25, 10), (8, 25, 10), (10, 25, 10);        -- Gastroenterología

-- =============================================================================
-- CITAS (escenarios realistas)
-- =============================================================================

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
(25, 2, 3, 8, FALSE, FALSE);      -- Referencia desde cita 2

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

-- =============================================================================
-- DIAGNÓSTICOS Y TRATAMIENTOS (solo para citas atendidas)
-- =============================================================================

-- Diagnósticos para citas atendidas
INSERT INTO DIAGNOSTICO (ID_CITA, SINTOMAS_IDENTIFICADOS, CONDICION, CERTEZA, TRATAMIENTO) VALUES
                                                                                               (1, 'Fiebre, dolor de cabeza, malestar general, congestión nasal', 'Infección viral respiratoria aguda', 'PROBABLE', 'Reposo, hidratación abundante y medicación sintomática. Control en 48 horas si no mejora.'),
                                                                                               (2, 'Dolor torácico opresivo, palpitaciones, disnea de esfuerzo', 'Taquicardia sinusal por ansiedad', 'DEFINITIVO', 'Control cardiológico periódico, técnicas de relajación y evitar estimulantes.'),
                                                                                               (3, 'Tos productiva con expectoración amarillenta, fiebre de 38.5°C, dolor torácico', 'Bronquitis aguda bacteriana', 'DEFINITIVO', 'Antibiótico terapia, broncodilatadores y expect');