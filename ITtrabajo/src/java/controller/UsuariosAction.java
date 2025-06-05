/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import clientes.UsuarioJerseyClient;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import rest.Usuario;

/**
 *
 * @author maria
 */
public class UsuariosAction extends ActionSupport {
    private List<Usuario> usuarios;
    
    public UsuariosAction() {
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
