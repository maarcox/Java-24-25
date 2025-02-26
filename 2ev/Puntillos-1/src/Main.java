// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Punto P1 = new Punto();
        P1.setX(4);
        P1.setY(5);
        System.out.println(P1);

        Triangulo T1 = new Triangulo();
        T1.setX(P1.getX());
        T1.setY(P1.getY());
        T1.setZ(6);
        System.out.println(T1);

        Cuadrado C1 = new Cuadrado();
        C1.setX(4);
        C1.setY(5);
        C1.setZ(6);
        C1.setV(7);
        System.out.println(C1);



    }
}