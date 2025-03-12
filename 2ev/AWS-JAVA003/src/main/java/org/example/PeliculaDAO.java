package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO implements DAO<Pelicula> {
    private Connection conn;

    public PeliculaDAO() {
        this.conn = ConexionPostgre.getInstance().getConnection();
    }

    @Override
    public void add(Pelicula pelicula) {
        String query = "INSERT INTO peliculas (titulo, director, anio) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setInt(3, pelicula.getAnio());
            ps.executeUpdate();
            System.out.println("✅ Película agregada: " + pelicula.getTitulo());
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar película: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM peliculas WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ Película eliminada (ID: " + id + ")");
            } else {
                System.out.println("⚠ No se encontró la película con ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar película: " + e.getMessage());
        }
    }

    @Override
    public void update(Pelicula pelicula) {
        String query = "UPDATE peliculas SET titulo = ?, director = ?, anio = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setInt(3, pelicula.getAnio());
            ps.setInt(4, pelicula.getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ Película actualizada: " + pelicula.getTitulo());
            } else {
                System.out.println("⚠ No se encontró la película con ID: " + pelicula.getId());
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar película: " + e.getMessage());
        }
    }

    @Override
    public Pelicula find(int id) {
        String query = "SELECT * FROM peliculas WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("anio")
                );
            } else {
                System.out.println("⚠ No se encontró la película con ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar película: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Pelicula> findAnio(int anio) {
        List<Pelicula> peliculas = new ArrayList<>();
        String query = "SELECT * FROM peliculas WHERE anio = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, anio);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                peliculas.add(new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("anio")
                ));
            }
            if (peliculas.isEmpty()) {
                System.out.println("⚠ No se encontraron películas del año: " + anio);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar películas por año: " + e.getMessage());
        }
        return peliculas;
    }


    @Override
    public List<Pelicula> findAll() {
        List<Pelicula> peliculas = new ArrayList<>();
        String query = "SELECT * FROM peliculas ORDER BY id ASC";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                peliculas.add(new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("anio")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener todas las películas: " + e.getMessage());
        }
        return peliculas;
    }




}

