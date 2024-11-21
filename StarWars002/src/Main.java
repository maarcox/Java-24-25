import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int filaTablero = 10;
    private static final int columnaTablero = 10;
    private static char tablero1[][] = new char[filaTablero][columnaTablero];
    private static char tablero2[][] = new char[filaTablero][columnaTablero];
    private static void inicializartableros(){
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                tablero1[i][j] = 'L';
                tablero2[i][j] = 'L';
            }
        }
    }
    private static void imprimirTablero1(){
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                System.out.print(tablero1[i][j] + " ");
            }
            System.out.println("");
        }
    }
    private static void imprimirTablero2(){
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                System.out.print(tablero2[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static int filaAleatorio;
    private static int columnaaleatorio;
    private static int filaYoda;
    private  static int columnaYoda;
    private static int filaVader;
    private static int columnaVader;
    private static Random aleatorio = new Random();
    private static void rellenarTablero1Caracteres(int numero, char caracteres){
        for (int i = 0; i < numero; i++) {
            do {
                filaAleatorio = aleatorio.nextInt(10);
                columnaaleatorio = aleatorio.nextInt(10);
            }while (tablero1[filaAleatorio][columnaaleatorio] != 'L');
            tablero1[filaAleatorio][columnaaleatorio] = caracteres;
            if (caracteres == 'Y'){
                filaYoda = filaAleatorio;
                columnaYoda = columnaaleatorio;
            }
        }

    }

    private static void rellenarTablero2Caracteres(int numero, char caracteres){
        for (int i = 0; i < numero; i++) {
            do {
                filaAleatorio = aleatorio.nextInt(10);
                columnaaleatorio = aleatorio.nextInt(10);
            }while (tablero2[filaAleatorio][columnaaleatorio] != 'L');
            tablero2[filaAleatorio][columnaaleatorio] = caracteres;
            if (caracteres == 'V'){
                filaVader = filaAleatorio;
                columnaVader = columnaaleatorio;
            }
        }
    }

    private static void moverMalosTablero1Aleatoriamente(){
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                if (tablero1[i][j] == 'D'){
                    tablero1[i][j] = 'L';
                }
            }
        }
        for (int i = 0; i < 5 ; i++) {
            do {
                filaAleatorio = aleatorio.nextInt(10);
                columnaaleatorio = aleatorio.nextInt(10);
            }while (tablero1[filaAleatorio][columnaaleatorio] != 'L');
            tablero1[filaAleatorio][columnaaleatorio] = 'D';
        }
    }

    private static int vidasJugador1 = 3;
    private static int vidasJugador2 = 3;

    public static void main(String[] args) {
     inicializartableros();
     tablero1[filaTablero -1][columnaTablero -1] = 'F'; // casilla final
     tablero2[filaTablero -1][columnaTablero -1] = 'F'; // casilla final
     //Asignar personajes Tablero 1:
        rellenarTablero1Caracteres(5, 'M'); // 5 muros
        rellenarTablero1Caracteres(1, 'Y'); // Jugador Y
        rellenarTablero1Caracteres(5, 'D'); // los malos
     //Asignar personajes Tablero 2
        rellenarTablero2Caracteres(5, 'M'); // 5 muros
        rellenarTablero2Caracteres(1, 'V'); //Jugador V
        rellenarTablero2Caracteres(5, 'R'); // los malos


        Scanner lector = new Scanner(System.in);
        int contador = 0; //por si necesitamos en un futuro
        boolean fin = true;
        int jugador1Win = 0;
        int jugador2Win = 0;
    do{
        moverMalosTablero1Aleatoriamente();
        System.out.println("Tablero YODA");
        imprimirTablero1();
        System.out.println(" ");
        System.out.println("Tablero Dark Vader");
        imprimirTablero2();

        String movimientos = lector.nextLine();
        switch (movimientos){

            case "A", "a":
                if ((columnaYoda -1)>=0){
                    columnaYoda = columnaYoda -1;
                    switch (tablero1[filaYoda][columnaYoda]){
                        case 'M':
                            columnaYoda = columnaYoda +1;
                            System.out.println("Desplazamiento invalido");
                            break;
                        case 'L':
                            tablero1[filaYoda][columnaYoda +1 ] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            break;
                        case 'D':
                            vidasJugador1 = vidasJugador1 -1;
                            tablero1[filaYoda][columnaYoda +1 ] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            System.out.println("Te quedan: " + vidasJugador1 + " vidas");
                            break;
                    }
                }
                break;
            case "D", "d":
                if((columnaYoda + 1)<10){
                    columnaYoda = columnaYoda +1;
                    switch (tablero1[filaYoda][columnaYoda]){
                        case 'M':
                            columnaYoda = columnaYoda -1;
                            System.out.println("Desplazamiento invalido");
                            break;
                        case 'L':
                            tablero1[filaYoda][columnaYoda -1] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            break;
                        case 'D':
                            vidasJugador1 = vidasJugador1 -1;
                            tablero1[filaYoda][columnaYoda -1] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            System.out.println("Te quedan: " + vidasJugador1 + " vidas");
                            break;
                        case 'F':
                            jugador1Win = 2;
                            fin = false;
                            break;
                    }
                }
                break;
            case "W", "w":
                if ((filaYoda - 1)>= 0){
                    filaYoda = filaYoda -1;
                    switch (tablero1[filaYoda][columnaYoda]){
                        case 'M':
                            filaYoda = filaYoda + 1;
                            System.out.println("Desplazamiento invalido");
                            break;
                        case 'L':
                            tablero1[filaYoda +1][columnaYoda] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            break;
                        case 'D':
                            vidasJugador1 = vidasJugador1 -1;
                            tablero1[filaYoda +1][columnaYoda] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            System.out.println("Te quedan: " + vidasJugador1 + " vidas");
                            break;
                    }
                }
                break;
            case "S", "s":
                if ((filaYoda + 1)<10){
                    filaYoda = filaYoda +1;
                    switch (tablero1[filaYoda][columnaYoda]){
                        case 'M':
                            filaYoda = filaYoda - 1;
                            System.out.println("Desplazamiento invalido");
                            break;
                        case 'L':
                            tablero1[filaYoda -1][columnaYoda] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            break;
                        case 'D':
                            vidasJugador1 = vidasJugador1 -1;
                            tablero1[filaYoda -1][columnaYoda] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            System.out.println("Te quedan: " + vidasJugador1 + " vidas");
                            break;
                        case 'F':
                            jugador1Win = 2;
                            fin = false;
                            break;
                    }
                }
                break;
            case "Q", "q":
                if ((filaYoda -1) >=0 && (columnaYoda-1)>=0){
                    filaYoda = filaYoda -1;
                    columnaYoda = columnaYoda -1;
                    switch (tablero1[filaYoda][columnaYoda]){
                        case 'M':
                            filaYoda = filaYoda +1;
                            columnaYoda = columnaYoda +1;
                            System.out.println("Desplazamiento invalido");
                            break;
                        case 'L':
                            tablero1[filaYoda +1][columnaYoda+1] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            break;
                        case 'D':
                            vidasJugador1 = vidasJugador1 -1;
                            tablero1[filaYoda +1][columnaYoda+1] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            System.out.println("Te quedan: " + vidasJugador1 + " vidas");
                            break;
                    }
                }
                break;
            case "E", "e":
                if((filaYoda-1)>=0 && (columnaYoda+1) <10){
                    filaYoda = filaYoda -1;
                    columnaYoda = columnaYoda +1;
                    switch (tablero1[filaYoda][columnaYoda]){
                        case 'M':
                            filaYoda = filaYoda +1;
                            columnaYoda = columnaYoda -1;
                            System.out.println("Desplazamiento invalido");
                            break;
                        case 'L':
                            tablero1[filaYoda +1][columnaYoda-1] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            break;
                        case 'D':
                            vidasJugador1 = vidasJugador1 -1;
                            tablero1[filaYoda +1][columnaYoda-1] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            System.out.println("Te quedan: " + vidasJugador1 + " vidas");
                            break;
                    }
                }
                break;
            case "Z", "z":
                if((filaYoda + 1)< 10 && (columnaYoda-1)>=0){
                    filaYoda = filaYoda +1;
                    columnaYoda = columnaYoda -1;
                    switch (tablero1[filaYoda][columnaYoda]){
                        case 'M':
                            filaYoda = filaYoda -1;
                            columnaYoda = columnaYoda +1;
                            System.out.println("Desplazamiento invalido");
                            break;
                        case 'L':
                            tablero1[filaYoda -1][columnaYoda +1] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            break;
                        case 'D':
                            vidasJugador1 = vidasJugador1 -1;
                            tablero1[filaYoda -1][columnaYoda +1] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            System.out.println("Te quedan: " + vidasJugador1 + " vidas");
                            break;
                    }
                }
                break;
            case "C", "c":
                if ((filaYoda +1) <10 && (columnaYoda+1)<10){
                    filaYoda = filaYoda +1;
                    columnaYoda = columnaYoda +1;
                    switch (tablero1[filaYoda][columnaYoda]){
                        case 'M':
                            filaYoda = filaYoda -1;
                            columnaYoda = columnaYoda -1;
                            System.out.println("Desplazamiento invalido");
                            break;
                        case 'L':
                            tablero1[filaYoda -1][columnaYoda-1] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            break;
                        case 'D':
                            vidasJugador1 = vidasJugador1 -1;
                            tablero1[filaYoda -1][columnaYoda-1] = 'L';
                            tablero1[filaYoda][columnaYoda] = 'Y';
                            System.out.println("Te quedan: " + vidasJugador1 + " vidas");
                            break;
                        case 'F':
                            jugador1Win = 2;
                            fin = false;
                            break;
                    }
                }
                break;
        }
    }while (vidasJugador1 > 0 && vidasJugador2 > 0 &&  fin);
    if (vidasJugador1 == 0 ){
        System.out.println("Jugador YODA Has perdido");
        System.out.println("Jugador DARK VADER Has Ganado");
    } else if (vidasJugador2 == 0) {
        System.out.println("Jugador DARK VADER Has perdido");
        System.out.println("Jugador YODA Has Ganado");
    }
    if (jugador1Win == 2){
        System.out.println("Jugador YODA Has Ganado");
    } else if (jugador2Win == 2) {
        System.out.println("Jugador DARK VADER Has Ganado");
    }
    }
}