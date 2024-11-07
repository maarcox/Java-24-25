import java.util.Random;

public class Main {
    //Sopa de Letras Marcos Paniego López
    //rellenar tablero con ñ  que servira de casillas libres
    //5 palabras
    //tablero 10 x 10
    private static final int filaTablero = 10;
    private static final int columnaTablero = 10;
    private static char tablero[][];

    //Posiciones aleatorios
    private static Random aleatorio = new Random();
    private static int filaAleatoria ;
    private static int columnaAleatoria;


    //Inicializar tablero con casillas libres "Ñ"
    private static void inicizalizarTableroCasillasLibres(){
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                tablero[i][j] = 'Ñ';
            }
        }

    }

    //mostrar tablero
    private static void mostrarTableroCasillas(){
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    //meter palabra al tablero
    private static char caracteres[];

    private static void cargarPalabrasVertical(String palabra){
        columnaAleatoria = aleatorio.nextInt(columnaTablero);
        int longitud = palabra.length();
        caracteres = new char[longitud];

        for (int i = 0; i < longitud; i++) {
            do{
                tablero[i][columnaAleatoria] = palabra.charAt(i);
            }
            while (tablero[i][columnaAleatoria] == 'Ñ');
        }
    }

    private static void cargarPalabrasHorizontal(String palabra){
        int longitud = palabra.length();
        caracteres = new char[longitud];
        filaAleatoria = aleatorio.nextInt(filaTablero);
        for (int i = 0; i < longitud; i++) {
            tablero[filaAleatoria][i] = palabra.charAt(i);
        }
    }


    public static void main(String[] args) {
        tablero = new char[filaTablero][columnaTablero];
        char abecedario[];
        abecedario = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','R','S','T','U','V','W','X','Y','Z'};
        inicizalizarTableroCasillasLibres();
        cargarPalabrasVertical("HOLA");
        cargarPalabrasHorizontal("Petisui");
        
        mostrarTableroCasillas();



    }
}