<%-- 
    Document   : panelCliente
    Created on : 02-jun-2025, 20:16:56
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page session="true" %>
<html>
    <head><title>Panel Cliente</title></head>
    <body>
        <h1>Bienvenido, <s:property value="#session.usuario.nombreUsuario" />!</h1>
        <h2>Menú de Cliente</h2>
        <s:form action="listarPlatos">
            <s:submit value="Ver Platos"/>
        </s:form>

        <s:form action="realizarPedido">
            <s:submit value="Realizar Pedido"/>
        </s:form>

        <s:form action="valorarPedido">
            <s:submit value="Valorar Pedido"/>
        </s:form>

        <s:form action="listarPedidos">
            <s:submit value="Ver Mis Pedidos"/>
        </s:form>
        
        <s:form action="eliminarUsuario">
            <s:submit value="Darse de baja"/>
        </s:form>
    </body>
</html>

