CITAS MEDICAS

Sistema de gestión de citas médicas — aplicación Java para registrar pacientes, médicos y gestionar citas

Descripción

Aplicación para manejar citas médicas: registro y gestión de pacientes, médicos, medicación y programación de citas. Implementada principalmente en Java (interfaz y/o back-end), con estructura modular en src/ y recursos adicionales en lib/, scripts/ y design/.

Características

Registro y edición de pacientes.

Registro y edición de médicos.

Gestión y programación de citas.

Manejo de medicamentos (inventario básico).

Persistencia en base de datos (MySQL/MariaDB o H2 para pruebas).

Estructura de carpetas pensada para desarrollo con IDE (IntelliJ / Eclipse).

Tech stack (estimado)

Basado en los archivos del repositorio (principalmente Java).

Lenguaje: Java

Base de datos: MySQL

IDE recomendado: IntelliJ IDEA

Instalación y ejecución (guía general)

Clona el repositorio:

git clone https://github.com/RDGS2005/citasmedicas.git
cd citasmedicas


Abrir en el IDE:

Abre la carpeta del proyecto en IntelliJ IDEA (reconoce automáticamente proyectos Java).

Si usas Maven/Gradle, importa el proyecto como tal para que descargue dependencias.

Compilar y ejecutar (opciones):

Si usas Maven

mvn clean package
# Ejecutar (si produce JAR ejecutable)
java -jar target/*.jar


Si usas Gradle

./gradlew build
java -jar build/libs/*.jar


Desde IntelliJ

Localiza la clase Main o el punto de entrada y ejecuta con el botón Run.

Si el proyecto no tiene un JAR ejecutable configurado, ejecútalo directamente desde el IDE.

Configuración de la base de datos (ejemplo MySQL)

Crear la base de datos utilizando los scripts de DDL y DML

Configura la connection string en el archivo de configuración del proyecto (por ejemplo application.properties, config.properties o constantes en MySQLDataHelper):

jdbc.url=jdbc:mysql://localhost:3306/citasmedicas
jdbc.user=citas_user
jdbc.password=tu_password

Estructura del proyecto (resumen)
citasmedicas/
├─ src/                # Código fuente Java
├─ lib/                # Librerías externas (si aplica)
├─ scripts/            # Scripts SQL o auxiliares
├─ design/             # Recursos de diseño (UI, imágenes)
├─ .gitignore
├─ citasmedicas.iml    # archivo de proyecto IntelliJ
