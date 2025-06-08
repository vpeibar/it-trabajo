<%-- 
    Document   : listarIngredientes
    Created on : 08-jun-2025, 22:55:05
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Ingredientes</title>
    </head>
    <body>
        <h1>Ingredientes</h1>
        <s:form action="formRegistrarIngrediente" method="get">
            <s:submit value="Registrar Nuevo Ingrediente" />
        </s:form>
        <s:if test="ingredientes != null && !ingredientes.isEmpty()">
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                </tr>
                <s:iterator value="ingredientes" var="ingrediente">
                    <tr>
                        <td><s:property value="#ingrediente.id"/></td>
                        <td><s:property value="#ingrediente.nombre"/></td>
                        <td>
                            <s:form action="eliminarIngrediente" method="delete" onsubmit="return confirm('¿Está seguro de eliminar este ingrediente?');">
                                <s:hidden name="ingrediente.id" value="%{#ingrediente.id}" />
                                <s:submit value="Eliminar" />
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>

        <s:else>
            <p>No hay ingredientes para mostrar.</p>
        </s:else>
    </body>
</html>

