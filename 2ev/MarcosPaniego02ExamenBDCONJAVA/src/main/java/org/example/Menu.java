package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private CursoDAO cursoDAO;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.cursoDAO = new CursoDAO();
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Mostrar todos los cursos");
            System.out.println("2. Buscar cursos por categoría");
            System.out.println("3. Añadir curso");
            System.out.println("4. Modificar curso");
            System.out.println("5. Eliminar curso");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        mostrarTodosLosCursos();
                        break;
                    case 2:
                        filtrarPorCategoria();
                        break;
                    case 3:
                        añadirCurso();
                        break;
                    case 4:
                        modificarCurso();
                        break;
                    case 5:
                        eliminarCurso();
                        break;
                    case 6:
                        System.out.println("👋 Saliendo del programa...");
                        break;
                    default:
                        System.out.println("❌ Opción inválida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Debe ingresar un número válido.");
                scanner.nextLine(); // Limpiar buffer
                opcion = 0; // Forzar repetición del menú
            }
        } while (opcion != 6);
    }

    private void mostrarTodosLosCursos() {
        List<Curso> cursos = cursoDAO.findAll();
        if (cursos.isEmpty()) {
            System.out.println("⚠️ No hay cursos disponibles.");
        } else {
            System.out.println("\n📚 Lista de Cursos:");
            for (Curso curso : cursos) {
                System.out.println(curso);
            }
        }
    }

    private void filtrarPorCategoria() {
        System.out.print("\n🔍 Ingrese la palabra clave de la categoría: ");
        String nombreCategoria = scanner.nextLine().trim();

        if (nombreCategoria.isEmpty()) {
            System.out.println("⚠️ Debe ingresar una categoría válida.");
            return;
        }

        List<Curso> cursos = cursoDAO.findByCategoria(nombreCategoria);
        if (cursos.isEmpty()) {
            System.out.println("⚠️ No se encontraron cursos en esta categoría.");
        } else {
            System.out.println("\n📚 Cursos encontrados en la categoría '" + nombreCategoria + "':");
            for (Curso curso : cursos) {
                System.out.println(curso);
            }
        }
    }

    private void añadirCurso() {
        System.out.println("\n🆕 Añadir Nuevo Curso");

        System.out.print("Ingrese el nombre del curso: ");
        String nombreCurso = scanner.nextLine().trim();

        System.out.print("Ingrese la descripción del curso: ");
        String descripcion = scanner.nextLine().trim();

        System.out.print("Ingrese el ID de la categoría: ");
        int idCategoria = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Categorias categoria = new Categorias(String.valueOf(idCategoria), ""); // Se usa solo el ID
        Curso nuevoCurso = new Curso(0, nombreCurso, descripcion, categoria);
        cursoDAO.add(nuevoCurso);
        System.out.println("✅ Curso añadido con éxito.");
    }

    private void modificarCurso() {
        System.out.print("\n✏️ Ingrese el ID del curso a modificar: ");
        int idCurso = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese el nuevo nombre del curso (o presione Enter para no cambiarlo): ");
        String nuevoNombre = scanner.nextLine().trim();

        System.out.print("Ingrese la nueva descripción (o presione Enter para no cambiarla): ");
        String nuevaDescripcion = scanner.nextLine().trim();

        System.out.print("Ingrese el nuevo ID de la categoría (o 0 para no cambiarla): ");
        int nuevoIdCategoria = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        cursoDAO.update(idCurso, nuevoNombre, nuevaDescripcion, nuevoIdCategoria);
        System.out.println("✅ Curso modificado con éxito.");
    }

    private void eliminarCurso() {
        System.out.print("\n🗑️ Ingrese el ID del curso a eliminar: ");
        int idCurso = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        cursoDAO.delete(idCurso);
        System.out.println("✅ Curso eliminado con éxito.");
    }
}



