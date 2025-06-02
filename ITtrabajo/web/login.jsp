<%-- 
    Document   : login
    Created on : 02-jun-2025, 20:16:46
    Author     : maria
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head><title>Login</title></head>
    <body>
        <h2>Iniciar sesión</h2>

    <s:form action="login">
        <s:textfield name="usuario.nombreUsuario" label="Usuario"/>
        <s:password name="usuario.contrasena" label="Contraseña"/>
        <s:submit value="Entrar"/>
    </s:form>

    <s:property value="mensaje"/>
</body>
</html>

