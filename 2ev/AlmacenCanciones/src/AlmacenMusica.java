import java.util.ArrayList;

public class AlmacenMusica {
    String nombreAlmacen;
    ArrayList<Cancion> canciones;
    public AlmacenMusica(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
        this.canciones = new ArrayList<>();
    }

    // Agregar canción
    public void add(Cancion cancion) {
        canciones.add(cancion);
    }

    // Eliminar canción
    public void delete(int numero) {
        canciones.remove(numero);
    }

    // Imprimir canciones
    public void imprimir() {
        System.out.println("Almacen: " + nombreAlmacen);
        System.out.println("Canciones:");
        for (Cancion cancion : canciones) {
            System.out.println(cancion.nombreCancion + " - " + cancion.cantante + " (" + cancion.año + ")");
        }
    }
}

