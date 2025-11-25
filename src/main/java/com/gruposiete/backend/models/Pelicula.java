package com.gruposiete.backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Data // Esto es magia de Lombok: crea Getters y Setters automáticamente por nosotros.
@Entity // Esto le dice a Java: "Convierte esta clase en una TABLA de Base de Datos".
public class Pelicula {

    @Id // Esto dice: "Esta es la Llave Primaria (PK)"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto dice: "Postgres, autoincrementa el ID (1, 2, 3...)"
    private Long id;

    private String titulo;
    
    // Column(length = 500) permite textos largos para la sinopsis
    @Column(length = 500) 
    private String sinopsis;
    
    private String genero;
    
    private String urlImagen; // Aquí guardaremos el link de la foto del poster
    
    private Integer duracion; // Duración en minutos
}