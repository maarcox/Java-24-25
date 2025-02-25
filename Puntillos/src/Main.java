import Figuras.Figuras;


public class Main {
    public static void main(String[] args) {
        // Crear figuras
        Figuras punto1 = new punto("1, 2");
        Figuras triangulo1 = new triangulo("1, 2, 3");
        Figuras cuadrado1 = new cuadrado("1, 2, 3, 4");

        //agregar figuras
        AlmacenarFiguras gestor = new AlmacenarFiguras();
        gestor.agregarFigura(punto1);
        gestor.agregarFigura(triangulo1);
        gestor.agregarFigura(cuadrado1);

        // Imprimir figuras
        ImpresoraFiguras impresora = new ImpresoraFiguras();
        impresora.imprimirFiguras(gestor.obtenerFiguras());

    }
}