<%-- 
    Document   : listarPlatosCocinero
    Created on : 08-jun-2025, 9:57:40
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Platos</title>
    </head>
    <body>
        <h1>Mis Platos</h1>
        <s:if test="platos != null && !platos.isEmpty()">
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Cocinero</th>
                    <th>Categoria</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Precio</th>
                    <th>Porciones</th>
                </tr>
                <s:iterator value="platos" var="plato">
                    <tr>
                        <td><s:property value="#plato.id"/></td>
                        <td><s:property value="#plato.usuarioId.nombreUsuario"/></td>
                        <td><s:property value="#plato.categoriaId.nombre"/></td>
                        <td><s:property value="#plato.nombre"/></td>
                        <td><s:property value="#plato.descripcion"/></td>
                        <td><s:property value="#plato.precio"/></td>
                        <td><s:property value="#plato.porciones"/></td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>

        <s:else>
            <p>No hay platos para mostrar.</p>
        </s:else>
    </body>
</html>

