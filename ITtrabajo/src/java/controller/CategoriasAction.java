/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import clientes.CategoriaJerseyClient;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import rest.Categoria;

/**
 *
 * @author maria
 */
public class CategoriasAction extends ActionSupport {
    
    private List<Categoria> categorias;
    
    public CategoriasAction() {
    }
    
    public String listar() {
        CategoriaJerseyClient client = new CategoriaJerseyClient();
        try {
            GenericType<List<Categoria>> genericType = new GenericType<List<Categoria>>() {
            };
            categorias = client.findAll_XML(genericType);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        } finally {
            client.close();
        }
        return SUCCESS;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
    
}
