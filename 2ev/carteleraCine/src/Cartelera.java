public class Cartelera {
    Pelicula primera;  // La primera película de la lista

    public Cartelera() {
        primera = null;
    }

    // Método para añadir una película al final
    public void anadirPelicula(String titulo) {
        Pelicula nuevaPelicula = new Pelicula(titulo, null);
        if (primera == null) {
            primera = nuevaPelicula;  // Si la lista está vacía, la nueva película es la primera
        } else {
            Pelicula actual = primera;
            while (actual.siguiente != null) {
                actual = actual.siguiente;  // Llegamos al final de la lista
            }
            actual.siguiente = nuevaPelicula;  // Añadimos la nueva película al final
        }
    }

    // Método para eliminar una película por su título
    public boolean eliminarPelicula(String titulo) {
        if (primera == null) {
            return false;  // Si la lista está vacía, no se puede eliminar
        }

        // Si la primera película tiene el título a eliminar
        if (primera.titulo.equals(titulo)) {
            primera = primera.siguiente;
            return true;
        }

        Pelicula actual = primera;
        while (actual.siguiente != null) {
            if (actual.siguiente.titulo.equals(titulo)) {
                actual.siguiente = actual.siguiente.siguiente;  // Elimina la película
                return true;
            }
            actual = actual.siguiente;
        }

        return false;  // Si no se encuentra la película, no se elimina
    }

    // Método para buscar una película por su título
    public boolean buscarPelicula(String titulo) {
        Pelicula actual = primera;
        while (actual != null) {
            if (actual.titulo.equals(titulo)) {
                return true;  // Se encontró la película
            }
            actual = actual.siguiente;
        }
        return false;  // No se encontró la película
    }

    // Método para imprimir todas las películas de la cartelera
    public void imprimirCartelera() {
        if (primera == null) {
            System.out.println("La cartelera está vacía.");
            return;
        }

        Pelicula actual = primera;
        while (actual != null) {
            System.out.println(actual.titulo);
            actual = actual.siguiente;
        }
    }
}

