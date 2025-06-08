<%-- 
    Document   : verValoraciones
    Created on : 02-jun-2025, 20:18:39
    Author     : maria
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Valoraciones</title>
    </head>
    <body>
        <h1>Valoraciones</h1>
        <s:form action="formRegistrarValoracion" method="get">
            <s:submit value="Registrar Nueva Valoracion" />
        </s:form>
        <s:if test="valoraciones != null && !valoraciones.isEmpty()">
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Cocinero</th>
                    <th>Id del pedido</th>
                    <th>Puntuacion</th>
                    <th>Comentario</th>
                    <th>Fecha</th>         
                </tr>
                <s:iterator value="valoraciones" var="valoracion">
                    <tr>
                        <td><s:property value="#valoracion.id"/></td>
                        <td><s:property value="#valoracion.usuarioId.nombreUsuario"/></td>
                        <td><s:property value="#valoracion.pedidoId"/></td>
                        <td><s:property value="#valoracion.puntuacion"/></td>
                        <td><s:property value="#valoracion.comentario"/></td>
                        <td><s:property value="#valoracion.fecha"/></td>
                        <td>
                            <s:form action="eliminarValoracion" method="delete" onsubmit="return confirm('¿Está seguro de eliminar esta valoracion?');">
                                <s:hidden name="valoracion.id" value="%{#valoracion.id}" />
                                <s:submit value="Eliminar" />
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>

        <s:else>
            <p>No hay valoraciones para mostrar.</p>
        </s:else>
    </body>
</html>