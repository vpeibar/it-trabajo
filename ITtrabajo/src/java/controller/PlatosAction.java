/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import clientes.PlatoJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import rest.Plato;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import org.apache.struts2.interceptor.SessionAware;
import rest.Usuario;

/**
 *
 * @author maria
 */
public class PlatosAction extends ActionSupport implements SessionAware {

    private List<Plato> platos;
    private Map<String, Object> session;

    public PlatosAction() {
    }

    public String listar() {
        PlatoJerseyClient client = new PlatoJerseyClient();
        try {
            GenericType<List<Plato>> genericType = new GenericType<List<Plato>>() {
            };
            platos = client.findAll_XML(genericType);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        } finally {
            client.close();
        }
        return SUCCESS;
    }

    /* public String eliminar() {
        Usuario usuario = (Usuario) session.get("usuarioLogueado");
        if (usuario != null) {
            PlatoJerseyClient client = new PlatoJerseyClient();
            Plato plato = findById(idPlato);
            client.remove(String.valueOf(usuario.getId()));
            client.close();
            return SUCCESS;
        } else {
            return ERROR;
        }
    }*/
    public List<Plato> getPlatos() {
        return platos;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
