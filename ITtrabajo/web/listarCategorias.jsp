
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- Establece el título que aparece en la pestaña del navegador --%>
        <title>Lista de Categorias</title>
    </head>
    <body>
        <%-- Título principal de la página --%>
        <h1>Categorias</h1>
        <s:form action="formRegistrarCategoria" method="get">
            <s:submit value="Registrar Nueva Categoría" />
        </s:form>
        <%-- Verifica si la lista de categorías no es nula y contiene elementos --%>

        <s:if test="categorias != null && !categorias.isEmpty()">
            <%-- Crea una tabla HTML con borde para mostrar los datos --%>
            <table border="1">

                <%-- Cabeceras de la tabla que indican qué datos se mostrarán --%>

                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                </tr>
                <%-- Itera sobre la lista de categorías (enviada desde el Action) --%>
                <s:iterator value="categorias" var="categoria">
                    <%-- Muestra los valores de cada categoría (id, nombre, descripción) --%>
                    <tr>
                        <td><s:property value="#categoria.id"/></td>
                        <td><s:property value="#categoria.nombre"/></td>
                        <td><s:property value="#categoria.descripcion"/></td>
                        <td>
                            <s:form action="eliminarCategoria" method="delete" onsubmit="return confirm('¿Está seguro de eliminar esta categoria?');">
                                <s:hidden name="categoria.id" value="%{#categoria.id}" />
                                <s:submit value="Eliminar" />
                            </s:form>

                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>

        <s:else>
            <%-- Mensaje alternativo si la lista de categorías está vacía o es nula --%>
            <p>No hay categorias para mostrar.</p>
        </s:else>
    </body>
</html>
