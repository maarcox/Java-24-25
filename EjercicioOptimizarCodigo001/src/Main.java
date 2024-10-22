//En este ejercicio nos piden que Optimizemos el codigo que nos mandaron en el enunciado

public class Main {
    private static String[] palabras;
    private static void ListaDePalabras(){

        palabras = new String[]{
                "IRON",
                "BED",
                "BED_BLOCK",
                "CACTUS",
                "BRICK_STAIRS",
                "BIRCH_WOOD_STAIRS",
                "BREWING_STAND",
                "CAKE",
                "CAKE_BLOCK",
                "CAULDRON",
                "CHEST",
                "CLAY",
                "SAND",
                "BURNING_FURNACE",
                "COBBLESTONE_STAIRS",
                "FENCE",
                "FENCE_GATE",
                "FIRE",
                "GRAVEL",
                "IRON_DOOR_BLOCK",
                "IRON_FENCE",
                "IRON_DOOR",
                "LADDER",
                "MELON",
                "LEAVES",
                "LOCKED_CHEST",
                "SANDSTONE_STAIRS"
        } ;
    }

    public static void main(String[] args) {
        ListaDePalabras();
        String block = "MELON";
        int posicion = 0;
        boolean TrueoFalse = true;
        for(int i = 0; i < palabras.length; i++){
            if (palabras[i] == block){
                posicion = i;
                TrueoFalse = false;
            }
        }
        if(TrueoFalse == false){
            System.out.println("La palabra "+ block +" esta dentro de la lista y tiene "+palabras[posicion].length()+ " Letras");
        }else{
            System.out.println("La palabra "+ block +" no esta en la lista");
        }

    }
}
