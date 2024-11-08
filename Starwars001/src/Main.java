import java.util.Random;
import java.util.Scanner;
public class Main {
    private static final int filaTablero = 10;
    private static final int columnaTablero = 10;
    private static char tableroJuego1[][];
    private static char tableroJuego2[][];

    private static int filaYoda;
    private static int columnaYoda;

    private static int filaDarthVader;
    private static int  columnaDarthVader;
    private static void inicializarTablersCasillasLibres() {
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                tableroJuego1[i][j] = 'L';  //Rellenamos tablero con casillas libres
                tableroJuego2[i][j] = 'L';
            }
        }
    }

    private static void mostrarTableros() {
        System.out.println("Tablero Jugador 1");
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                System.out.print(tableroJuego1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(" ");
        System.out.println("Tablero Jugador 2");
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                System.out.print(tableroJuego2[i][j] + " " );
            }
            System.out.println(" ");
        }
    }

    private static void asignarPersonajesEnCasillasLibresTablero1(char caracter, int numrepeticiones){
        Random alet = new Random();
        int FilaAleatorio = -1;
        int ColumnaAleatorio = -1;
        for (int i = 0; i < numrepeticiones; i++) {
            do {
                FilaAleatorio = alet.nextInt(filaTablero);
                ColumnaAleatorio = alet.nextInt(columnaTablero);
            }while (tableroJuego1[FilaAleatorio][ColumnaAleatorio]!= 'L');
            tableroJuego1[FilaAleatorio][ColumnaAleatorio] = caracter;
        }
        if (caracter == 'Y'){
            filaYoda = FilaAleatorio;
            columnaYoda = ColumnaAleatorio;
        }
    }
    private static void asignarPersonajesEnCasillasLibresTablero2(char caracter, int numrepeticiones){
        Random alet = new Random();
        int FilaAleatorio = -1;
        int ColumnaAleatorio = -1;
        for (int i = 0; i < numrepeticiones; i++) {
            do {
                FilaAleatorio = alet.nextInt(filaTablero);
                ColumnaAleatorio = alet.nextInt(columnaTablero);
            }while (tableroJuego2[FilaAleatorio][ColumnaAleatorio]!= 'L');
            tableroJuego2[FilaAleatorio][ColumnaAleatorio] = caracter;
        }
        if (caracter == 'V'){
            filaDarthVader = FilaAleatorio;
            columnaDarthVader = ColumnaAleatorio;
        }
    }

    public static void main(String[] args) {

        //Tablero 1
        tableroJuego1 = new char[filaTablero][columnaTablero];
        tableroJuego2 = new char[filaTablero][columnaTablero];
        inicializarTablersCasillasLibres();
        asignarPersonajesEnCasillasLibresTablero1('Y', 1);
        asignarPersonajesEnCasillasLibresTablero1('M', 5);
        asignarPersonajesEnCasillasLibresTablero1('D', 5);
        asignarPersonajesEnCasillasLibresTablero2('V', 1);
        asignarPersonajesEnCasillasLibresTablero2('M', 5);
        asignarPersonajesEnCasillasLibresTablero2('R', 5);
        tableroJuego1[filaTablero-1][columnaTablero-1] = 'F'; //Añadiremos una casilla final para ganar tablero 1
        tableroJuego2[filaTablero-1][columnaTablero-1] = 'F'; //Añadiremos una casilla final para ganar tablero 2
        mostrarTableros();


        
        //3 vidas cada jugador se desceunta cuando choca con un D o R
        //Pierde antes el jugador que pierda 3 vidas
        //Gana el primero que llegue casilla final

    }

}