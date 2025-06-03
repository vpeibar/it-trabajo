/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;

import dao.ValoracionDAO;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Categoria;
import model.Valoracion;

/**
 * REST Web Service
 *
 * @author vicky
 */
@Path("/valoraciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ValoracionResource {

    private ValoracionDAO dao = new ValoracionDAO();

    @GET
    public List<Valoracion> listarCategorias() throws SQLException {
        return dao.listar();
    }
    
    @GET
    @Path("/{id}")
    public Valoracion obtenerValoracion(@PathParam("id") int id) throws SQLException {
        Valoracion v = dao.buscarPorId(id);
        if (v == null) {
            throw new NotFoundException("Valoracion no encontrada");
        }
        return v;
    }
    
    @POST
    public Valoracion crearValoracion(Valoracion valoracion) throws SQLException {
        return dao.crear(valoracion);
    }

    @PUT
    @Path("/{id}")
    public Valoracion actualizarValoracion(@PathParam("id") int id, Valoracion valoracion) throws SQLException {
        valoracion.setId(id);
        boolean exito = dao.actualizar(valoracion);
        if (!exito) {
            throw new NotFoundException("Valoracion no encontrada para actualizar");
        }
        return valoracion;
    }

    @DELETE
    @Path("/{id}")
    public void eliminarValoracion(@PathParam("id") int id) throws SQLException {
        boolean exito = dao.eliminar(id);
        if (!exito) {
            throw new NotFoundException("Valoracion no encontrada para eliminar");
        }
    }
}
