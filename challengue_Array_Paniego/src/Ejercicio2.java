import java.util.Random;
import java.util.Scanner;
//Ejercicio2
//Primitiva
//array de  6 pedir numero si existe se tacha con una x
public class Ejercicio2 {
    private static final int numeros = 6;
    private static final int array[] = new int[numeros];
    private static final char array2[] = new char[6];
    private static Random aleatorio = new Random(); //decimos que la variable aleatorio sera random

    private static void creararray(){
        for (int i = 0; i < numeros; i++) {
            array[i] = aleatorio.nextInt(9);
        }

    }

    private static void mostrararray(){
        for (int i = 0; i < numeros; i++) {
            System.out.print(array[i]+" ");
        }
    }


    //progama--------------------------------------------------------------------
    public static void main(String[] args) {
        creararray();
        mostrararray();
        Scanner lector = new Scanner(System.in);
        System.out.print("Dime un numero");
        int  leernumero = lector.nextInt();
        for (int i = 0; i < numeros; i++) {
            if (leernumero == array[i]){
                array2[i] = 'x';
            }
        }
            for (int i = 0; i < numeros; i++) {
                if (leernumero == array[i]){
                    System.out.println("["+ array[i] + array2[i]+"]");
                }
            }

        //fin------------------------------------------------------------------------
    }
}
