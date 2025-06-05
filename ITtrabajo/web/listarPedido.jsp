<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*" %>

<%
    String tipo = (String) session.getAttribute("tipo");
%>

<h2>
    <%= "cocinero".equalsIgnoreCase(tipo) ? "Pedidos Pendientes de Todos los Clientes" : "Mis Pedidos" %>
</h2>

<s:if test="pedidos != null && !pedidos.isEmpty()">
    <s:iterator value="pedidos" var="p">
        <h3>Pedido ID: <s:property value="#p.id" /> | Cliente ID: <s:property value="#p.cliente_id" /> | Fecha: <s:property value="#p.fecha" /> | Estado: <s:property value="#p.estado" /></h3>
        
        <table border="1">
            <tr>
                <th>Plato</th>
                <th>Cantidad</th>
            </tr>
            <s:iterator value="#p.lineasPedido" var="lp">
                <tr>
                    <td><s:property value="#lp.plato.nombre" /></td>
                    <td><s:property value="#lp.cantidad" /></td>
                </tr>
            </s:iterator>
        </table>
        <br/>
    </s:iterator>
</s:if>
<s:else>
    <p>No hay pedidos para mostrar.</p>
</s:else>
