package pojo;

public class Magdalena {
    // Atributos
    private String sabor;
    private String[] listaMagdalenas = new String[4]; //Almacenamiento array 4 magdalenas


    /* private String color;
     private String saborfruta;
     private String saborpepitas;

     //Constructor;
     public Magdalena(String color, String sabor, String saborfruta, String saborpepitas){
         System.out.println("Color " + color);
         System.out.println("Sabor "+ sabor);
         this.sabor = sabor;
         this.color = color;
         this.saborpepitas = saborpepitas;
         this.saborfruta = saborfruta;
     }

     public void hornear(){
         System.out.print("Hornear la magdalena " + color + " ");
         System.out.println("de " + sabor);
         System.out.println("Estoy horneando!!");
     }

     public void mezclar(){
         System.out.println("Estoy mezclando " + saborfruta + " con " + saborpepitas);
         System.out.println("Estoy Mezclando!!");
     }
    */
    public Magdalena(String sabor){
        for (int i = 0; i < 4; i++) {
            this.sabor = sabor;
            listaMagdalenas[i] = sabor;
        }
    }


    public String mostrar(){
        System.out.println(listaMagdalenas[0]);
        return null;
    }





}

