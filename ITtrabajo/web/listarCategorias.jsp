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
        <title>Lista de Categorias</title>
    </head>
    <body>
        <h1>Categorias</h1>
        <s:form action="formRegistrarCategoria" method="get">
            <s:submit value="Registrar Nueva Categoría" />
        </s:form>
        <s:if test="categorias != null && !categorias.isEmpty()">
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                </tr>
                <s:iterator value="categorias" var="categoria">
                    <tr>
                        <td><s:property value="#categoria.id"/></td>
                        <td><s:property value="#categoria.nombre"/></td>
                        <td><s:property value="#categoria.descripcion"/></td>
                        <td>
                            <s:form action="eliminarCategoria" method="delete" onsubmit="return confirm('¿Está seguro de eliminar esta categoria?');">
                                <s:hidden name="id" value="%{#categoria.id}" />
                                <s:submit value="Eliminar" />
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>

        <s:else>
            <p>No hay categorias para mostrar.</p>
        </s:else>
    </body>
</html>
