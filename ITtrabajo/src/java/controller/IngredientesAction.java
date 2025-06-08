package controller;

import clientes.IngredienteJerseyClient;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import rest.Ingrediente;
import javax.ws.rs.core.Response;

/**
 *
 * @author maria
 */
public class IngredientesAction extends ActionSupport {

    private Ingrediente ingrediente;
    private List<Ingrediente> ingredientes;

    public IngredientesAction() {
        ingrediente = new Ingrediente(); 
    }
    
    public String listar() {
        IngredienteJerseyClient client = new IngredienteJerseyClient();
        try {
            GenericType<List<Ingrediente>> genericType = new GenericType<List<Ingrediente>>() {
            };
            ingredientes = client.findAll_XML(genericType);
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
            IngredienteJerseyClient client = new IngredienteJerseyClient();
            client.create_XML(ingrediente); 
            client.close();
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String eliminar() {
        
        IngredienteJerseyClient client = new IngredienteJerseyClient();
        try {
            client.remove(String.valueOf(ingrediente.getId()));
            client.close();
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Error al eliminar ingrediente: " + e.getMessage());
            return ERROR;
        }
    }
    

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    
    
}
