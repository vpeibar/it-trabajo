<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Realizar Pedido</title>
</head>
<body>
    <h2>Realizar un nuevo pedido</h2>

    <s:form action="PedidoAction" method="post">
        <!-- Fecha del pedido -->
        <s:label value="Fecha del pedido (yyyy-MM-dd)" />
        <s:textfield name="pedido.fecha" />

        <!-- Estado del pedido -->
        <s:label value="Estado del pedido (ej. pendiente)" />
        <s:textfield name="pedido.estado" />

        <!-- ID del cliente -->
        <s:label value="ID del cliente" />
        <s:textfield name="pedido.clienteId.id" />

        <s:submit value="Crear Pedido" />
    </s:form>

    <s:if test="mensaje != null">
        <p><b><s:property value="mensaje" /></b></p>
    </s:if>

</body>
</html>
