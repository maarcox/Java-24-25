public class Main {
    public static void main(String[] args) {
        Cartelera cartelera = new Cartelera();

        // Añadir películas
        cartelera.anadirPelicula("Cenicienta");
        cartelera.anadirPelicula("Avengers");
        cartelera.anadirPelicula("PacMan");
        cartelera.anadirPelicula("Los Feos");
        cartelera.anadirPelicula("Spiderman");
        cartelera.anadirPelicula("Caperucita Roja");



        System.out.println("CARTELERA CINE: ");
        cartelera.imprimirCartelera();  // Imprimir todas las películas
        System.out.println(); //Espacio

        // Buscar una película
        System.out.println("Buscando Avengers: " + cartelera.buscarPelicula("Avengers"));
        System.out.println("Buscando Batman: " + cartelera.buscarPelicula("Batman"));
        System.out.println(); //Espacio

        // Eliminar una película
        System.out.println("Eliminando PacMan: " + cartelera.eliminarPelicula("PacMan"));
        System.out.println(); //Espacio

        // Imprimir cartelera después de la eliminación
        System.out.println("CARTELERA CINE después de eliminación:");
        cartelera.imprimirCartelera();
    }
}

