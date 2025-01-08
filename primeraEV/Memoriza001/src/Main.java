import java.util.Random;
import java.util.Scanner;

//MEMORIZA MARCOS PANIEGO LÓPEZ
public class Main {
    private static final int filaTablero = 4;
    private static final int columnaTablero = 4;
    private static int tablero[][];
    private static int tablerocero[][];

    //inizializartablero a 0


    private static void iniciazializarTablero(){
        int[] rellenar = new int[]{1, 1, 2, 2, 3, 3, 4 , 4, 5, 5, 6, 6, 7, 7, 8, 8};
        int cont = 0;
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                tablero[i][j] = rellenar[cont];
                cont = cont +1;
            }
        }
    }

    private static void iniciazializarTableroCERO(){
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                tablerocero[i][j] = 0;
            }
        }
    }

    private static void imprimirTablero(){
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void imprimirtablero0(){
        for (int i = 0; i < filaTablero; i++) {
            for (int j = 0; j < columnaTablero; j++) {
                System.out.print(tablerocero[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void borrarpantalla(){
        for (int i = 0; i < 100; i++) {
            System.out.println(" ");
        }
    }




        public static void main(String[] args) throws InterruptedException  {
        tablero = new int[filaTablero][columnaTablero];
        tablerocero = new int[filaTablero][columnaTablero];
        iniciazializarTablero();
        int i = 0;
        int j = 0;
        iniciazializarTableroCERO();
        imprimirTablero();
        Thread.sleep(1000);
        borrarpantalla();
        Scanner leer = new Scanner(System.in);
        do {
            do {
            System.out.println("Escriba el numero: ");
            int numero = leer.nextInt();
            System.out.println("Escriba la fila: ");
            int fila = leer.nextInt();
            System.out.println("Escriba la columna: ");
            int columna = leer.nextInt();
            if (fila > 4 || columna > 4 || fila<0 || columna<0) {
                System.out.println("Incorecto");
                System.out.println();
                imprimirtablero0();
            } else if (tablero[fila][columna] == numero){
                tablerocero[fila][columna] = numero;
                imprimirtablero0();
            }
            }while(tablerocero[i][j]==0);
        }while(tablerocero[i][j]!=0);


    }
}