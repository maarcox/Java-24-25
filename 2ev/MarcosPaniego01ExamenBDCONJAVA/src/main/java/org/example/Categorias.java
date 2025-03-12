package org.example;
import java.util.ArrayList;
public class Categorias {
    private String id_categoria;
    private String nombre_categoria;

    //traer y guardar generos desde la base de datos
    private ArrayList<Curso> pelicula = new ArrayList();

    public Categorias(String id_categoria, String nombre_categoria){
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
    }
}
