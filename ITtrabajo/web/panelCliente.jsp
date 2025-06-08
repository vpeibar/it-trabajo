
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page session="true" %>
<s:set var="usuario" value="#session.usuarioLogueado" />
<%-- Se extrae el usuario logueado de la sesión y se guarda en la variable 'usuario' --%>

<html>
    <head><title>Panel Cliente</title></head>
    <body>
        <%-- Mensaje de bienvenida con el nombre de usuario del cliente --%>
        <h1>Bienvenido, <s:property value="#usuario.nombreUsuario" />!</h1>

        <h2>Menú de Cliente</h2>

        <%-- Formulario para ver la lista de platos disponibles --%>
        <s:form action="listarPlatos">
            <s:submit value="Ver Platos"/>
        </s:form>

        <%-- Formulario para eliminar la cuenta del usuario (darse de baja) --%>
        <s:form action="eliminarUsuario" method="delete" 
                onsubmit="return confirm('¿Está seguro de eliminar su cuenta?');">
            <%-- El atributo 'onsubmit' lanza una ventana de confirmación antes de enviar el formulario --%>
            <s:submit value="Darse de baja"/>
        </s:form>
    </body>
</html>

