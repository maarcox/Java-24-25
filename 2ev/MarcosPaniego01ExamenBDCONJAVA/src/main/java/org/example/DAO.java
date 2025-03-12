package org.example;

import java.util.List;

public interface DAO<T> {


    List<T> findAll();   // Obtener todos los objetos de la base de datos
}