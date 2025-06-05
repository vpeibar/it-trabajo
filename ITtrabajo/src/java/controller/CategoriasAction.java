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
    private Categoria categoria;
    
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
    
    public String registrar() {
        try {
            CategoriaJerseyClient client = new CategoriaJerseyClient();
            client.create_XML(categoria);
            client.close();
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }
    
    public String eliminar() {
        CategoriaJerseyClient client = new CategoriaJerseyClient();
        try {
            client.remove(String.valueOf(categoria.getId()));
            client.close();
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Error al eliminar categoria: " + e.getMessage());
            return ERROR;
        }
    }
    
    public List<Categoria> getCategorias() {
        return categorias;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
