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

    private static void moverMalosTablero2Aleatoriamente(){
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                if (tablero2[i][j] == 'R'){
                    tablero2[i][j] = 'L';
                }
            }
        }
        for (int i = 0; i < 5 ; i++) {
            do {
                filaAleatorio = aleatorio.nextInt(10);
                columnaaleatorio = aleatorio.nextInt(10);
            }while (tablero2[filaAleatorio][columnaaleatorio] != 'L');
            tablero2[filaAleatorio][columnaaleatorio] = 'R';
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
        rellenarTablero1Caracteres(5, 'P'); //Pocimas
     //Asignar personajes Tablero 2
        rellenarTablero2Caracteres(5, 'M'); // 5 muros
        rellenarTablero2Caracteres(1, 'V'); //Jugador V
        rellenarTablero2Caracteres(5, 'R'); // los malos
        rellenarTablero2Caracteres(5, 'P'); //Pocimas


        Scanner lector = new Scanner(System.in);
        int contador = 0; //por si necesitamos en un futuro
        boolean fin = true;
        int jugador1Win = 0;
        int jugador2Win = 0;
        int turno = 1;
        boolean pocima = true; //Boleano para controlar pocimas yoda
        boolean pocima2 = true; //Boleano para controlar pocimas Dark Vader
        int filapocima;
        int columnapocima;
    do{
        if (turno == 1){
            moverMalosTablero1Aleatoriamente();
            System.out.println("Tablero YODA");
            imprimirTablero1();
            System.out.println(" ");
            System.out.println("Tablero Dark Vader");
            imprimirTablero2();
            System.out.println(" ");
            if (pocima == false){
                System.out.println("Pocima obtenida");
                do {
                    System.out.println("YODA elija la fila: ");
                    filapocima = lector.nextInt();
                    System.out.println("YODA elija la columna: ");
                    columnapocima = lector.nextInt();

                }while (filapocima < 0 && filapocima >=10  || columnapocima < 0 && columnapocima >= 10);
                switch (tablero1[filaYoda][columnaYoda]){
                    case 'L':
                        filaYoda = filapocima;
                        columnaYoda = columnapocima;
                        tablero1[filaYoda][columnaYoda] = 'Y';
                        break;
                    default:
                        System.out.println("Tienes un muro o malo, volviendo a la posicion anterior");
                        break;
                }
                System.out.println("Tablero YODA");
                imprimirTablero1();
                System.out.println(" ");
                System.out.println("Tablero Dark Vader");
                imprimirTablero2();
                System.out.println(" ");

                pocima = true;
            }else{
                System.out.println(" ");
                System.out.println("Turno YODA (elija movimiento A-W-S-D-Q-E-Z-C: ");
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
                                    System.out.println("Yoda te quedan: " + vidasJugador1 + " vidas");
                                    break;
                                case 'P':
                                    tablero1[filaYoda][columnaYoda +1 ] = 'L';
                                    tablero1[filaYoda][columnaYoda] = 'L';
                                    pocima = false;
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
                                    System.out.println("Yoda te quedan: " + vidasJugador1 + " vidas");
                                    break;
                                case 'F':
                                    jugador1Win = 2;
                                    fin = false;
                                    break;
                                case 'P':
                                    tablero1[filaYoda][columnaYoda -1] = 'L';
                                    tablero1[filaYoda][columnaYoda] = 'L';
                                    pocima = false;
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
                                    System.out.println("Yoda te quedan: " + vidasJugador1 + " vidas");
                                    break;
                                case 'P':

                                    pocima = false;
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
                                    System.out.println("Yoda te quedan: " + vidasJugador1 + " vidas");
                                    break;
                                case 'F':
                                    jugador1Win = 2;
                                    fin = false;
                                    break;
                                case 'P':
                                    tablero1[filaYoda +1][columnaYoda] = 'L';
                                    tablero1[filaYoda][columnaYoda] = 'L';
                                    pocima = false;
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
                                    System.out.println("Yoda te quedan: " + vidasJugador1 + " vidas");
                                    break;
                                case 'P':
                                    tablero1[filaYoda +1][columnaYoda+1] = 'L';
                                    tablero1[filaYoda][columnaYoda] = 'L';
                                    pocima = false;
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
                                    System.out.println("Yoda te quedan: " + vidasJugador1 + " vidas");
                                    break;
                                case 'P':
                                    tablero1[filaYoda +1][columnaYoda-1] = 'L';
                                    tablero1[filaYoda][columnaYoda] = 'L';
                                    pocima = false;
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
                                    System.out.println("Yoda te quedan: " + vidasJugador1 + " vidas");
                                    break;
                                case 'P':
                                    tablero1[filaYoda +1][columnaYoda-1] = 'L';
                                    tablero1[filaYoda][columnaYoda] = 'L';
                                    pocima = false;
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
                                    System.out.println("Yoda te quedan: " + vidasJugador1 + " vidas");
                                    break;
                                case 'F':
                                    jugador1Win = 2;
                                    fin = false;
                                    break;
                                case 'P':
                                    tablero1[filaYoda -1][columnaYoda-1] = 'L';
                                    tablero1[filaYoda][columnaYoda] = 'L';
                                    pocima = false;
                                    break;
                            }
                        }
                        break;
                    default:
                        System.out.println("Movimiento no valido");
                } //final switch movimientos
            }
         turno = 2; //turno dark vader
        } else if (turno == 2 ) {
            moverMalosTablero2Aleatoriamente();
            System.out.println("Tablero YODA");
            imprimirTablero1();
            System.out.println(" ");
            System.out.println("Tablero Dark Vader");
            imprimirTablero2();

            if (pocima2 == false){
                System.out.println(" ");
                System.out.println("Pocima obtenida");
                do {
                    System.out.println("Dark Vader elija la fila: ");
                    filapocima = lector.nextInt();
                    System.out.println("Dark Vader elija la columna: ");
                    columnapocima = lector.nextInt();
                }while (filapocima < 0 && filapocima >=10  || columnapocima < 0 && columnapocima >= 10);
                switch (tablero2[filapocima][columnapocima]){
                    case 'L':
                        filaYoda = filapocima;
                        columnaYoda = columnapocima;
                        tablero2[filaVader][columnaVader] = 'V';
                        break;
                    default:
                        System.out.println("Tienes un muro o malo, volviendo a la posicion anterior");
                        break;
                }

                System.out.println("Tablero YODA");
                imprimirTablero1();
                System.out.println(" ");
                System.out.println("Tablero Dark Vader");
                imprimirTablero2();

                pocima2 = true;
            }else{
                System.out.println(" ");
                System.out.println("Turno Dark Vader (elija movimiento A-W-S-D-Q-E-Z-C: ");
                String movimientos = lector.nextLine();
                switch (movimientos) {

                    case "A", "a":
                        if ((columnaVader - 1) >= 0) {
                            columnaVader = columnaVader - 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'M':
                                    columnaVader = columnaVader + 1;
                                    System.out.println("Desplazamiento invalido");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader + 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    break;
                                case 'R':
                                    vidasJugador2 = vidasJugador2 - 1;
                                    tablero2[filaVader][columnaVader + 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    System.out.println("Dark Vader te quedan: " + vidasJugador2 + " vidas");
                                    break;
                                case 'P':
                                    tablero2[filaVader][columnaVader + 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'L';
                                    pocima2 = false;
                                    break;
                            }
                        }
                        break;
                    case "D", "d":
                        if ((columnaVader + 1) < 10) {
                            columnaVader = columnaVader + 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'M':
                                    columnaVader = columnaVader - 1;
                                    System.out.println("Desplazamiento invalido");
                                    break;
                                case 'L':
                                    tablero2[filaVader][columnaVader - 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    break;
                                case 'R':
                                    vidasJugador2 = vidasJugador2 - 1;
                                    tablero2[filaVader][columnaVader - 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    System.out.println("Dark Vader te quedan: " + vidasJugador2 + " vidas");
                                    break;
                                case 'F':
                                    jugador2Win = 2;
                                    fin = false;
                                    break;
                                case 'P':
                                    tablero2[filaVader][columnaVader - 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'L';
                                    pocima2 = false;
                                    break;
                            }
                        }
                        break;
                    case "W", "w":
                        if ((filaVader - 1) >= 0) {
                            filaVader = filaVader - 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'M':
                                    filaVader = filaVader + 1;
                                    System.out.println("Desplazamiento invalido");
                                    break;
                                case 'L':
                                    tablero2[filaVader + 1][columnaVader] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    break;
                                case 'R':
                                    vidasJugador2 = vidasJugador2 - 1;
                                    tablero2[filaVader + 1][columnaVader] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    System.out.println("Dark Vader te quedan: " + vidasJugador2 + " vidas");
                                    break;
                                case 'P':
                                    tablero2[filaVader + 1][columnaVader] = 'L';
                                    tablero2[filaVader][columnaVader] = 'L';
                                    pocima2 = false;
                                    break;
                            }
                        }
                        break;
                    case "S", "s":
                        if ((filaVader + 1) < 10) {
                            filaVader = filaVader + 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'M':
                                    filaVader = filaVader - 1;
                                    System.out.println("Desplazamiento invalido");
                                    break;
                                case 'L':
                                    tablero2[filaVader - 1][columnaVader] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    break;
                                case 'R':
                                    vidasJugador2 = vidasJugador2 - 1;
                                    tablero2[filaVader - 1][columnaVader] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    System.out.println("Dark Vader te quedan: " + vidasJugador2 + " vidas");
                                    break;
                                case 'F':
                                    jugador2Win = 2;
                                    fin = false;
                                    break;
                                case 'P':
                                    tablero2[filaVader - 1][columnaVader] = 'L';
                                    tablero2[filaVader][columnaVader] = 'L';
                                    pocima2 = false;
                                    break;
                            }
                        }
                        break;
                    case "Q", "q":
                        if ((filaVader - 1) >= 0 && (columnaVader - 1) >= 0) {
                            filaVader = filaVader - 1;
                            columnaVader = columnaVader - 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'M':
                                    filaVader = filaVader + 1;
                                    columnaVader = columnaVader + 1;
                                    System.out.println("Desplazamiento invalido");
                                    break;
                                case 'L':
                                    tablero2[filaVader + 1][columnaVader + 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    break;
                                case 'R':
                                    vidasJugador2 = vidasJugador2 - 1;
                                    tablero2[filaVader + 1][columnaVader + 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    System.out.println("Dark Vader te quedan: " + vidasJugador2 + " vidas");
                                    break;
                                case 'P':
                                    tablero2[filaVader + 1][columnaVader + 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'L';
                                    pocima2 = false;
                                    break;
                            }
                        }
                        break;
                    case "E", "e":
                        if ((filaVader - 1) >= 0 && (columnaVader + 1) < 10) {
                            filaVader = filaVader - 1;
                            columnaVader = columnaVader + 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'M':
                                    filaVader = filaVader + 1;
                                    columnaVader = columnaVader - 1;
                                    System.out.println("Desplazamiento invalido");
                                    break;
                                case 'L':
                                    tablero2[filaVader + 1][columnaVader - 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    break;
                                case 'R':
                                    vidasJugador2 = vidasJugador2 - 1;
                                    tablero2[filaVader + 1][columnaVader - 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    System.out.println("Dark Vader te quedan: " + vidasJugador2 + " vidas");
                                    break;
                                case 'P':
                                    tablero2[filaVader + 1][columnaVader - 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'L';
                                    pocima2 = false;
                                    break;
                            }
                        }
                        break;
                    case "Z", "z":
                        if ((filaVader + 1) < 10 && (columnaVader - 1) >= 0) {
                            filaVader = filaVader + 1;
                            columnaVader = columnaVader - 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'M':
                                    filaVader = filaVader - 1;
                                    columnaVader = columnaVader + 1;
                                    System.out.println("Desplazamiento invalido");
                                    break;
                                case 'L':
                                    tablero2[filaVader - 1][columnaVader + 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    break;
                                case 'R':
                                    vidasJugador2 = vidasJugador2 - 1;
                                    tablero2[filaVader - 1][columnaVader + 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    System.out.println("Dark Vader te quedan: " + vidasJugador2 + " vidas");
                                    break;
                                case 'P':
                                    tablero2[filaVader - 1][columnaVader + 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'L';
                                    pocima2 = false;
                                    break;
                            }
                        }
                        break;
                    case "C", "c":
                        if ((filaVader + 1) < 10 && (columnaVader + 1) < 10) {
                            filaVader = filaVader + 1;
                            columnaVader = columnaVader + 1;
                            switch (tablero2[filaVader][columnaVader]) {
                                case 'M':
                                    filaVader = filaVader - 1;
                                    columnaVader = columnaVader - 1;
                                    System.out.println("Desplazamiento invalido");
                                    break;
                                case 'L':
                                    tablero2[filaVader - 1][columnaVader - 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    break;
                                case 'R':
                                    vidasJugador2 = vidasJugador2 - 1;
                                    tablero2[filaVader - 1][columnaVader - 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'V';
                                    System.out.println("Dark Vader te quedan: " + vidasJugador2 + " vidas");
                                    break;
                                case 'F':
                                    jugador2Win = 2;
                                    fin = false;
                                    break;
                                case 'P':
                                    tablero2[filaVader - 1][columnaVader - 1] = 'L';
                                    tablero2[filaVader][columnaVader] = 'L';
                                    pocima2 = false;
                                    break;
                            }
                        }
                        break;
                    default:
                        System.out.println("Movimiento no valido");
                }
                turno = 1;//turno yoda
            }

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