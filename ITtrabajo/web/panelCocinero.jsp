<%-- 
    Document   : panelCocinero
    Created on : 02-jun-2025, 20:17:15
    Author     : maria
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page session="true" %>
<html>
    <head><title>Panel Cocinero</title></head>
    <body>
        <h1>Bienvenido, <s:property value="#session.usuario.nombreUsuario" />!</h1>
        <h2>Menú de Cocinero</h2>
        <s:form action="añadirPlato">
            <s:submit value="Añadir Plato"/>
        </s:form>

        <s:form action="listarPlatos">
            <s:submit value="Ver mis platos"/>
        </s:form>

        <s:form action="verValoraciones">
            <s:submit value="Ver valoraciones"/>
        </s:form>

        <s:form action="verPedidosPendientes">
            <s:submit value="Ver pedidos pendientes"/>
        </s:form>
        
        <s:form action="eliminarUsuario">
            <s:submit value="Darse de baja"/>
        </s:form>
    </body>
</html>
