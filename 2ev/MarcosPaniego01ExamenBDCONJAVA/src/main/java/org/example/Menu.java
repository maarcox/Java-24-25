package org.example;

import org.example.Curso;

import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        Integer res = 0;

        while (true) {
            System.out.println("--------------------------<Menu>--------------------");
            System.out.println("   1. Obtener todas los cursos");
            System.out.println("----------------------------------------------------");
            System.out.println("                                                    ");
            res = scanner.nextInt();

            switch (res) {
                case 1:
                    System.out.println("imprimendo cursos");
                    getPeliculaToo();
                    break;

            }
        }
    }
    CursoDAO cursolaDAO = new CursoDAO();

    public void getPeliculaToo() {
        // Obtener todas las películas
        List<Curso> cursos = CursoDAO.findAll();
        System.out.println("\n 😉 Lista de Cursos:");
        for (Curso p : cursos) {
            System.out.println(p);
        }

        System.out.println("");
    }
}
