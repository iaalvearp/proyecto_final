package com.gruposiete.backend.controllers;

import com.gruposiete.backend.models.Pelicula;
import com.gruposiete.backend.repositories.PeliculaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
@CrossOrigin(origins = "*") // Permite que Astro se conecte
public class PeliculaController {

    private final PeliculaRepository repositorio;

    public PeliculaController(PeliculaRepository repositorio) {
        this.repositorio = repositorio;
    }

    // 1. READ ALL (Leer todas) -> GET /api/peliculas
    @GetMapping
    public List<Pelicula> obtenerTodas() {
        return repositorio.findAll();
    }

    // 2. READ ONE (Leer una sola por ID) -> GET /api/peliculas/1
    @GetMapping("/{id}")
    public Pelicula obtenerUna(@PathVariable Long id) {
        // Busca por ID, si no existe devuelve null (para no complicarnos con errores ahora)
        return repositorio.findById(id).orElse(null);
    }

    // 3. CREATE (Guardar) -> POST /api/peliculas
    @PostMapping
    public Pelicula guardarPelicula(@RequestBody Pelicula pelicula) {
        return repositorio.save(pelicula);
    }

    // 4. UPDATE (Actualizar) -> PUT /api/peliculas/1
    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula peliculaActualizada) {
        // Primero buscamos si existe la película con ese ID
        Pelicula peliculaExistente = repositorio.findById(id).orElse(null);

        if (peliculaExistente != null) {
            // Si existe, actualizamos sus datos con los nuevos que nos envían
            peliculaExistente.setTitulo(peliculaActualizada.getTitulo());
            peliculaExistente.setSinopsis(peliculaActualizada.getSinopsis());
            peliculaExistente.setGenero(peliculaActualizada.getGenero());
            peliculaExistente.setDuracion(peliculaActualizada.getDuracion());
            peliculaExistente.setUrlImagen(peliculaActualizada.getUrlImagen());
            
            // Guardamos los cambios
            return repositorio.save(peliculaExistente);
        }
        return null;
    }

    // 5. DELETE (Borrar) -> DELETE /api/peliculas/1
    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Long id) {
        repositorio.deleteById(id);
    }
}