<%-- 
    Document   : panelAdmin
    Created on : 08-jun-2025, 14:17:42
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel Admin</title>
    </head>
    <body>
        <h1>Administración</h1>
        <s:form action="listarUsuarios">
            <s:submit value="Ver Usuarios"/>
        </s:form>

        <s:form action="gestionPlatos">
            <s:submit value="Gestión de Platos"/>
        </s:form>

        <s:form action="gestionCategorias">
            <s:submit value="Gestión de Categorías"/>
        </s:form>
        
        <s:form action="gestionIngredientes">
            <s:submit value="Gestión de Ingredientes"/>
        </s:form>
        
        <s:form action="gestionPedidos">
            <s:submit value="Gestión de Pedidos"/>
        </s:form>
        
        <s:form action="gestionValoracion">
            <s:submit value="Gestión de Valoraciones"/>
        </s:form>
    </body>
</html>
