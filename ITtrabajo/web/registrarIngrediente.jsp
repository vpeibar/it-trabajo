<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Gestión de Ingredientes</title>
    </head>
    <body>

        <h1>Gestión de Ingredientes</h1>

      
        <h2>Registrar Ingrediente</h2>
        <s:form action="registrarIngrediente" method="POST">
            <s:textfield name="ingrediente.nombre" label="Nombre del Ingrediente" required="true" />
            <s:submit value="Crear Ingrediente" />
        </s:form>

        <hr/>
        <br/>
        <a href="formulario.jsp">Volver</a>

    </body>
</html>
