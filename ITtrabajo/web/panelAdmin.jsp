<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <%-- Se establece la codificación del contenido y el título de la página --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel Admin</title>
    </head>
    <body>
        <h1>Administración</h1>
        <%-- Título principal de la interfaz de administración --%>

        <%-- Botón para listar todos los usuarios registrados --%>
        <s:form action="listarUsuarios">
            <s:submit value="Ver Usuarios"/>
        </s:form>

        <%-- Botón para acceder a la gestión de platos (crear, editar, eliminar) --%>
        <s:form action="gestionPlatos">
            <s:submit value="Gestión de Platos"/>
        </s:form>

        <%-- Botón para acceder a la gestión de categorías (alta, baja, modificación) --%>
        <s:form action="gestionCategorias">
            <s:submit value="Gestión de Categorías"/>
        </s:form>

        <%-- Botón para acceder a la gestión de ingredientes del sistema --%>
        <s:form action="gestionIngredientes">
            <s:submit value="Gestión de Ingredientes"/>
        </s:form>

        <%-- Botón para gestionar los pedidos realizados por los clientes --%>
        <s:form action="gestionPedidos">
            <s:submit value="Gestión de Pedidos"/>
        </s:form>

        <%-- Botón para visualizar o administrar valoraciones realizadas a los platos --%>
        <s:form action="gestionValoracion">
            <s:submit value="Gestión de Valoraciones"/>
        </s:form>
    </body>
</html>
