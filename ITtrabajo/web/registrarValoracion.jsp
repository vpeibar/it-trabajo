<%-- 
    Document   : registrarValoracion
    Created on : 08-jun-2025, 23:46:23
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar valoracion</title>
    </head>
    <body>
        <h1>Registrar valoracion</h1>
        <s:form action="registrarValoracion" method="post">
            <s:textfield name="valoracion.pedidoId" label="Id del pedido"/>
            <s:textfield name="valoracion.puntuacion" label="Puntuacion" />
            <s:textfield name="valoracion.comentario" label="Comentario" />
            <s:textfield name="valoracion.fecha" label="Fecha" />
            <s:textfield name="valoracion.usuarioId.nombreUsuario" label="Cocinero" />
            <s:submit value="Registrar" />
        </s:form>
    </body>
</html>
