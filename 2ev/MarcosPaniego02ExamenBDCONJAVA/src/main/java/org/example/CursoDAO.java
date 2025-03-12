package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CursoDAO {
    private static Connection conn;
    public CursoDAO() {
        this.conn = ConexionPostgre.getInstance().getConnection();
    }

    public List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<>();
        String query = "SELECT c.id_curso, c.nombre_curso, c.descripcion, cat.id_categoria, cat.nombre_categoria " +
                "FROM cursos c JOIN categorias cat ON c.id_categoria = cat.id_categoria";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Categorias categoria = new Categorias(rs.getString("id_categoria"), rs.getString("nombre_categoria"));
                Curso curso = new Curso(rs.getInt("id_curso"), rs.getString("nombre_curso"), rs.getString("descripcion"), categoria);
                cursos.add(curso);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener los cursos: " + e.getMessage());
        }
        return cursos;
    }

    public static List<Curso> findByCategoria(String nombreCategoria) {
        List<Curso> cursos = new ArrayList<>();
        String query = "SELECT c.id_curso, c.nombre_curso, c.descripcion, cat.id_categoria, cat.nombre_categoria " +
                "FROM cursos c " +
                "JOIN categorias cat ON c.id_categoria = cat.id_categoria " +
                "WHERE cat.nombre_categoria ILIKE ? " +
                "ORDER BY c.id_curso ASC";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + nombreCategoria + "%"); // Busca coincidencias parciales en el nombre de la categoría
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Categorias categoria = new Categorias(rs.getString("id_categoria"), rs.getString("nombre_categoria"));
                Curso curso = new Curso(
                        rs.getInt("id_curso"),
                        rs.getString("nombre_curso"),
                        rs.getString("descripcion"),
                        categoria
                );
                cursos.add(curso);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al filtrar los cursos por categoría: " + e.getMessage());
        }
        return cursos;
    }

    public void add(Curso curso) {
        String query = "INSERT INTO cursos (nombre_curso, descripcion, id_categoria) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, curso.getNombre_curso());
            ps.setString(2, curso.getDescripcion());
            ps.setInt(3, curso.getId_categoria());
            ps.executeUpdate();
            System.out.println("✅ Curso agregado: " + curso.getNombre_curso());
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar curso: " + e.getMessage());
        }
    }
    public void update(int idCurso, String nuevoNombre, String nuevaDescripcion, int nuevoIdCategoria) {
        String query = "UPDATE cursos SET nombre_curso = COALESCE(NULLIF(?, ''), nombre_curso), " +
                "descripcion = COALESCE(NULLIF(?, ''), descripcion), " +
                "id_categoria = COALESCE(NULLIF(?, 0), id_categoria) " +
                "WHERE id_curso = ?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, nuevoNombre);
            ps.setString(2, nuevaDescripcion);
            ps.setInt(3, nuevoIdCategoria);
            ps.setInt(4, idCurso);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Curso actualizado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el curso con ID " + idCurso);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar curso: " + e.getMessage());
        }
    }

    public void delete(int idCurso) {
        String query = "DELETE FROM cursos WHERE id_curso = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, idCurso);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Curso eliminado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el curso con ID " + idCurso);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar curso: " + e.getMessage());
        }
    }
}
