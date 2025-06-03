/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;

import dao.CategoriaDAO;
import java.sql.SQLException;
import java.util.List;
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

/**
 * REST Web Service
 *
 * @author vicky
 */
@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    private CategoriaDAO dao = new CategoriaDAO();

    @GET
    public List<Categoria> listarCategorias() throws SQLException {
        return dao.listar();
    }
    
    @GET
    @Path("/{id}")
    public Categoria obtenerCategoria(@PathParam("id") int id) throws SQLException {
        Categoria c = dao.buscarPorId(id);
        if (c == null) {
            throw new NotFoundException("Categoria no encontrada");
        }
        return c;
    }
    
    @POST
    public Categoria crearCategoria(Categoria categoria) throws SQLException {
        return dao.crear(categoria);
    }

    @PUT
    @Path("/{id}")
    public Categoria actualizarCategoria(@PathParam("id") int id, Categoria categoria) throws SQLException {
        categoria.setId(id);
        boolean exito = dao.actualizar(categoria);
        if (!exito) {
            throw new NotFoundException("Categoria no encontrada para actualizar");
        }
        return categoria;
    }

    @DELETE
    @Path("/{id}")
    public void eliminarCategoria(@PathParam("id") int id) throws SQLException {
        boolean exito = dao.eliminar(id);
        if (!exito) {
            throw new NotFoundException("Categoria no encontrada para eliminar");
        }
    }
}
