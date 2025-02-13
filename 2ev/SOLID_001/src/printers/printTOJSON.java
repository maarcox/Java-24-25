package printers;

import herencia.Reporte;
import interfaces.Print;

public class printTOJSON extends Reporte {
    private String cadenaEnhtml;
    public printTOJSON(String cadena){
        super(cadena);
    }
    void imprimirCadena(){
        System.out.println(super.cadenaATransformar);
        System.out.println(this.cadenaEnhtml);
    }
}
