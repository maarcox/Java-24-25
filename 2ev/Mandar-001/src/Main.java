
public class Main {
    public static void main(String[] args) {
        AlmacenMusica almacenMusica = new AlmacenMusica();

        System.out.println("LISTA CANCIONES: ");
        almacenMusica.addCancion(new Cancion(1, "Teteo"));
        almacenMusica.addCancion(new Cancion(2, "Drakukeo"));
        almacenMusica.printCanciones();

        System.out.println();
        // Actualizar canción
        System.out.println("Actualizamos cancion id 1 ");
        almacenMusica.updateCancion(1, "Morfina");

        // Eliminar canción
        System.out.println("Borramos cancion titulo Drakukeo");
        almacenMusica.deleteCancion("Drakukeo");


        System.out.println();
        // Imprimir canciones
        System.out.println("LISTA CANCIONES: ");
        almacenMusica.printCanciones();
    }
}