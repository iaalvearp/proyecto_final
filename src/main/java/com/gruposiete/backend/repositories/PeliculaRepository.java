package com.gruposiete.backend.repositories;

import com.gruposiete.backend.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

// Al extender de JpaRepository, obtenemos todos los métodos CRUD gratis
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}