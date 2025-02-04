    public interface IEstanteria {

        public void addCancion(Cancion c);
        public void updateCancion(int id, String nuevoTitulo);
        public void deleteCancion(String tituloBuscar);
        public void printCanciones();

    }
