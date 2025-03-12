package personajes;

import Armas.Armas;
import Interfaces.Icombate;

public class Spiderman extends buenos  {
    Armas armas;
    public Spiderman(String nombre, int vida, String colorTraje, Armas armas) {
        super(nombre, vida, colorTraje);
        this.armas = armas;
    }

    @Override
    public String toString() {
        return "Spiderman{" +
                "armas=" + armas +
                ", colorTraje='" + colorTraje + '\'' +
                ", nombre='" + nombre + '\'' +
                ", vida=" + vida +
                '}';
    }


    @Override
    public void defensa(personajes Victima) {
        System.out.println(Victima.nombre + " se defiende");

    }

    @Override
    public void ataque(personajes Victima) {
        System.out.println("Spiderman ataca a " + Victima.nombre + " con " + armas.getNombre());
        defensa(Victima);
    }
}
