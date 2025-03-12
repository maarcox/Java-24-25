package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CursoDAO {
    private static Connection conn;
    public CursoDAO() {
        this.conn = ConexionPostgre.getInstance().getConnection();
    }



    public static List<Curso> findAll() {
        List<Curso> peliculas = new ArrayList<>();
        String query = "SELECT * FROM cursos ORDER BY id_curso ASC";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                peliculas.add(new Curso(
                        rs.getInt("id_curso"),
                        rs.getString("nombre_curso"),
                        rs.getString("descripcion"),
                        rs.getInt("id_categoria")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al obtener todas las películas: " + e.getMessage());
        }
        return peliculas;
    }
}
