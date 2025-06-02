<%-- 
    Document   : crearPlato
    Created on : 02-jun-2025, 20:17:52
    Author     : maria
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head><title>Crear Plato</title></head>
    <body>
        <h2>Crear Nuevo Plato</h2>

        <s:form action="crearPlato">
            <s:textfield name="plato.nombre" label="Nombre"/>
            <s:textarea name="plato.descripcion" label="Descripción"/>
            <s:textfield name="plato.precio" label="Precio"/>
            <s:textfield name="plato.porciones" label="Porciones"/>
            <s:select name="plato.categoriaId" list="categorias" listKey="id" listValue="nombre" label="Categoría"/>
            <s:submit value="Crear"/>
        </s:form>

    </body>
</html>

