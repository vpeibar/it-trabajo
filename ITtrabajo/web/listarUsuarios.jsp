
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuarios</title> <%-- Título de la pestaña del navegador --%>
    </head>
    <body>
        <h1>Usuarios</h1> <%-- Encabezado principal de la página --%>

        <%-- Verifica si la lista de usuarios no es nula ni vacía antes de mostrar la tabla --%>
        <s:if test="usuarios != null && !usuarios.isEmpty()">
            <table border="1"> <%-- Tabla HTML con borde --%>
                <tr>
                    <%-- Cabecera de la tabla con los nombres de las columnas --%>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Teléfono</th>
                    <th>DNI</th>
                    <th>Dirección</th>
                    <th>Nombre de usuario</th>
                    <th>Tipo</th>
                </tr>

                <%-- Itera sobre la lista "usuarios" y genera una fila por cada usuario --%>
                <s:iterator value="usuarios" var="usuario">
                    <tr>
                        <%-- Cada celda obtiene un atributo del usuario actual --%>
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

        <%-- Si no hay usuarios en la lista, se muestra un mensaje alternativo --%>
        <s:else>
            <p>No hay usuarios para mostrar.</p>
        </s:else>
    </body>
</html>