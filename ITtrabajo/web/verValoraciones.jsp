<%-- 
    Document   : verValoraciones
    Created on : 02-jun-2025, 20:18:39
    Author     : maria
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head><title>Valoraciones Recibidas</title></head>
    <body>
        <h2>Valoraciones Recibidas</h2>

    <s:iterator value="valoraciones">
        <div style="border:1px solid #ccc; margin:10px; padding:10px;">
            <p><strong>Puntuación:</strong> <s:property value="puntuacion"/></p>
            <p><strong>Comentario:</strong> <s:property value="comentario"/></p>
            <p><strong>Fecha:</strong> <s:property value="fecha"/></p>
        </div>
    </s:iterator>

</body>
</html>

