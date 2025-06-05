package controller;

import clientes.PedidoJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import rest.Pedido;

import static com.opensymphony.xwork2.Action.SUCCESS;
import static com.opensymphony.xwork2.Action.ERROR;

/**
 * Action para crear un nuevo pedido usando el cliente REST.
 */
public class PedidoAction extends ActionSupport {
    
    private Pedido pedido;
    private String mensaje;

    public PedidoAction() {
    }

    public String crear() {
        PedidoJerseyClient client = new PedidoJerseyClient();
        try {
            client.create_JSON(pedido);
            mensaje = "Pedido creado correctamente.";
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            mensaje = "Error al crear el pedido.";
            return ERROR;
        } finally {
            client.close();
        }
    }

    // Getters y setters
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
