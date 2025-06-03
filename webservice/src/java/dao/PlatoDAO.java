package dao;

import java.sql.*;
import java.util.*;
import model.Plato;

public class PlatoDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3307/directoalplato", "", "");
    }

    public List<Plato> listarTodos() {
        List<Plato> platos = new ArrayList<>();
        String sql = "SELECT * FROM plato";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                platos.add(mapear(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return platos;
    }

    public Plato obtenerPorId(int id) {
        String sql = "SELECT * FROM plato WHERE id = ?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapear(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Plato crear(Plato plato) {
        String sql = "INSERT INTO plato (idCocinero, idCategoria, nombre, descripcion, precio, porciones) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, plato.getIdCocinero());
            ps.setInt(2, plato.getIdCategoria());
            ps.setString(3, plato.getNombre());
            ps.setString(4, plato.getDescripcion());
            ps.setDouble(5, plato.getPrecio());
            ps.setInt(6, plato.getPorciones());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                plato.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return plato;
    }

    public boolean actualizar(Plato plato) {
        String sql = "UPDATE plato SET idCocinero=?, idCategoria=?, nombre=?, descripcion=?, precio=?, porciones=? WHERE id=?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, plato.getIdCocinero());
            ps.setInt(2, plato.getIdCategoria());
            ps.setString(3, plato.getNombre());
            ps.setString(4, plato.getDescripcion());
            ps.setDouble(5, plato.getPrecio());
            ps.setInt(6, plato.getPorciones());
            ps.setInt(7, plato.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM plato WHERE id = ?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Plato mapear(ResultSet rs) throws SQLException {
        return new Plato(
            rs.getInt("id"),
            rs.getInt("idCocinero"),
            rs.getInt("idCategoria"),
            rs.getString("nombre"),
            rs.getString("descripcion"),
            rs.getDouble("precio"),
            rs.getInt("porciones")
        );
    }
}
