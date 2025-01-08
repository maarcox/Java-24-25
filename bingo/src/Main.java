import java.util.Random;

public class Main {
    private static final int Filabingo = 3;
    private static final int columnabingo = 9;
    private static int array[][] = new int[Filabingo][columnabingo];
    private static void crearTableroBingo() {
        Random aleatorio = new Random();
        for (int i = 0; i < Filabingo; i++) {
            for (int j = 0; j < columnabingo; j++) {
                   if (j == 0){
                       int numAle = aleatorio.nextInt(10) + 10;
                       array[i][j] = numAle;
                   }
                   if (j == 1){
                       int numAle = aleatorio.nextInt(10) + 20;
                       array[i][j] = numAle;
                   }
                   if (j == 2){
                       int numAle = aleatorio.nextInt(10) + 30;
                       array[i][j] = numAle;
                   }
                   if (j == 3){
                       int numAle = aleatorio.nextInt(10) + 40;
                       array[i][j] = numAle;
                   }
                   if (j == 4){
                       int numAle = aleatorio.nextInt(10) + 50;
                       array[i][j] = numAle;
                   }
                   if (j == 5){
                       int numAle = aleatorio.nextInt(10) + 60;
                       array[i][j] = numAle;
                   }
                   if (j == 6){
                       int numAle = aleatorio.nextInt(10) + 70;
                       array[i][j] = numAle;
                   }
                   if (j == 7){
                       int numAle = aleatorio.nextInt(10) + 80;
                       array[i][j] = numAle;
                   }
                   if (j == 8){
                       int numAle = aleatorio.nextInt(10) + 90;
                       array[i][j] = numAle;
                   }
            }
        }
    }
    private static void imprimirTableroBingo(){
        for (int i = 0; i < Filabingo; i++) {
            for (int j = 0; j < columnabingo; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
        //Bingo Creado Por Marcos Paniego López
        System.out.println("---Carton BINGO MARCOS PANIEGO LÓPEZ---");
        crearTableroBingo();
        imprimirTableroBingo();
    }
}