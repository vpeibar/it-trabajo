<%-- 
    Document   : listarUsuarios
    Created on : 05-jun-2025, 9:54:05
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuarios</title>
    </head>
    <body>
        <h1>Usuarios</h1>
        <s:if test="usuarios != null && !usuarios.isEmpty()">
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Telefono</th>
                <th>Dni</th>
                <th>Direccion</th>
                <th>Nombre de usuario</th>
                <th>Tipo</th>
            </tr>
            <s:iterator value="usuarios" var="usuario">
                <tr>
                    <td><s:property value="#usuario.id"/></td>
                    <td><s:property value="#usuario.nombre"/></td>
                    <td><s:property value="#usuario.apellidos"/></td>
                    <td><s:property value="#usuario.telefono"/></td>
                    <td><s:property value="#usuario.dni"/></td>
                    <td><s:property value="#usuario.direccion"/></td>
                    <td><s:property value="#usuario.nombreUsuario"/></td>
                    <td><s:property value="#usuario.tipo"/></td>
                </tr>
            </s:iterator>
        </table>
    </s:if>

    <s:else>
        <p>No hay usuarios para mostrar.</p>
    </s:else>
    </body>
</html>
