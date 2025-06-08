

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <%-- Define el tipo de contenido del documento y la codificación de caracteres --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar usuario</title>
        <%-- Título que aparece en la pestaña del navegador --%>
    </head>
    
    <body>
        <h1>Registrar usuario</h1>
        <%-- Encabezado principal de la página --%>

        <%-- Formulario que enviará los datos a la acción "registrarUsuario" mediante el método POST --%>
        <s:form action="registrarUsuario" method="post">

            <%-- Campo de texto para el nombre de usuario --%>
            <s:textfield name="usuario.nombreUsuario" label="Nombre de usuario" />

            <%-- Campo de contraseña --%>
            <s:password name="usuario.contrasena" label="Contraseña"/>

            <%-- Campo de texto para el nombre personal del usuario --%>
            <s:textfield name="usuario.nombre" label="Nombre" />

            <%-- Campo de texto para los apellidos --%>
            <s:textfield name="usuario.apellidos" label="Apellidos" />

            <%-- Campo de texto para el DNI del usuario --%>
            <s:textfield name="usuario.dni" label="DNI" />

            <%-- Campo de texto para el número de teléfono --%>
            <s:textfield name="usuario.telefono" label="Teléfono" />

            <%-- Campo de texto para la dirección del usuario --%>
            <s:textfield name="usuario.direccion" label="Dirección" />

            <%-- Menú desplegable para seleccionar el tipo de usuario (por ejemplo, "cliente" o "cocinero") --%>
            <%-- La lista "tipos" debe estar precargada desde el Action con las opciones disponibles --%>
            <s:select name="usuario.tipo" label="Tipo" list="tipos" headerValue="Seleccionar"></s:select>

            <%-- Botón de envío del formulario que crea el usuario --%>
            <s:submit value="Registrar" />
        </s:form>
    </body>
</html>