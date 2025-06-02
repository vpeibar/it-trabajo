<%-- 
    Document   : listarPlatos
    Created on : 02-jun-2025, 20:17:27
    Author     : maria
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Lista de Platos</title>
    </head>
    <body>
        <h2>Platos disponibles</h2>

        <s:iterator value="platos">
            <div style="border:1px solid gray; padding:10px; margin:5px;">
                <p><strong>Nombre:</strong> <s:property value="nombre"/></p>
                <p><strong>Descripción:</strong> <s:property value="descripcion"/></p>
                <p><strong>Precio:</strong> <s:property value="precio"/> €</p>

                <s:url id="detalleURL" value="detallePlato.jsp">
                    <s:param name="id" value="%{id}"/>
                </s:url>
                <a href="<s:property value="#detalleURL"/>">Ver detalle</a>
            </div>
        </s:iterator>

    </body>
</html>


