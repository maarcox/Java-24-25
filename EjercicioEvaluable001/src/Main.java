import java.util.Random;
import java.util.Scanner;

public class Main {
    //2 tableros
    //10 x 10
    private static final int filaTablero = 10;
    private static final int columnaTablero = 10;
    private static String tableroN [][];

    Random aleatorio = new Random();
    static private String arrayPrimitiva[] = new String[6];



    private static void inicializarTableroN(){
        Random aleatorio = new Random();
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                int numeros = aleatorio.nextInt(89 )+ 10;
                tableroN[i][j] = String.valueOf(numeros);
            }
        }
    }
    private static void imprimirTableroN(){
        System.out.println("TABLERO NUMEROS");
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                System.out.print(tableroN[i][j]+ " ");
            }
            System.out.println();
        }
    }
    //uno lo relleno con numeros aleatorios del 10 al 99
    //otro relleno con x
    private static String tableroX [][];
    private static void inicializarTableroX(){
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                tableroX[i][j] = "xx";
            }
        }
    }

    private static void imprimirTableroX(){
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                System.out.print(tableroX[i][j]+ " ");
            }
            System.out.println();
        }
    }
    //el usuario va a poder insertar 10 numeros
    //siempre vamos a representar el de x
    //por cada numero que insertemos miraremos si hemos acertado algun numero del otro tablero y lo representaremos en el tablero de las x
    private static Boolean boleano = false; //Creamos un boleano para que este en bucle pidiendonos numeros
    private static void leerNumUsario(){
        Scanner lector = new Scanner(System.in);

        System.out.println("Dame un numero: ");
        String numeros = lector.nextLine();
        switch (numeros){ //Si el usuario introduce un 0 se termina el bucle por lo tanto terminamos el juego
            case "0":
                boleano = true;
        }
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                if (numeros.equals(tableroN[i][j])){
                    tableroX[i][j] = numeros;
                }
            }
        }
    }



    public static void main(String[] args) {
        tableroN = new String[filaTablero][columnaTablero];
        tableroX = new String[filaTablero][columnaTablero];
        inicializarTableroN();
        imprimirTableroN();
        System.out.println();
        inicializarTableroX();
        imprimirTableroX();
        do {
            leerNumUsario();
            imprimirTableroX();
        }while(boleano == false);
        //final
    }
}