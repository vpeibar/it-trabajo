<%-- 
    Document   : panelCocinero
    Created on : 02-jun-2025, 20:17:15
    Author     : maria
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page session="true" %>
<s:set var="usuario" value="#session.usuarioLogueado" />
<html>
    <head><title>Panel Cocinero</title></head>
    <body>
        <h1>Bienvenido, <s:property value="#usuario.nombreUsuario" />!</h1>
        <h2>Menú de Cocinero</h2>
        <s:form action="eliminarUsuario" method="delete" onsubmit="return confirm('¿Está seguro de eliminar su cuenta?');">
            <s:submit value="Darse de baja"/>
        </s:form>
    </body>
</html>
