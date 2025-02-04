import java.util.ArrayList;

public class AlmacenMusica implements IEstanteria {
    ArrayList<Cancion> lstCanciones;

    /*
    public  AlmacenMusica(ArrayList<Cancion> lstCanciones){
        this.lstCanciones = lstCanciones;
    } */

    public  AlmacenMusica(){
        this.lstCanciones = lstCanciones = new ArrayList<Cancion>();

    }

    @Override
    public void addCancion(Cancion c) {
            lstCanciones.add(c);
    }

    @Override
    public void updateCancion(int id, String nuevoTitulo) {
        for (int i = 0; i < lstCanciones.size(); i++) {
            if (lstCanciones.get(i).getId() == id){
                lstCanciones.get(i).setTitle(nuevoTitulo);
            }
        }
    }

    @Override
    public void deleteCancion(String tituloBuscar) {
        for (int i = 0; i < lstCanciones.size(); i++) {
            if (lstCanciones.get(i).getTitle() == tituloBuscar){
                lstCanciones.remove(i);

            }
        }
    }

    @Override
    public void printCanciones() {
        for (Cancion c : lstCanciones){
            System.out.println(c);
        }
    }


}
