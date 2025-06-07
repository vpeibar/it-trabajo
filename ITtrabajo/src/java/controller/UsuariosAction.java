/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import clientes.UsuarioJerseyClient;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import rest.Usuario;

/**
 *
 * @author maria
 */
public class UsuariosAction extends ActionSupport {
    private List<Usuario> usuarios;
    private Usuario usuario;
    private List<String> tipos = Arrays.asList("cliente", "cocinero");
    private String nombreUsuario;
    private String contrasena;
    private Map<String, Object> session;
    
    public UsuariosAction() {
    }
    
    public String login() {
        UsuarioJerseyClient client = new UsuarioJerseyClient();
        usuario = client.login(nombreUsuario, contrasena);

        if (usuario != null) {
            session = ActionContext.getContext().getSession();
            session.put("usuarioLogueado", usuario);
            if ("cliente".equalsIgnoreCase(usuario.getTipo())) {
                return "cliente";
            } else {
                return "cocinero";
            }
        } else {
            addActionError("Usuario o contraseña incorrectos.");
            return ERROR;
        }
    }
    
    public String listar() {
        UsuarioJerseyClient client = new UsuarioJerseyClient();
        try {
            GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>() {};
            usuarios = client.findAll_XML(genericType);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        } finally {
            client.close();
        }
        return SUCCESS;
    }
    
    public String registrar() {
        try {
            UsuarioJerseyClient client = new UsuarioJerseyClient();
            client.create_XML(usuario); 
            client.close();
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
    
    public String eliminar() {
        UsuarioJerseyClient client = new UsuarioJerseyClient();
        try {
            client.remove(String.valueOf(usuario.getId()));
            client.close();
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Error al eliminar usuario: " + e.getMessage());
            return ERROR;
        }
    }

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
