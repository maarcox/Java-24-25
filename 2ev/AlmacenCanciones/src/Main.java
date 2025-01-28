public class Main {
    public static void main(String[] args) {
        AlmacenMusica almacenMusica1 = new AlmacenMusica("Almacen 1");

        // Añadir canciones
        almacenMusica1.add(new Cancion("Despacito", "Luis Fonsi", 2017));
        almacenMusica1.add(new Cancion("Shape of You", "Ed Sheeran", 2017));
        almacenMusica1.add(new Cancion("Blinding Lights", "The Weeknd", 2019));

        // Imprimir contenido
        almacenMusica1.imprimir();

        // Eliminar una canción
        almacenMusica1.delete(0);

        // Imprimir después de la eliminación
        System.out.println("");
        System.out.println("Después de eliminar:");
        almacenMusica1.imprimir();
    }
}
