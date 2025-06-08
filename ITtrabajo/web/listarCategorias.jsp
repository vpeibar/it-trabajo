
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Categorias</title>
        <%-- Establece el título que aparece en la pestaña del navegador --%>
    </head>
    <body>
        <h1>Categorias</h1>
        <%-- Título principal de la página --%>

        <s:if test="categorias != null && !categorias.isEmpty()">
            <%-- Verifica si la lista de categorías no es nula y contiene elementos --%>

            <table border="1">
                <%-- Crea una tabla HTML con borde para mostrar los datos --%>

                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <%-- Cabeceras de la tabla que indican qué datos se mostrarán --%>
                </tr>

                <s:iterator value="categorias" var="categoria">
                    <%-- Itera sobre la lista de categorías (enviada desde el Action) --%>
                    <tr>
                        <td><s:property value="#categoria.id"/></td>
                        <td><s:property value="#categoria.nombre"/></td>
                        <td><s:property value="#categoria.descripcion"/></td>
                        <%-- Muestra los valores de cada categoría (id, nombre, descripción) --%>
                    </tr>
                </s:iterator>
            </table>
        </s:if>

        <s:else>
            <p>No hay categorias para mostrar.</p>
            <%-- Mensaje alternativo si la lista de categorías está vacía o es nula --%>
        </s:else>
    </body>
</html>
