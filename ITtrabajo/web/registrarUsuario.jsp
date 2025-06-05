<%-- 
    Document   : hola
    Created on : 05-jun-2025, 11:20:05
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar usuario</title>
    </head>
    <body>
        <h1>Registrar usuario</h1>

        <s:form action="registrarUsuario" method="post">
            <s:textfield name="usuario.nombreUsuario" label="Nombre de usuario" />
            <s:password name="usuario.contrasena" label="Contraseña"/>
            <s:textfield name="usuario.nombre" label="Nombre" />
            <s:textfield name="usuario.apellidos" label="Apellidos" />
            <s:textfield name="usuario.dni" label="DNI" />
            <s:textfield name="usuario.telefono" label="Teléfono" />
            <s:textfield name="usuario.direccion" label="Dirección" />
            <s:select name="usuario.tipo" label="Tipo" list="tipos" headerValue="Seleccionar"></s:select>
            <s:submit value="Registrar" />
        </s:form>
    </body>
</html>
