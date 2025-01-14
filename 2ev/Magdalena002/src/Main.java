import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Ejercicio A traves de un MAIN
        Producto magdalena = new Producto("Magdalena de chocolate", 1.50, 10);
        Producto croisant = new Producto("Croisant de chocolate", 2.00, 20);
        Producto cafe = new Producto("Cafe solo", 1.00, 10);
        System.out.println(magdalena.getNombre());
        magdalena.setStock(25);
        System.out.println(magdalena.toString());
        System.out.println(croisant.toString());
        System.out.println(cafe.toString());

        System.out.println();
        Pedido pedido = new Pedido(5);
            pedido.agregarProducto(magdalena, 3);
            pedido.agregarProducto(croisant, 5);
            pedido.agregarProducto(cafe, 6);
            pedido.agregarProducto(magdalena,12);
            pedido.agregarProducto(croisant, 5);
            pedido.imprimirTicket();

        //INVENTARIO
        Inventario inventario = new Inventario(3); //Cantidad productos inventario
        inventario.agregarProductoInventario(magdalena);
        inventario.agregarProductoInventario(croisant);
        inventario.agregarProductoInventario(cafe);
        inventario.mostrarInventario();

        inventario.buscarProductoPorNombre();



    }

}