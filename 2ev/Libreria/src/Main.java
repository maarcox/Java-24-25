
public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 1605);
        Libro libro2 = new Libro("1984", "George Orwell", 1949);
        Libro libro3 = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943);

        // Agregar libros a la biblioteca
        Biblioteca.agregarLibro(libro1);
        Biblioteca.agregarLibro(libro2);
        Biblioteca.agregarLibro(libro3);

        // Listar libros
        Biblioteca.listarLibro();

        // Buscar y prestar un libro
        Biblioteca.prestarLibro("1984");
        Biblioteca.listarLibro();

        // Intentar prestar el mismo libro
        Biblioteca.prestarLibro("1984");

        // Devolver el libro
        Biblioteca.devolverLibro("1984");
        Biblioteca.listarLibro();
    }
}