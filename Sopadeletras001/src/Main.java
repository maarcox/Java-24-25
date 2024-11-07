import java.util.Random;
import java.util.Scanner;

public class Main {
    //Sopa de Letras Marcos Paniego López
    //rellenar tablero con ñ  que servira de casillas libres
    //5 palabras
    //tablero 10 x 10
    private static final int filaTablero = 10;
    private static final int columnaTablero = 10;
    private static char tablero[][];
    private static final int MAX_INTENTOS = 100;

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

    private static void cargarPalabrasHorizontal(String palabra){
        int longitud = palabra.length();
        int intentos = 0;
        boolean colocada = false;

        while (intentos < MAX_INTENTOS) {
            // Generamos una fila y columna aleatoria
            int columnaInicio = aleatorio.nextInt(columnaTablero - longitud + 1); // Asegura que la palabra quepa
            int filaAleatoria = aleatorio.nextInt(filaTablero); // Seleccionamos fila aleatoria

            // Verificar si hay espacio libre para la palabra
            boolean espacioLibre = true;
            for (int i = 0; i < longitud; i++) {
                if (tablero[filaAleatoria][columnaInicio + i] != 'Ñ') {
                    espacioLibre = false;
                    break; // Si encontramos una casilla ocupada, salimos del bucle
                }
            }

            // Si encontramos espacio libre, colocamos la palabra
            if (espacioLibre) {
                for (int i = 0; i < longitud; i++) {
                    tablero[filaAleatoria][columnaInicio + i] = palabra.charAt(i);
                }
                colocada = true;
                break; // Salimos del bucle, ya hemos colocado la palabra
            }
            
            intentos++;
        }

    }

    private static boolean cargarPalabraVertical(String palabra) {
        int longitud = palabra.length();
        int intentos = 0;
        boolean colocada = false;

        while (intentos < MAX_INTENTOS) {
            // Generamos una fila y columna aleatoria
            int filaInicio = aleatorio.nextInt(filaTablero - longitud + 1); // Asegura que la palabra quepa verticalmente
            int columnaAleatoria = aleatorio.nextInt(columnaTablero); // Seleccionamos columna aleatoria

            // Verificar si hay espacio libre para la palabra
            boolean espacioLibre = true;
            for (int i = 0; i < longitud; i++) {
                if (tablero[filaInicio + i][columnaAleatoria] != 'Ñ') {
                    espacioLibre = false;
                    break; // Si encontramos una casilla ocupada, salimos del bucle
                }
            }

            // Si encontramos espacio libre, colocamos la palabra
            if (espacioLibre) {
                for (int i = 0; i < longitud; i++) {
                    tablero[filaInicio + i][columnaAleatoria] = palabra.charAt(i);
                }
                colocada = true;
                break; // Salimos del bucle, ya hemos colocado la palabra
            }

            intentos++;
        }

        return colocada; // Devuelve true si la palabra fue colocada, false si no se pudo
    }

    private static void rellenarTableroletras(){
        char abecedario[];
        abecedario = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','R','S','T','U','V','W','X','Y','Z'};

        for (int i = 0; i <filaTablero ; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                if (tablero[i][j] == 'Ñ'){
                    int aleatorioABC = aleatorio.nextInt(abecedario.length);
                    tablero[i][j] = abecedario[aleatorioABC];
                }
            }
        }
    }

    public static void main(String[] args) {
        tablero = new char[filaTablero][columnaTablero];
        inicizalizarTableroCasillasLibres();
        cargarPalabraVertical("NOBITA");
        cargarPalabraVertical("MARCOS");
        cargarPalabrasHorizontal("DORAEMON");
        cargarPalabrasHorizontal("JERUSALEN");
        cargarPalabrasHorizontal("JAVA");
        //rellenarTableroletras();
        rellenarTableroletras();
        mostrarTableroCasillas();


        Boolean bucle = true;
        while (bucle) {
            Scanner lector = new Scanner(System.in);
            String leerpalabra = lector.nextLine();
            Boolean correcto = true;
            int longitud = leerpalabra.length();
            if (leerpalabra.equals("0")){
                bucle = false;
                break;
            }
            System.out.println("Escribe la Poscion de la palabra ");
            for (int i = 0; i < longitud; i++) {
                System.out.println("");
                System.out.println("Posicion Letra: " + leerpalabra.charAt(i));
                System.out.println("Fila:");
                int posicionFila = lector.nextInt();
                System.out.println("Columna:");
                int posicionColumna = lector.nextInt();
                if (tablero[posicionFila][posicionColumna] == leerpalabra.charAt(i)) {
                    correcto = true;
                }else{
                    correcto = false;
                    break;
                }

            }

            if (correcto){
                System.out.println("HAS ACERTADO LA PALABRA " + leerpalabra);
            }else{
                System.out.println("No has hacertado la palabra " );
            }

        }
    }
}