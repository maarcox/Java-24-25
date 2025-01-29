package pojo;
public class Pelicula {
    String titulo;
    int año;
    String genero;


    public Pelicula(String titulo, int año, String genero) {
        this.titulo = titulo;
        this.año = año;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", año=" + año +
                ", genero='" + genero + '\'' +
                '}';
    }
}
