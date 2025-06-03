package restful;

import dao.PedidoDAO;
import model.Pedido;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/pedido")
public class PedidoResource {

    @Context
    private UriInfo context;

    PedidoDAO dao = new PedidoDAO();

    @GET
    @Path("/cliente/{idCliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedido> getPedidosPorCliente(@PathParam("idCliente") int idCliente) {
        return dao.obtenerPorCliente(idCliente);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pedido getPedido(@PathParam("id") int id) {
        return dao.obtenerPorId(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearPedido(Pedido pedido) {
        boolean exito = dao.crear(pedido);
        return exito ? Response.status(Response.Status.CREATED).entity(pedido).build()
                     : Response.status(Response.Status.BAD_REQUEST).build();
    }
}
