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
    
    private List<Categoria> categorias; // Lista de categorías (para visualización)
    private Categoria categoria;        // Objeto categoría (para registrar o eliminar)
    
    public CategoriasAction() {
        // Constructor vacío requerido por Struts
    }

    /**
     * Acción para listar todas las categorías disponibles
     * @return SUCCESS si la operación fue exitosa, ERROR si ocurrió alguna excepción
     */
    public String listar() {
        CategoriaJerseyClient client = new CategoriaJerseyClient(); // Instancia del cliente REST
        try {
            // Define el tipo genérico de respuesta esperada: una lista de categorías
            GenericType<List<Categoria>> genericType = new GenericType<List<Categoria>>() {};
            
            // Llama al servicio REST para obtener todas las categorías
            categorias = client.findAll_XML(genericType);
        } catch (Exception e) {
            e.printStackTrace(); // Imprime cualquier excepción
            return ERROR; // Devuelve ERROR si ocurre un problema
        } finally {
            client.close(); // Asegura que el cliente se cierre siempre
        }
        return SUCCESS; // Operación exitosa
    }

    /**
     * Acción para registrar una nueva categoría mediante el cliente REST
     * @return SUCCESS si se registra correctamente, ERROR si ocurre una excepción
     */
    public String registrar() {
        try {
            CategoriaJerseyClient client = new CategoriaJerseyClient(); // Crea cliente REST
            client.create_XML(categoria); // Envía la nueva categoría en formato XML al servicio
            client.close(); // Cierra el cliente
            return SUCCESS; // Registro exitoso
        } catch (Exception e) {
            e.printStackTrace(); // Imprime error
            return ERROR; // Indica error
        }
    }

    /**
     * Acción para eliminar una categoría
     * @return SUCCESS si se elimina correctamente, ERROR si ocurre una excepción
     */
    public String eliminar() {
        CategoriaJerseyClient client = new CategoriaJerseyClient(); // Cliente REST
        try {
            // Elimina una categoría utilizando su ID (obtenido del objeto `categoria`)
            client.remove(String.valueOf(categoria.getId()));
            client.close();
            return SUCCESS;
        } catch (Exception e) {
            // Agrega mensaje de error al contexto de la acción para mostrarlo en la vista
            addActionError("Error al eliminar categoría: " + e.getMessage());
            return ERROR;
        }
    }

    // Getters y Setters requeridos por Struts2 para el binding de datos

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