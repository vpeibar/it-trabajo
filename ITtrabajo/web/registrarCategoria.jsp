<%-- 
    Document   : hola
    Created on : 05-jun-2025, 11:20:05
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar categoria</title>
    </head>
    <body>
        <h1>Registrar categoria</h1>

        <s:form action="registrar" method="post">
            <s:textfield name="categoria.nombre" label="Nombre" />
            <s:textarea name="categoria.descripcion" label="Descripcion"/>
            <s:submit value="Registrar" />
        </s:form>
    </body>
</html>
