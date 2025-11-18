/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     17/11/2025 15:26:53                          */
/*==============================================================*/


/*==============================================================*/
/* Table: CITA                                                  */
/*==============================================================*/
create table CITA
(
   ID_CITA              int not null auto_increment,
   ID_TURNO             int,
   REFRENCIA            int,
   CONTRARREFERENCIA    int,
   ID_PACIENTE          int,
   ASISTE_MEDICO        bool not null,
   ASISTE_PACIENTE      bool not null,
   RECOMENDACIONES      varchar(256),
   primary key (ID_CITA)
);

/*==============================================================*/
/* Table: DIAGNOSTICO                                           */
/*==============================================================*/
create table DIAGNOSTICO
(
   ID_DIAGNOSTICO       int not null auto_increment,
   ID_CITA              int,
   CONDICION            varchar(128) not null,
   CERTEZA              varchar(16) not null,
   SINTOMAS_IDENTIFICADOS varchar(256) not null,
   primary key (ID_DIAGNOSTICO)
);

/*==============================================================*/
/* Table: ESPECIALIZACION                                       */
/*==============================================================*/
create table ESPECIALIZACION
(
   ID_ESPECIALIZACION   int not null auto_increment,
   NUMERO               int not null,
   primary key (ID_ESPECIALIZACION)
);

/*==============================================================*/
/* Table: EXAMEN                                                */
/*==============================================================*/
create table EXAMEN
(
   ID_EXAMEN            int not null auto_increment,
   ID_CITA              int,
   ID_LABORATORIO       int,
   RESULTADOS           varchar(256) not null,
   primary key (ID_EXAMEN)
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
/* Table: LABORATIO                                             */
/*==============================================================*/
create table LABORATIO
(
   ID_LABORATORIO       int not null auto_increment,
   NUMERO               int not null,
   DEPARTAMENTO         varchar(64) not null,
   primary key (ID_LABORATORIO)
);

/*==============================================================*/
/* Table: MEDICAMENTO                                           */
/*==============================================================*/
create table MEDICAMENTO
(
   ID_MEDICAMENTO       int not null auto_increment,
   NUMERO               int not null,
   PRINCIPIO_ACTIVO     varchar(64) not null,
   primary key (ID_MEDICAMENTO)
);

/*==============================================================*/
/* Table: MEDICO                                                */
/*==============================================================*/
create table MEDICO
(
   ID_MEDICO            int not null auto_increment,
   ID_ESPECIALIZACION   int,
   NOMBRES              varchar(64) not null,
   APELLIDOS            varchar(64) not null,
   SEXO                 char(16),
   FECHA_NACIMIENTO     date,
   JORNADA_INICIO       time not null,
   JORNADA_FIN          time not null,
   primary key (ID_MEDICO)
);

/*==============================================================*/
/* Table: PACIENTE                                              */
/*==============================================================*/
create table PACIENTE
(
   ID_PACIENTE          int not null auto_increment,
   CEDULA               char(10) not null,
   NOMBRES              varchar(64) not null,
   APELLIDOS            varchar(64) not null,
   SEXO                 char(16) not null,
   FECHA_NACIMIENTO     date not null,
   DIRECCION            varchar(128),
   NACIONALIDAD         varchar(128),
   TELEFONO             char(10),
   CORREO               varchar(128) not null,
   AFILIACION           char(16) not null,
   primary key (ID_PACIENTE)
);

/*==============================================================*/
/* Table: PERTENECE                                             */
/*==============================================================*/
create table PERTENECE
(
   ID_PACIENTE          int not null,
   ID_GRUPO             int not null,
   primary key (ID_PACIENTE, ID_GRUPO)
);

/*==============================================================*/
/* Table: RECETA                                                */
/*==============================================================*/
create table RECETA
(
   ID_CITA              int not null,
   ID_MEDICAMENTO       int not null,
   primary key (ID_CITA, ID_MEDICAMENTO)
);

/*==============================================================*/
/* Table: TURNO                                                 */
/*==============================================================*/
create table TURNO
(
   ID_TURNO             int not null auto_increment,
   ID_CITA              int,
   ID_FECHA             int,
   ID_HORARIO           int,
   ID_MEDICO            int,
   primary key (ID_TURNO)
);

alter table CITA add constraint FK_CITA_ASISTE_PACIENTE foreign key (ID_PACIENTE)
      references PACIENTE (ID_PACIENTE) on delete restrict on update restrict;

alter table CITA add constraint FK_CITA_CONTRARRE_CITA foreign key (CONTRARREFERENCIA)
      references CITA (ID_CITA) on delete restrict on update restrict;

alter table CITA add constraint FK_CITA_REFERENCI_CITA foreign key (REFRENCIA)
      references CITA (ID_CITA) on delete restrict on update restrict;

alter table CITA add constraint FK_CITA_TURNO_CIT_TURNO foreign key (ID_TURNO)
      references TURNO (ID_TURNO) on delete restrict on update restrict;

alter table DIAGNOSTICO add constraint FK_DIAGNOST_DETERMINA_CITA foreign key (ID_CITA)
      references CITA (ID_CITA) on delete restrict on update restrict;

alter table EXAMEN add constraint FK_EXAMEN_MANDA_CITA foreign key (ID_CITA)
      references CITA (ID_CITA) on delete restrict on update restrict;

alter table EXAMEN add constraint FK_EXAMEN_REALIZA_LABORATI foreign key (ID_LABORATORIO)
      references LABORATIO (ID_LABORATORIO) on delete restrict on update restrict;

alter table MEDICO add constraint FK_MEDICO_MEDICO_ES_ESPECIAL foreign key (ID_ESPECIALIZACION)
      references ESPECIALIZACION (ID_ESPECIALIZACION) on delete restrict on update restrict;

alter table PERTENECE add constraint FK_PERTENEC_PERTENECE_PACIENTE foreign key (ID_PACIENTE)
      references PACIENTE (ID_PACIENTE) on delete restrict on update restrict;

alter table PERTENECE add constraint FK_PERTENEC_PERTENECE_GRUPO_PR foreign key (ID_GRUPO)
      references GRUPO_PRIORITARIO (ID_GRUPO) on delete restrict on update restrict;

alter table RECETA add constraint FK_RECETA_RECETA_CITA foreign key (ID_CITA)
      references CITA (ID_CITA) on delete restrict on update restrict;

alter table RECETA add constraint FK_RECETA_RECETA2_MEDICAME foreign key (ID_MEDICAMENTO)
      references MEDICAMENTO (ID_MEDICAMENTO) on delete restrict on update restrict;

alter table TURNO add constraint FK_TURNO_ATIENDE_MEDICO foreign key (ID_MEDICO)
      references MEDICO (ID_MEDICO) on delete restrict on update restrict;

alter table TURNO add constraint FK_TURNO_TURNO_CIT_CITA foreign key (ID_CITA)
      references CITA (ID_CITA) on delete restrict on update restrict;

alter table TURNO add constraint FK_TURNO_TURNO_FEC_FECHA foreign key (ID_FECHA)
      references FECHA (ID_FECHA) on delete restrict on update restrict;

alter table TURNO add constraint FK_TURNO_TURNO_HOR_HORARIO foreign key (ID_HORARIO)
      references HORARIO (ID_HORARIO) on delete restrict on update restrict;

