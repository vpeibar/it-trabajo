/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import clientes.ValoracionJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import rest.Valoracion;

/**
 *
 * @author maria
 */
public class ValoracionesAction extends ActionSupport {

    private List<Valoracion> valoraciones;
    private Valoracion valoracion;

    public ValoracionesAction() {
    }

    public String listar() {
        ValoracionJerseyClient client = new ValoracionJerseyClient();
        try {
            GenericType<List<Valoracion>> genericType = new GenericType<List<Valoracion>>() {
            };
            valoraciones = client.findAll_XML(genericType);
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
            ValoracionJerseyClient client = new ValoracionJerseyClient();
            client.create_XML(valoracion); 
            client.close();
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String eliminar() {
        
        ValoracionJerseyClient client = new ValoracionJerseyClient();
        try {
            client.remove(String.valueOf(valoracion.getId()));
            client.close();
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Error al eliminar valoracion: " + e.getMessage());
            return ERROR;
        }
    }

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    

}
