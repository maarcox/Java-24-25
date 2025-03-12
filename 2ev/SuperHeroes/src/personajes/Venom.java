package personajes;

import Armas.Armas;

public class Venom extends malos {
    int nivel;
    Armas armas;
    public Venom(String nombre, int vida, int nivel, Armas armas) {
        super(nombre, vida);
        this.nivel = nivel;
        this.armas = armas;
    }



    @Override
    public String toString() {
        return "Venom{" +
                "{armas=" + armas +
                "} nivel=" + nivel +
                ", vida=" + vida +

                '}';
    }

    @Override
    public void defensa(personajes Victima) {
        System.out.println(Victima.nombre + " se defiende");
    }

    @Override
    public void ataque(personajes Victima) {
        System.out.println("Venom ataca a " + Victima.nombre + " con " + armas.getNombre());
        defensa(Victima);


    }
}
