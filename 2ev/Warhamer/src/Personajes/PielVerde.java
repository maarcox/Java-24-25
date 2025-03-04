package Personajes;

public class PielVerde  extends WarhamerPersonaje{
    private String puebloNacimiento;
    protected int nivel;

    public PielVerde(String nombre, String puebloNacimiento) {
        super(nombre);
        this.puebloNacimiento = puebloNacimiento;
    }


    public String imprimirArmas(){
        return ("");
    }

    private static int getContPielesVerdes(){
        return 0;
    }

    @Override
    public String toString() {
        return "PielVerde{" +
                "puebloNacimiento='" + puebloNacimiento + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
