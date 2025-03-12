package Armas;

public class ArmasAtaque extends Armas{
    int daño;
    public ArmasAtaque(String nombre, int daño)  {
        super(nombre);
        this.daño = daño;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }
}
