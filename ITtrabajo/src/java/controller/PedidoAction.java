package controller;

import clientes.PedidoJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import rest.Pedido;
import rest.Usuario;

import static com.opensymphony.xwork2.Action.SUCCESS;
import static com.opensymphony.xwork2.Action.ERROR;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.SessionAware;

/**
 * Action para gestionar pedidos.
 */
public class PedidoAction extends ActionSupport implements SessionAware {

    private Pedido pedido;
    private List<Pedido> pedidos;
    private String mensaje;
    private int id;
    private Map<String, Object> session;

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

    public String listarEstado() {
        PedidoJerseyClient client = new PedidoJerseyClient();
        String tipo = (String) ActionContext.getContext().getSession().get("tipo");

        try {
            if ("cliente".equals(tipo)) {
                int clienteId = (Integer) ActionContext.getContext().getSession().get("usuarioId");
                pedidos = client.findByCliente_JSON(List.class, String.valueOf(clienteId));
            } else if ("cocinero".equals(tipo)) {
                pedidos = client.findPendientes_JSON(List.class);
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        } finally {
            client.close();
        }
    }

    public String listarPorCliente() {
        PedidoJerseyClient client = new PedidoJerseyClient();
        try {
            Usuario usuario = (Usuario) session.get("usuario");

            if (usuario == null) {
                mensaje = "Usuario no autenticado.";
                return ERROR;
            }

            if ("cocinero".equals(usuario.getTipo())) {
                pedidos = client.findAll_JSON(List.class); // Asegúrate que esto devuelve una lista correctamente
            } else {
                pedidos = client.findByCliente_JSON(List.class, String.valueOf(usuario.getId()));
            }

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            mensaje = "Error al listar pedidos.";
            return ERROR;
        } finally {
            client.close();
        }
    }

    public String execute() {
        PedidoJerseyClient client = new PedidoJerseyClient();
        try {
            pedido = client.find_JSON(Pedido.class, String.valueOf(id));
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        } finally {
            client.close();
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
