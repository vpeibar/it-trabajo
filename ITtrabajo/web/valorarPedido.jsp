<%-- 
    Document   : valorarPedido
    Created on : 02-jun-2025, 20:18:27
    Author     : maria
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head><title>Valorar Pedido</title></head>
    <body>
        <h2>Valorar Pedido</h2>

    <s:form action="registrarValoracion">
        <s:textfield name="valoracion.pedidoId" label="ID Pedido"/>
        <s:textfield name="valoracion.puntuacion" label="Puntuación (1 a 5)"/>
        <s:textarea name="valoracion.comentario" label="Comentario"/>
        <s:submit value="Enviar Valoración"/>
    </s:form>

</body>
</html>

