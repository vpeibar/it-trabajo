/*
 * Clase de acción para gestionar usuarios en una aplicación Struts2.
 * Permite login, registro, listado y eliminación de usuarios.
 */

package controller;

import clientes.UsuarioJerseyClient; // Cliente REST para acceder a los servicios de usuarios
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import org.apache.struts2.interceptor.SessionAware; // Permite manejar sesión en Struts2
import rest.Usuario; // Modelo Usuario que se comunica con el backend REST

public class UsuariosAction extends ActionSupport implements SessionAware {

    // Lista de todos los usuarios (para administración o pruebas)
    private List<Usuario> usuarios;

    // Objeto usuario para uso individual (registro, login, etc.)
    private Usuario usuario;

    // Lista de tipos posibles de usuario: cliente o cocinero (para el desplegable en el formulario)
    private List<String> tipos = Arrays.asList("cliente", "cocinero");

    // Datos introducidos por el usuario en el login
    private String nombreUsuario;
    private String contrasena;

    // Mapa que representa la sesión HTTP del usuario
    private Map<String, Object> session;

    public UsuariosAction() {
        // Constructor vacío por defecto
    }

    // Acción que gestiona el login de usuarios
    public String login() {
        UsuarioJerseyClient client = new UsuarioJerseyClient();
        
        // Se llama al backend para autenticar al usuario
        usuario = client.login(nombreUsuario, contrasena);

        if (usuario != null) {
            // Si el login es exitoso, se guarda el usuario en sesión
            session = ActionContext.getContext().getSession();
            session.put("usuarioLogueado", usuario);

            // Se redirige a la vista correspondiente según el tipo de usuario
            if ("cliente".equalsIgnoreCase(usuario.getTipo())) {
                return "cliente"; // Redirige a panelCliente.jsp
            } else {
                return "cocinero"; // Redirige a panelCocinero.jsp
            }
        } else {
            // Si el login falla, se muestra un mensaje de error
            addActionError("Usuario o contraseña incorrectos.");
            return ERROR;
        }
    }

    // Acción que obtiene la lista completa de usuarios desde el backend REST
    public String listar() {
        UsuarioJerseyClient client = new UsuarioJerseyClient();
        try {
            // Se usa GenericType para obtener una lista tipada correctamente
            GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>() {};
            usuarios = client.findAll_XML(genericType); // Llama al servicio REST
        } catch (Exception e) {
            e.printStackTrace(); // Muestra error por consola (para depuración)
            return ERROR;
        } finally {
            client.close(); // Cierra el cliente REST
        }
        return SUCCESS;
    }

    // Acción que registra un nuevo usuario
    public String registrar() {
        try {
            UsuarioJerseyClient client = new UsuarioJerseyClient();
            client.create_XML(usuario); // Llama al backend REST para registrar el usuario
            client.close();
            return SUCCESS; // Redirige al mensaje o vista de éxito
        } catch (Exception e) {
            e.printStackTrace(); // En caso de error, lo imprime y devuelve ERROR
            return ERROR;
        }
    }

    // Acción que elimina al usuario actualmente logueado
    public String eliminar() {
        Usuario usuario = (Usuario) session.get("usuarioLogueado");
        if (usuario != null) {
            UsuarioJerseyClient client = new UsuarioJerseyClient();
            client.remove(String.valueOf(usuario.getId())); // Se elimina usando su ID
            client.close();
            return SUCCESS;
        } else {
            return ERROR; // No hay usuario en sesión, se devuelve error
        }
    }

    // Métodos getter y setter requeridos por Struts2 para inyectar datos

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
