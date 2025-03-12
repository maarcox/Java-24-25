package org.example;

import org.example.Pelicula;

import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void menu(){
        Integer res = 0;

        while (true){
            System.out.println("--------------------------<Menu>--------------------");
            System.out.println("   1. Añadir pelicula");
            System.out.println("   2. Obtener todas las peliculas");
            System.out.println("   3. Buscar una película por ID");
            System.out.println("   4. Actualizar una película");
            System.out.println("   5. Eliminar una película (ID 2, por ejemplo)");
            System.out.println("----------------------------------------------------");
            System.out.println("                                                    ");
            res = scanner.nextInt();

            switch (res){
                case 1:
                    System.out.println("Escribe el id:");
                    int id0 = scanner.nextInt();
                    scanner.nextLine();  // Limpia el salto de línea pendiente
                    System.out.println("Escribe el titulo:");
                    String titulo0 = scanner.nextLine();
                    System.out.println("Escribe el director:");
                    String director0 = scanner.nextLine();
                    System.out.println("Escribe el año:");
                    int anio0 = scanner.nextInt();
                    scanner.nextLine();  // Limpia el salto de línea pendiente, por si hay más input después

                    setNuevaPelicula(id0, titulo0, director0, anio0);
                    break;

                case 2:
                    System.out.println("inprimendo peliculas");
                    getPeliculaToo();
                    break;

                case 3:
                    System.out.println("id de la pelicula ha busacar");
                    int id2 = scanner.nextInt();
                    getPeliculaSearch(id2);
                    break;

                case 4:
                    System.out.println("Escribe el id:");
                    int id4 = scanner.nextInt();
                    System.out.println("Escribe el titulo:");
                    String titulo4 = scanner.nextLine();
                    System.out.println("Escribe el director:");
                    String director4 = scanner.nextLine();
                    System.out.println("Escribe el año:");
                    int anio4 = scanner.nextInt();
                    updatePeliculaBuscar(id4,titulo4,director4,anio4);
                    break;
                case 5:
                    System.out.println("Escribe el id:");
                    int id5 = scanner.nextInt();
                    eliminarPelicula(id5);
                    break;
            }
        }
    }

    // 📌 Instanciar PeliculaDAO (ahora usa Singleton)
    PeliculaDAO peliculaDAO = new PeliculaDAO();

    public void setNuevaPelicula(int id, String titulo, String director, int anio){
        // Insertar una nueva película
        Pelicula nuevaPelicula = new Pelicula(id, titulo, director, anio);
        peliculaDAO.add(nuevaPelicula);

        System.out.println("");
    }

    public void getPeliculaToo(){
        // Obtener todas las películas
        List<Pelicula> peliculas = peliculaDAO.findAll();
        System.out.println("\n🎬 Lista de Películas:");
        for (Pelicula p : peliculas) {
            System.out.println(p);
        }

        System.out.println("");
    }

    public void getPeliculaSearch(int id){
        // Buscar una película por ID
        Pelicula peliculaBuscada = peliculaDAO.find(id);
        if (peliculaBuscada != null) {
            System.out.println("\n🔍 Película encontrada: " + peliculaBuscada);
        }

        System.out.println("");
    }

    public void updatePeliculaBuscar(int id, String titulo, String director, int anio){
        // Actualizar una película
        Pelicula peliculaBuscada = peliculaDAO.find(id);
        if (peliculaBuscada != null) {
            peliculaBuscada = new Pelicula(peliculaBuscada.getId(), titulo, director, anio);
            peliculaDAO.update(peliculaBuscada);
        }

        System.out.println("");
    }

    public void eliminarPelicula(int id){
        // Eliminar una película (ID 2, por ejemplo)
        peliculaDAO.delete(id);
        System.out.println("");
    }

}