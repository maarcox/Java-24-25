package armas.interfaces;

public class Martillo  extends ArmaAtaque{
    private final static int vida_Consumida = 3;

    public Martillo(String nombre) {
        super(nombre);
    }

    public static int getVidaCOnsumida(){
        return vida_Consumida;
    }


}
