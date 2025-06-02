<%-- 
    Document   : realizarPedido
    Created on : 02-jun-2025, 20:18:16
    Author     : maria
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head><title>Realizar Pedido</title></head>
    <body>
        <h2>Realizar Pedido</h2>

    <s:form action="crearPedido">
        <s:textfield name="pedido.clienteId" label="ID Cliente"/>
        <s:textfield name="pedido.platoId" label="ID Plato"/>
        <s:submit value="Confirmar Pedido"/>
    </s:form>

</body>
</html>

