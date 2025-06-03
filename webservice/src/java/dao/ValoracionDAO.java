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
import model.Valoracion;

/**
 *
 * @author maria
 */
public class ValoracionDAO {
        private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3307/directoalplato", "", "");
    }

    public List<Valoracion> listar() throws SQLException {
        List<Valoracion> valoraciones = new ArrayList<>();
        String sql = "SELECT * FROM valoracion";
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                valoraciones.add(mapear(rs));
            }
        }
        return valoraciones;
    }

    public Valoracion buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM valoracion WHERE id = ?";
        try (Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return mapear(rs);
        }
        return null;
    }

    public Valoracion crear(Valoracion valoracion) throws SQLException {
        String sql = "INSERT INTO valoracion (pedido_id, puntuacion, comentario, fecha, usuario_id) " + "VALUES (?, ?, ?, ?, ?)";
        try (Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, valoracion.getIdPedido());
            ps.setInt(2, valoracion.getPuntuacion());
            ps.setString(3, valoracion.getComentario());
            ps.setDate(4, (java.sql.Date)valoracion.getFecha());
            ps.setInt(5, valoracion.getIdUsuario());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                valoracion.setId(rs.getInt(1));
            }
        }
        return valoracion;
    }

    public boolean actualizar(Valoracion valoracion) throws SQLException {
        String sql = "UPDATE valoracion SET pedido_id=?, puntuacion=?, comentario=?, fecha=?, usuario_id=? WHERE id=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, valoracion.getIdPedido());
            ps.setInt(2, valoracion.getPuntuacion());
            ps.setString(3, valoracion.getComentario());
            ps.setDate(4, (java.sql.Date) valoracion.getFecha());
            ps.setInt(5, valoracion.getIdUsuario());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM valoracion WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    private Valoracion mapear(ResultSet rs) throws SQLException {
        return new Valoracion(
            rs.getInt("id"),
            rs.getInt("usuario_id"),
            rs.getInt("pedido_id"),
            rs.getInt("puntuacion"),
            rs.getString("comentario"),
            rs.getDate("fecha")
        );
    }
}
