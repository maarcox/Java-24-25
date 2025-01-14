import java.util.Arrays;
import java.util.Scanner;

public class Inventario {
    private int numProductos;
    private int contador = 0;
    private Producto[] lstinventario;

    public Inventario(int numProductos){
        this.numProductos = numProductos;
        lstinventario = new Producto[numProductos];
    }
    public void agregarProductoInventario(Producto producto){
        this.lstinventario[contador] = producto;
        contador ++;
    }
    public void mostrarInventario(){
        System.out.println();
        System.out.println("INVENTARIO: ");
        for (int i = 0; i < lstinventario.length; i++) {
            System.out.println(lstinventario[i]);
        }

    }

    public void buscarProductoPorNombre(){
        Scanner lector = new Scanner(System.in);
        String nombre;
        do {
            System.out.println();
            System.out.println("Escriba Producto a buscar: ");
            nombre = lector.nextLine();


            for (Producto producto : lstinventario) {
                if ( producto.getNombre().equals(nombre)) {
                        System.out.println(producto);
                }
            }

        }while (nombre != "0");

    }
}
