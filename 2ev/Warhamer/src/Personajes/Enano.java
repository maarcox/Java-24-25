package Personajes;

public class Enano extends WarhamerPersonaje{
    private int riqueza;
    protected int nivel;
    private static int contEnanos;
    public Enano(String nombre, int riqueza) {
        super(nombre);
        this.riqueza = riqueza;
    }
    public String imprimirArmas(){
        return ("");
    }

    @Override
    public String toString() {
        return "Enano{" +
                "riqueza=" + riqueza +
                ", nivel=" + nivel +
                '}';
    }
}
