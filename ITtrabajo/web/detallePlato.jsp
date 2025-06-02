<%-- 
    Document   : detallePlato
    Created on : 02-jun-2025, 20:17:40
    Author     : maria
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Detalle del Plato</title>
    </head>
    <body>
        <h2>Detalle del Plato</h2>

        <p><strong>Nombre:</strong> <s:property value="plato.nombre"/></p>
        <p><strong>Descripción:</strong> <s:property value="plato.descripcion"/></p>
        <p><strong>Precio:</strong> <s:property value="plato.precio"/> €</p>
        <p><strong>Porciones:</strong> <s:property value="plato.porciones"/></p>

        <s:form action="crearPedido">
            <s:hidden name="pedido.platoId" value="%{plato.id}"/>
            <s:hidden name="pedido.clienteId" value="<!-- ID del cliente actual -->"/>
            <s:submit value="Pedir este plato"/>
        </s:form>

    </body>
</html>


