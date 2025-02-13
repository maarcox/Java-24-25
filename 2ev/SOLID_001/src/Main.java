import herencia.Reporte;
import interfaces.Print;
import printers.printTOJSON;
import printers.printToHTML;
import printers.printToXML;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Reporte printTOJSON = new printTOJSON("dwdwawd");
        Reporte printToXML = new printToXML("·$%·");
        Reporte printToHTML = new printToHTML("<h1>KELOKE</h1>");

        ArrayList<Reporte> lst = new ArrayList<>();
        lst.add(printTOJSON);
        lst.add(printToXML);
        lst.add(printToHTML);
        //Funcion creada:
        for (Reporte reporte : lst) {
            reporte.imprimirCAdena();
        }
        System.out.println();
        //TO string:
        for (Reporte reporte : lst) {
            System.out.println(reporte);
        }
    }
}