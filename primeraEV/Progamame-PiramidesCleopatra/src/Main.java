//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Double a;
        Double b;
        Double c;
        // Solicitar números al usuario
        do {
            System.out.print("Introduce el número a: ");
            a = lector.nextDouble();

            System.out.print("Introduce el número b: ");
            b = lector.nextDouble();

            System.out.print("Introduce el número c: ");
            c = lector.nextDouble();

            if(a>10000||b>10000||c>10000||a<-10000||b<-10000||c<-10000){
                System.out.println("Invalido. Los Años deben ser mayores de -10.000 y menores de 10.0000");
            }
        }while (a > 10000 || b > 10000 || c > 10000 || a < -10000 || b < -10000 || c < -10000);
        // Calcular diferencias
        double diferenciaA = b - a;
        double diferenciaC = b - c;
        // Comparar las diferencias
        if (diferenciaA < 0) diferenciaA = -diferenciaA; // Hacer positiva
        if (diferenciaC < 0) diferenciaC = -diferenciaC; // Hacer positiva
        // Determinar cuál número se aproxima más a b
        if (diferenciaA < diferenciaC) {
            System.out.println("El número " + a + " se aproxima más a " + b);
        } else if (diferenciaC < diferenciaA) {
            System.out.println("El número " + c + " se aproxima más a " + b);
        } else {
            System.out.println("Empate");
        }
    }
}