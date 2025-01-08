import java.util.Random;
import java.util.Scanner;


public class Main {
    Random aleatorio = new Random();
    static private String arrayPrimitiva[] = new String[6];

    //Darles numeros aleatorios a la array
    private static void DarNumerosAleatorios(){
        Random aleatorio = new Random();
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            int numAle = aleatorio.nextInt(100);
            arrayPrimitiva[i] = String.valueOf(numAle);
        }
    }
    //leerrespuestausuario--------------------------------------------------
    private static void cadusuario(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Dame un numero: ");
        String cadUsuario = leer.nextLine();
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if(cadUsuario.equals(arrayPrimitiva[i])) {
                arrayPrimitiva[i] = "X";
            }
        }
    }

    //imprimir -------------------------------------------------------------
    private static void imprimir(){
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            System.out.print(" ["+arrayPrimitiva[i]+ "] ");
        }
    }
    //primitiva
    public static void main(String[] args) {
        DarNumerosAleatorios();
        imprimir();
        System.out.println(" ");
        cadusuario();
        cadusuario();
        cadusuario();
        System.out.println("Acertaste Los Siguientes numeros: ");
        imprimir();
        //FIn
    }
}