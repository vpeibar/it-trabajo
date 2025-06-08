
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <%-- Especifica el tipo de contenido y la codificación del documento --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar categoria</title>
    </head>
    <body>
        <%-- Título visible de la página --%>
        <h1>Registrar categoría</h1> 
        <%-- Formulario Struts2 que al enviarse ejecuta la acción "registrar" con método POST --%>
        <s:form action="registrarCategoria" method="post">
            <s:form action="registrar" method="post">

                <%-- Campo de texto para introducir el nombre de la nueva categoría --%>
                <s:textfield name="categoria.nombre" label="Nombre" />

                <%-- Área de texto para añadir una descripción más detallada de la categoría --%>
                <s:textarea name="categoria.descripcion" label="Descripción"/>

                <%-- Botón para enviar el formulario --%>
                <s:submit value="Registrar" />
            </s:form>
    </body>
</html>
