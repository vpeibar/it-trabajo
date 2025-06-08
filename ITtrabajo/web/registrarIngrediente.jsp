<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Gestión de Ingredientes</title> 
        <%-- Título que se muestra en la pestaña del navegador --%>
    </head>
    <body>

        <h1>Gestión de Ingredientes</h1> 
        <%-- Encabezado principal de la página --%>

        <h2>Registrar Ingrediente</h2> 
        <%-- Subtítulo para la sección de registro --%>

        <s:form action="registrarIngrediente" method="POST">
            <%-- Formulario de Struts2 que se enviará a la acción 'registrarIngrediente' usando el método POST --%>

            <s:textfield name="ingrediente.nombre" label="Nombre del Ingrediente" required="true" />
            <%-- Campo de texto para introducir el nombre del ingrediente, con etiqueta visible y obligatorio --%>

            <s:submit value="Crear Ingrediente" />
            <%-- Botón para enviar el formulario y crear el nuevo ingrediente --%>
        </s:form>

        <hr/> 
        <%-- Línea horizontal para separar visualmente las secciones --%>

        <br/>
        <a href="formulario.jsp">Volver</a> 
        <%-- Enlace para volver a otra página, presumiblemente al menú de administración u otra funcionalidad --%>

    </body>
</html>
