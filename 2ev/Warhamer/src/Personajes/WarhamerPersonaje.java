package Personajes;

public abstract class WarhamerPersonaje {

    private String nombre;
    private int energia;
    //protected HasMap<String.Arma> armas
    private static int contPersonajes;
    private static final int ENERGIA_MAX = 200;


    //CONSTRUCTOR

    public WarhamerPersonaje(String nombre) {
        this.nombre = nombre;
    }

    //MÉTODOS

    public void sumarEnergia(){

    }
    public static void toNumPersonajes(){

    }
    public String imprimirArmas(){
        return "";
    }



    @Override
    public String toString() {
        return "WarhamerPersonaje{" +
                "nombre='" + nombre + '\'' +
                ", energia=" + energia +
                '}';
    }
}