//Ejercicio 1
//Array de 2 dimensiones con numeros aleatorios
import java.util.Random;
public class Ejercicio1 {
    private static final int filaArray = 10;
    private static final int columnaArray = 10;
    private static final int array[][] = new int[filaArray][columnaArray]; //declarar dimension array
    private static Random aleatorio = new Random(); //decimos que la variable aleatorio sera random
    // --------------------------------------------------------------------------
    private static void crearArray(){ //creamos el array
        for (int i = 0; i < filaArray; i++) {
            for (int j = 0; j < columnaArray; j++) {
                array[i][j] = aleatorio.nextInt(9) + 1; //le decimos que los numeros del array seran aleatorios del 1 al 9
            }

        }
    }
    private static void mostrarArray(){  //aqui mostramos en array
        for (int i = 0; i < filaArray; i++) {
            for (int j = 0; j < columnaArray; j++) {
                System.out.print(array[i][j]+ " ");
            }
            System.out.println(" ");
        }
    }

    //progama--------------------------------------------------------------------
    public static void main(String[] args) {
        crearArray();
        mostrarArray();

        //fin------------------------------------------------------------------------
    }
}


