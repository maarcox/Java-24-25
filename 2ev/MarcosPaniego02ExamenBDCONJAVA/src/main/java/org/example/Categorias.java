package org.example;
import java.util.ArrayList;
public class Categorias {
    private String id_categoria;
    private String nombre_categoria;

    public Categorias(String id_categoria, String nombre_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }
}
