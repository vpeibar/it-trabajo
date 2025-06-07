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
import javax.ws.rs.core.GenericType;

/**
 *
 * @author maria
 */
public class PlatosAction extends ActionSupport {
    
    private List<Plato> platos;

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

    public List<Plato> getPlatos() {
        return platos;
    }

}
