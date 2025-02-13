package printers;

import herencia.Reporte;

public class printToXML extends Reporte {
    private String cadenaEnhtml;
   public printToXML(String cadena){
       super(cadena);
   }
   void imprimirCadena(){
       System.out.println(super.cadenaATransformar);
       System.out.println(this.cadenaEnhtml);
   }
}
