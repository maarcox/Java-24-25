package Personajes;

import java.util.ArrayList;

public class PielVerde extends WharhammerPersonaje{
    private String puebloNacimiento;
    private static ArrayList<PielVerde> lstPielVerdes = new ArrayList<>();
    public PielVerde(String nombre, int energia, String puebloNacimiento) {
        super(nombre, energia);
        this.puebloNacimiento = puebloNacimiento;
    }



    public static void añadirPielverdesArray(PielVerde pielVerde){
        lstPielVerdes.add(pielVerde);
    }



    public static void imprimirPielVerdesArray(){
        int ContadorArray = lstPielVerdes.size();

            System.out.println(lstPielVerdes);


    }

    @Override
    public String toString() {
        return "PielVerde{" +
                "puebloNacimiento='" + puebloNacimiento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", energia=" + energia +
                '}';
    }
}
