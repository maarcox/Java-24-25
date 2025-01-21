public class Libro {
    // ATRIBUTOS
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;



    //CONSTRUCTOR

    public  Libro(String titulo, String autor, int anioPublicacion) {
        // initParams(titulo, autor, anioPublicacion, disponible);
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;

    }
    /*public Libro(String titulo) {
        //this.titulo = titulo;
        if(){}
    }*/


    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() {
        this.disponible = false;
    }

    public void devolver() {
        this.disponible = true;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", disponible=" + disponible +
                '}';
    }
}
