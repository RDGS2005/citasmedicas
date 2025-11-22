/*==============================================================*/
/* Table: CITA                                                  */
/*==============================================================*/
create table CITA
(
    ID_CITA              int not null auto_increment,
    ID_TURNO             int not null CHECK (ID_TURNO > 0),
    REFERENCIA           int CHECK (REFERENCIA > 0),
    CONTRARREFERENCIA    int CHECK (CONTRARREFERENCIA > 0),
    ID_PACIENTE          int not null CHECK (ID_PACIENTE > 0),
    CANCELADA            bool not null DEFAULT(false),
    primary key (ID_CITA)
);

/*==============================================================*/
/* Table: DIAGNOSTICO                                           */
/*==============================================================*/
create table DIAGNOSTICO
(
    ID_DIAGNOSTICO             int not null auto_increment,
    ID_CITA                    int not null CHECK (ID_CITA > 0),
    SINTOMAS_IDENTIFICADOS     varchar(256) not null,
    CONDICION                  varchar(128) not null,
    CERTEZA                    varchar(16) not null CHECK(CERTEZA in ('DEFINITIVO', 'PROBABLE', 'TENTATIVO', 'INCIERTO', 'DIFERENCIAL')),
    TRATAMIENTO                varchar(256),
    primary key (ID_DIAGNOSTICO)
);

/*==============================================================*/
/* Table: ESPECIALIZACION                                       */
/*==============================================================*/
create table ESPECIALIZACION
(
    ID_ESPECIALIZACION   int not null auto_increment,
    DESCRIPCION          varchar(32) not null,
    primary key (ID_ESPECIALIZACION)
);

/*==============================================================*/
/* Table: FECHA                                                 */
/*==============================================================*/
create table FECHA
(
    ID_FECHA             int not null auto_increment,
    FECHA                date not null,
    primary key (ID_FECHA)
);

/*==============================================================*/
/* Table: GRUPO_PRIORITARIO                                     */
/*==============================================================*/
create table GRUPO_PRIORITARIO
(
    ID_GRUPO             int not null auto_increment,
    DESCRIPCION          varchar(32) not null,
    primary key (ID_GRUPO)
);

/*==============================================================*/
/* Table: HORARIO                                               */
/*==============================================================*/
create table HORARIO
(
    ID_HORARIO           int not null auto_increment,
    HORA_INICIO          time not null,
    primary key (ID_HORARIO)
);

/*==============================================================*/
/* Table: MEDICAMENTO                                           */
/*==============================================================*/
create table MEDICAMENTO
(
    ID_MEDICAMENTO       int not null auto_increment,
    DESCRIPCION          varchar(32) not null,
    PRINCIPIO_ACTIVO     varchar(64) not null,
    primary key (ID_MEDICAMENTO)
);

/*==============================================================*/
/* Table: MEDICO                                                */
/*==============================================================*/
create table MEDICO
(
    ID_MEDICO            int not null auto_increment,
    CEDULA               char(10) not null CHECK(CEDULA REGEXP '^[0-9]{10}$'),
    PASSWORD             char(66) not null,
    ID_ESPECIALIZACION   int not null CHECK(ID_ESPECIALIZACION > 0),
    NOMBRES              varchar(64) not null,
    APELLIDOS            varchar(64) not null,
    SEXO                 char(16),
    FECHA_NACIMIENTO     date,
    JORNADA_INICIO       time not null,
    JORNADA_FIN          time not null,
    DADO_DE_BAJA         bool not null DEFAULT(false),
    primary key (ID_MEDICO)
);

/*==============================================================*/
/* Table: PACIENTE                                              */
/*==============================================================*/
create table PACIENTE
(
    ID_PACIENTE          int not null auto_increment,
    CEDULA               char(10) not null CHECK(CEDULA REGEXP '^[0-9]{10}$'),
    PASSWORD             char(66) not null,
    NOMBRES              varchar(64) not null,
    APELLIDOS            varchar(64) not null,
    SEXO                 char(16) not null,
    FECHA_NACIMIENTO     date not null,
    DIRECCION            varchar(128),
    NACIONALIDAD         varchar(128),
    TELEFONO             char(10) CHECK(TELEFONO REGEXP '^[0-9]{10}$'),
    CORREO               varchar(128) not null CHECK (CORREO REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$'),
    AFILIACION           char(16) not null CHECK (AFILIACION IN ('NO APORTA', 'SEGURO GENERAL', 'SEGURO VOLUNTARIO', 'SEGURO CAMPESINO')),
    DADO_DE_BAJA         bool not null DEFAULT(false),
    primary key (ID_PACIENTE)
);

/*==============================================================*/
/* Table: PERTENECE                                             */
/*==============================================================*/
create table PERTENECE
(
    ID_PACIENTE          int not null CHECK(ID_PACIENTE > 0),
    ID_GRUPO             int not null CHECK(ID_GRUPO > 0),
    primary key (ID_PACIENTE, ID_GRUPO)
);

/*==============================================================*/
/* Table: TRATAMIENTO                                                */
/*==============================================================*/
create table TRATAMIENTO
(
    ID_DIAGNOSTICO       int not null CHECK(ID_DIAGNOSTICO > 0),
    ID_MEDICAMENTO       int not null CHECK(ID_MEDICAMENTO > 0),
    DOSIS_MG             float not null CHECK(DOSIS_MG > 0),
    FRECUENCIA_HORAS     int not null CHECK(FRECUENCIA_HORAS > 0),
    TIEMPO_DIAS          int not null CHECK(TIEMPO_DIAS > 0),
    primary key (ID_DIAGNOSTICO, ID_MEDICAMENTO)
);

/*==============================================================*/
/* Table: TURNO                                                 */
/*==============================================================*/
create table TURNO
(
    ID_TURNO             int not null auto_increment,
    ID_CITA              int CHECK(ID_CITA > 0),
    ID_FECHA             int not null CHECK(ID_FECHA > 0),
    ID_HORARIO           int not null CHECK(ID_HORARIO > 0),
    ID_MEDICO            int not null CHECK(ID_MEDICO > 0),
    primary key (ID_TURNO)
);

create table OPERADOR(
                         ID_OPERADOR          int not null auto_increment,
                         CEDULA               char(10) not null CHECK(CEDULA REGEXP '^[0-9]{10}$'),
     PASSWORD             char(66) not null,
     NOMBRES              varchar(64) not null,
     APELLIDOS            varchar(64) not null,
     TELEFONO             char(10) CHECK(TELEFONO REGEXP '^[0-9]{10}$'),
     CORREO               varchar(128) not null CHECK (CORREO REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$'),
     DADO_DE_BAJA         bool not null DEFAULT(false),
     primary key (ID_OPERADOR)
);

alter table CITA add constraint FK_CITA_ASISTE_PACIENTE foreign key (ID_PACIENTE)
    references PACIENTE (ID_PACIENTE) on delete no action on update no action;

alter table CITA add constraint FK_CITA_CONTRARRE_CITA foreign key (CONTRARREFERENCIA)
    references CITA (ID_CITA) on delete no action on update no action;

alter table CITA add constraint FK_CITA_REFERENCI_CITA foreign key (REFERENCIA)
    references CITA (ID_CITA) on delete no action on update no action;

alter table CITA add constraint FK_CITA_TURNO_CIT_TURNO foreign key (ID_TURNO)
    references TURNO (ID_TURNO) on delete no action on update no action;

alter table DIAGNOSTICO add constraint FK_DIAGNOST_DETERMINA_CITA foreign key (ID_CITA)
    references CITA (ID_CITA) on delete no action on update no action;

alter table MEDICO add constraint FK_MEDICO_MEDICO_ESPECIALI foreign key (ID_ESPECIALIZACION)
    references ESPECIALIZACION (ID_ESPECIALIZACION) on delete no action on update no action;

alter table PERTENECE add constraint FK_PERTENEC_PERTENECE_PACIENTE foreign key (ID_PACIENTE)
    references PACIENTE (ID_PACIENTE) on delete no action on update no action;

alter table PERTENECE add constraint FK_PERTENEC_PERTENECE_GRUPO_PR foreign key (ID_GRUPO)
    references GRUPO_PRIORITARIO (ID_GRUPO) on delete no action on update no action;

alter table TRATAMIENTO add constraint FK_TRATAMIENTO_TRATAMIENTO_CITA foreign key (ID_DIAGNOSTICO)
    references DIAGNOSTICO (ID_DIAGNOSTICO) on delete no action on update no action;

alter table TRATAMIENTO add constraint FK_TRATAMIENTO_TRATAMIENTO2_MEDICAME foreign key (ID_MEDICAMENTO)
    references MEDICAMENTO (ID_MEDICAMENTO) on delete no action on update no action;

alter table TURNO add constraint FK_TURNO_ATIENDE_MEDICO foreign key (ID_MEDICO)
    references MEDICO (ID_MEDICO) on delete no action on update no action;

alter table TURNO add constraint FK_TURNO_TURNO_CITA foreign key (ID_CITA)
    references CITA (ID_CITA) on delete no action on update no action;

alter table TURNO add constraint FK_TURNO_TURNO_FECHA foreign key (ID_FECHA)
    references FECHA (ID_FECHA) on delete no action on update no action;

alter table TURNO add constraint FK_TURNO_TURNO_HORARIO foreign key (ID_HORARIO)
    references HORARIO (ID_HORARIO) on delete no action on update no action;
