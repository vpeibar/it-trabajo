
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head><title>Iniciar Sesión</title></head>
    <body>
        <h1>Iniciar Sesión</h1>

        <%-- Formulario de inicio de sesión que se enviará a la acción "login" --%>
        <s:form action="login">
            <%-- Campo de texto para el nombre de usuario, vinculado con la propiedad "nombreUsuario" del Action --%>
            <s:textfield name="nombreUsuario" label="Nombre de usuario"/>
            <%-- Campo de contraseña vinculado con la propiedad "contrasena" del Action --%>
            <s:password name="contrasena" label="Contraseña"/>
            <%-- Botón para enviar el formulario e intentar iniciar sesión --%>
            <s:submit value="Iniciar sesión"/>
        </s:form>

        <%-- Párrafo con una opción para registrarse si no se tiene cuenta --%>
        <p>¿No tienes una cuenta?

            <%-- Formulario con botón que redirige a la acción "formRegistro" para mostrar el formulario de registro --%>
            <s:form action="formRegistro" method="get">
                <s:submit value="Registrar"/>
            </s:form>
            <%-- Muestra errores generados durante el proceso de login (por ejemplo, credenciales inválidas) --%>
            <s:actionerror/>
    </body>
</html>


