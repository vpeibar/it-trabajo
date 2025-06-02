<%-- 
    Document   : editarPlato
    Created on : 02-jun-2025, 20:18:05
    Author     : maria
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head><title>Editar Plato</title></head>
    <body>
        <h2>Editar Plato</h2>

    <s:form action="actualizarPlato">
        <s:hidden name="plato.id"/>
        <s:textfield name="plato.nombre" label="Nombre"/>
        <s:textarea name="plato.descripcion" label="Descripción"/>
        <s:textfield name="plato.precio" label="Precio"/>
        <s:textfield name="plato.porciones" label="Porciones"/>
        <s:select name="plato.categoriaId" list="categorias" listKey="id" listValue="nombre" label="Categoría"/>
        <s:submit value="Guardar Cambios"/>
    </s:form>

</body>
</html>

