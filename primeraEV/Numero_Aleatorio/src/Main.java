//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Random;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("hola co");
        Random rand = new Random();

        for(int i = 1; i <= 5; ++i) {
            int numeroAleatorio = rand.nextInt(100) + 1;
            System.out.println("Numero aleatorio " + i + " = " + numeroAleatorio);
        }

    }
}