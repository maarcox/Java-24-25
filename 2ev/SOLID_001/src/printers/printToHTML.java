package printers;

import herencia.Reporte;
import interfaces.Print;

public class printToHTML extends Reporte {
    private String cadenaEnhtml;
    public printToHTML(String cadena){
        super(cadena);
    }
    void imprimirCadena(){
        System.out.println(super.cadenaATransformar);
        System.out.println(this.cadenaEnhtml);
    }
}

