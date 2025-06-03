/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author maria
 */
public class UsuarioDAO {
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3307/directoalplato", "root", "");
    }

    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                usuarios.add(mapear(rs));
            }
        }
        return usuarios;
    }

    public Usuario buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return mapear(rs);
        }
        return null;
    }

    public Usuario crear(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nombre, apellidos, telefono, dni, nombreUsuario, contrasena, tipo, direccion) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getDni());
            ps.setString(5, usuario.getNombreUsuario());
            ps.setString(6, usuario.getContrasena());
            ps.setString(7, usuario.getTipo());
            ps.setString(8, usuario.getDireccion());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                usuario.setId(rs.getInt(1));
            }
        }
        return usuario;
    }

    public boolean actualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nombre=?, apellidos=?, telefono=?, dni=?, nombreUsuario=?, contrasena=?, tipo=?, direccion=? WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getDni());
            ps.setString(5, usuario.getNombreUsuario());
            ps.setString(6, usuario.getContrasena());
            ps.setString(7, usuario.getTipo());
            ps.setString(8, usuario.getDireccion());
            ps.setLong(9, usuario.getId());

            return ps.executeUpdate() > 0;
        }
        
    }

    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    private Usuario mapear(ResultSet rs) throws SQLException {
        return new Usuario(
            rs.getInt("id"),
            rs.getString("nombre"),
            rs.getString("apellidos"),
            rs.getString("telefono"),
            rs.getString("dni"),
            rs.getString("nombreUsuario"),
            rs.getString("contrasena"),
            rs.getString("tipo"),
            rs.getString("direccion")
        );
    }
    
}
