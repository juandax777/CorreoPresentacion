# 📧 Sistema de Envío de Correos con Spring Boot

Proyecto para enviar correos electrónicos usando Spring Boot con arquitectura MVC.

## 📋 Estructura del Proyecto

```
CorreoPresentacion/
├── src/
│   └── main/
│       ├── java/
│       │   └── org/
│       │       └── example/
│       │           ├── Main.java                    # Clase principal
│       │           ├── config/
│       │           │   └── MailConfig.java          # Configuración del correo
│       │           ├── controller/
│       │           │   └── EmailController.java     # Controlador REST
│       │           ├── model/
│       │           │   └── EmailRequest.java        # Modelo de datos
│       │           └── service/
│       │               └── EmailService.java        # Lógica de negocio
│       └── resources/
│           └── application.properties               # Configuración
├── pom.xml                                          # Dependencias Maven
└── index.html                                       # Interfaz web
```

## 🚀 Configuración Inicial

### 1. Configurar Gmail

Para enviar correos desde Gmail, necesitas:

1. **Activar verificación en 2 pasos:**
   - Ir a https://myaccount.google.com/security
   - Activar "Verificación en 2 pasos"

2. **Generar contraseña de aplicación:**
   - Ir a https://myaccount.google.com/apppasswords
   - Seleccionar "Correo" y "Otro (nombre personalizado)"
   - Copiar la contraseña generada (16 caracteres)

### 2. Configurar application.properties

Edita el archivo `src/main/resources/application.properties`:

```properties
spring.mail.username=TU-CORREO@gmail.com
spring.mail.password=TU-CONTRASEÑA-DE-APLICACION
```

**⚠️ IMPORTANTE:** Usa la contraseña de aplicación, NO tu contraseña normal de Gmail.

## 📦 Instalación y Ejecución

### Opción 1: Con Maven

```bash
# Compilar el proyecto
mvn clean install

# Ejecutar la aplicación
mvn spring-boot:run
```

### Opción 2: Con IDE (IntelliJ IDEA, Eclipse)

1. Importar el proyecto como proyecto Maven
2. Ejecutar la clase `Main.java`

La aplicación se iniciará en: `http://localhost:8080`

## 🔌 API REST

### Endpoint: Enviar Correo

**URL:** `POST http://localhost:8080/api/email/send`

**Headers:**
```
Content-Type: application/json
```

**Body (JSON):**
```json
{
  "to": "eaguiarg@ucentral.edu.co",
  "subject": "Prueba",
  "body": "Hola desde Spring Boot"
}
```

**Respuesta Exitosa:**
```json
{
  "success": true,
  "message": "Correo enviado exitosamente",
  "to": "eaguiarg@ucentral.edu.co",
  "subject": "Prueba"
}
```

**Respuesta de Error:**
```json
{
  "success": false,
  "message": "Error al enviar el correo"
}
```

### Endpoint: Test

**URL:** `GET http://localhost:8080/api/email/test`

**Respuesta:**
```json
{
  "status": "OK",
  "message": "Servicio de correo funcionando correctamente"
}
```

## 🧪 Pruebas con Postman

### 1. Crear nueva petición
- Método: **POST**
- URL: `http://localhost:8080/api/email/send`

### 2. Configurar Headers
```
Content-Type: application/json
```

### 3. Configurar Body
- Seleccionar **raw**
- Seleccionar **JSON**
- Pegar el siguiente JSON:

```json
{
  "to": "eaguiarg@ucentral.edu.co",
  "subject": "Prueba",
  "body": "Hola desde Spring Boot"
}
```

### 4. Enviar la petición
- Click en **Send**
- Verificar la respuesta

## 🌐 Interfaz Web

Abre el archivo `index.html` en tu navegador para usar la interfaz gráfica:

1. Abre `index.html` en tu navegador
2. Rellena el formulario con:
   - Destinatario
   - Asunto
   - Mensaje
3. Click en "Enviar Correo"

**Nota:** La interfaz ya viene prellenada con los datos de ejemplo.

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Boot Starter Web** - Para crear la API REST
- **Spring Boot Starter Mail** - Para envío de correos
- **Maven** - Gestión de dependencias
- **HTML/CSS/JavaScript** - Interfaz de usuario

## 📝 Notas Importantes

1. **Seguridad:** NUNCA subas tu `application.properties` con credenciales reales a repositorios públicos.

2. **Gmail:** Si usas Gmail, asegúrate de:
   - Tener verificación en 2 pasos activada
   - Usar contraseña de aplicación (no tu contraseña normal)

3. **Puerto 587:** Gmail usa el puerto 587 con STARTTLS.

4. **Firewall:** Asegúrate de que tu firewall no bloquee el puerto 587.

## 🔧 Solución de Problemas

### Error: Authentication failed
- Verifica que estés usando la contraseña de aplicación correcta
- Verifica que la verificación en 2 pasos esté activa

### Error: Connection timeout
- Verifica tu conexión a internet
- Verifica que el firewall no bloquee el puerto 587

### Error: 535 Authentication credentials invalid
- Verifica el correo y contraseña en `application.properties`
- Regenera la contraseña de aplicación

## 📧 Contacto

Para dudas o sugerencias, contacta al desarrollador del proyecto.

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.

## PRUEBA DE FUNCIONAMIENTO

<img width="654" height="736" alt="image" src="https://github.com/user-attachments/assets/979ad1d5-1085-402d-a9ac-871cecf447bc" />

## PRUEBA CORREO ENVIADO

<img width="642" height="315" alt="image" src="https://github.com/user-attachments/assets/4e154b64-4587-43ee-b52f-d3d839741304" />
