public class Biblioteca {
    private static final int CAPACIDAD = 10;
    private static Libro[] libros = new Libro[CAPACIDAD];
    private static int contadorLibros = 0;

    public static void agregarLibro(Libro libro){
        if(contadorLibros < CAPACIDAD){
            libros[contadorLibros] = libro;
            contadorLibros++;
            System.out.println("CON ESPACIO");
        }else{
            System.out.println("SIN ESPACIO");
        }
    }
    public static void listarLibro(){
        // For normal
        // Foreach para Objetos

        for (int i = 0; i < contadorLibros; i++) {
          Libro libro = libros[i];
        }
    }
    public static Libro buscarLibro(String titulo){
        for (Libro libro: libros) {
            if(libro.getTitulo().equals(titulo)){
                return libro;
            }
        }
        return null;
    }
    public static void prestarLibro(String titulo) {
        Libro libro = buscarLibro(titulo);
        if (libro != null && libro.isDisponible()) {
            libro.prestar();
            System.out.println("El libro " + titulo + " ha sido prestado.");
        } else {
            System.out.println("El libro " + titulo + " no está disponible.");
        }
    }
    public static void devolverLibro(String titulo){
            Libro libro = buscarLibro(titulo);
            if (libro != null && !libro.isDisponible()) {
                libro.devolver();
                System.out.println("El libro " + titulo + " ha sido devuelto.");
            } else {
                System.out.println("El libro " + titulo + " no se encuentra prestado.");
            }
    }
}

