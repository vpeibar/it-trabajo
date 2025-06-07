<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Realizar Pedido</title>
    </head>
    <body>
        <h1>Platos</h1>
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
        <h1>Realizar Pedido</h1>
    </body>
</html>
