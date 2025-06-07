<%-- 
    Document   : login
    Created on : 02-jun-2025, 20:16:46
    Author     : maria
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head><title>Iniciar Sesión</title></head>
    <body>
        <h1>Iniciar Sesión</h1>

        <s:form action="login">
            <s:textfield name="nombreUsuario" label="Nombre de usuario"/>
            <s:password name="contrasena" label="Contraseña"/>
            <s:submit value="Iniciar sesión"/>
        </s:form>
        <p>¿No tienes una cuenta?
            <s:form action="formRegistro" method="get">
                <s:submit value="Registrar"/>
            </s:form>

            <s:actionerror/>
    </body>
</html>


