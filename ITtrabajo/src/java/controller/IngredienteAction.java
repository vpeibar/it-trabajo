package controller;

import clientes.IngredienteJerseyClient;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import rest.Ingrediente;
import javax.ws.rs.core.Response;

/**
 *
 * @author maria
 */
public class IngredienteAction extends ActionSupport {

    private Ingrediente ingrediente;

    public IngredienteAction() {
        ingrediente = new Ingrediente(); 
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
}
