package herencia;

public class Reporte {
    // ATRIBUTOS
    protected String cadenaATransformar;
    //CONSTRUCTORES
    public Reporte(String cadena){
        this.cadenaATransformar = cadena;
    }
    //METODOS

    //GETTER/SETER

    public String getCadenaATransformar() {
        return cadenaATransformar;
    }

    public void setCadenaATransformar(String cadenaATransformar) {
        this.cadenaATransformar = cadenaATransformar;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "cadenaATransformar='" + cadenaATransformar + '\'' +
                '}';
    }

    public void imprimirCAdena() {
        System.out.println(this.cadenaATransformar);
    }
}
