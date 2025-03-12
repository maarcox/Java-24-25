package org.example;

import java.util.List;

public interface DAO<T> {
    void add(T t);       // Agregar un objeto a la base de datos
    void delete(int id); // Eliminar un objeto por ID
    void update(T t);    // Actualizar un objeto existente
    T find(int id);      // Buscar un objeto por ID
    List<T> findAll();   // Obtener todos los objetos de la base de datos
}
