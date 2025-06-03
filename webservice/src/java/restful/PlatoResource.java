/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Plato;

/**
 * REST Web Service
 *
 * @author vicky
 */
@Path("/plato")
public class PlatoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PlatoResource
     */
    public PlatoResource() {
    }

    /**
     * Retrieves representation of an instance of restful.PlatoResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Plato> listar() {
        return DAOPlato.listarTodos();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Plato obtener(@PathParam("id") int id) {
        return DAOPlato.obtenerPorId(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Plato plato) {
        DAOPlato.crear(plato);
        return Response.status(Response.Status.CREATED).entity(plato).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(@PathParam("id") int id, Plato plato) {
        plato.setId(id);
        return DAOPlato.actualizar(plato)
                ? Response.ok(plato).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") int id) {
        return DAOPlato.eliminar(id)
                ? Response.ok().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

}
