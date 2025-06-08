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

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }

    

}
