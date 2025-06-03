/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;

import dao.UsuarioDAO;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author maria
 */
import model.Usuario;

import java.util.*;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private UsuarioDAO dao = new UsuarioDAO();
    
    @GET
    public List<Usuario> listarUsuarios() throws SQLException {
        return dao.listar();
    }

    @GET
    @Path("/{id}")
    public Usuario obtenerUsuario(@PathParam("id") int id) throws SQLException {
        Usuario u = dao.buscarPorId(id);
        if (u == null) {
            throw new NotFoundException("Usuario no encontrado");
        }
        return u;
    }

    @POST
    public Usuario crearUsuario(Usuario usuario) throws SQLException {
        return dao.crear(usuario);
    }

    @PUT
    @Path("/{id}")
    public Usuario actualizarUsuario(@PathParam("id") int id, Usuario usuario) throws SQLException {
        usuario.setId(id);
        boolean exito = dao.actualizar(usuario);
        if (!exito) {
            throw new NotFoundException("Usuario no encontrado para actualizar");
        }
        return usuario;
    }

    @DELETE
    @Path("/{id}")
    public void eliminarUsuario(@PathParam("id") int id) throws SQLException {
        boolean exito = dao.eliminar(id);
        if (!exito) {
            throw new NotFoundException("Usuario no encontrado para eliminar");
        }
    }
}
