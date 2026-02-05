# 🔐 Guía Rápida: Configuración de Gmail para Spring Boot

## Paso 1: Activar la Verificación en 2 Pasos

1. Ve a: https://myaccount.google.com/security
2. En la sección "Cómo accedes a Google", busca "Verificación en 2 pasos"
3. Click en "Verificación en 2 pasos"
4. Sigue los pasos para activarla (necesitarás tu teléfono)

## Paso 2: Generar Contraseña de Aplicación

1. Una vez activada la verificación en 2 pasos, ve a: https://myaccount.google.com/apppasswords
   
   **O navega manualmente:**
   - Google Account → Seguridad → Verificación en 2 pasos
   - Scroll hasta el final de la página
   - Click en "Contraseñas de aplicaciones"

2. En "Selecciona la app", elige "Correo"
3. En "Selecciona el dispositivo", elige "Otro (nombre personalizado)"
4. Escribe un nombre como: "Spring Boot Mail"
5. Click en "Generar"

6. **¡IMPORTANTE!** Copia la contraseña de 16 caracteres que aparece
   - Ejemplo: `abcd efgh ijkl mnop`
   - Esta contraseña solo se muestra una vez

## Paso 3: Configurar application.properties

Abre el archivo `src/main/resources/application.properties` y edita:

```properties
# Reemplaza con tu correo de Gmail
spring.mail.username=tu-correo@gmail.com

# Reemplaza con la contraseña de aplicación (los 16 caracteres)
# Puedes escribirla con o sin espacios
spring.mail.password=abcdefghijklmnop
```

## Paso 4: Verificar la Configuración

Ejecuta tu aplicación y prueba enviando un correo.

## ❗ Problemas Comunes

### "535 Authentication credentials invalid"
- **Causa:** Contraseña incorrecta
- **Solución:** Verifica que hayas copiado bien la contraseña de aplicación

### "Username and Password not accepted"
- **Causa:** No has activado la verificación en 2 pasos
- **Solución:** Completa el Paso 1

### "Invalid credentials (Failure)"
- **Causa:** Estás usando tu contraseña normal de Gmail
- **Solución:** Usa la contraseña de aplicación (Paso 2)

### No puedo acceder a "Contraseñas de aplicaciones"
- **Causa:** La verificación en 2 pasos no está activa
- **Solución:** Completa primero el Paso 1

## 🔒 Consejos de Seguridad

1. **NUNCA** compartas tu contraseña de aplicación
2. **NUNCA** subas el archivo `application.properties` con credenciales a GitHub
3. Si sospechas que tu contraseña está comprometida:
   - Ve a https://myaccount.google.com/apppasswords
   - Revoca la contraseña antigua
   - Genera una nueva

## 📱 Alternativa: Cuenta de Gmail Secundaria

Si no quieres usar tu cuenta personal:

1. Crea una nueva cuenta de Gmail específica para desarrollo
2. Activa la verificación en 2 pasos en esa cuenta
3. Genera una contraseña de aplicación
4. Usa esas credenciales en tu aplicación

## ✅ Verificación Final

Para verificar que todo funciona:

1. Inicia tu aplicación Spring Boot
2. Abre Postman
3. Envía una petición POST a `http://localhost:8080/api/email/send`
4. Si recibes el correo, ¡todo está configurado correctamente! 🎉

## 📞 Más Ayuda

Si sigues teniendo problemas, consulta:
- Documentación oficial de Gmail: https://support.google.com/accounts/answer/185833
- Documentación de Spring Mail: https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#mail
