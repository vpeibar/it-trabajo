
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page session="true" %>
<s:set var="usuario" value="#session.usuarioLogueado" />
<%-- Se guarda el usuario actualmente logueado en la variable 'usuario' a partir de la sesión. --%>

<html>
    <head><title>Panel Cocinero</title></head>
    <body>
        <%-- Se muestra un saludo personalizado con el nombre de usuario del cocinero --%>
        <h1>Bienvenido, <s:property value="#usuario.nombreUsuario" />!</h1>

        <h2>Menú de Cocinero</h2>

        <%-- Formulario para que el cocinero pueda eliminar su cuenta (darse de baja) --%>
        <s:form action="eliminarUsuario" method="delete" 
                onsubmit="return confirm('¿Está seguro de eliminar su cuenta?');">
            <%-- Al hacer clic en el botón, se lanza una ventana de confirmación con JavaScript --%>
            <s:submit value="Darse de baja"/>
            <%-- Botón de envío del formulario con el texto "Darse de baja" --%>
        </s:form>
    </body>
</html>
