package restful;

import dao.PlatoDAO;
import model.Plato;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/plato")
public class PlatoResource {

    @Context
    private UriInfo context;

    PlatoDAO dao = new PlatoDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Plato> listarPlatos() {
        return dao.listarTodos();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Plato obtenerPlato(@PathParam("id") int id) {
        return dao.obtenerPorId(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearPlato(Plato plato) {
        Plato creado = dao.crear(plato);
        return Response.status(Response.Status.CREATED).entity(creado).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarPlato(@PathParam("id") int id, Plato plato) {
        plato.setId(id);
        boolean actualizado = dao.actualizar(plato);
        return actualizado ? Response.ok(plato).build()
                            : Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarPlato(@PathParam("id") int id) {
        boolean eliminado = dao.eliminar(id);
        return eliminado ? Response.ok().build()
                          : Response.status(Response.Status.NOT_FOUND).build();
    }
}