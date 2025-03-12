package personajes;

import java.util.ArrayList;

public abstract class buenos extends personajes{
    String colorTraje;
    public buenos(String nombre, int vida, String colorTraje) {
        super(nombre, vida);
        this.colorTraje = colorTraje;
    }


}
