package org.alandoc.pixup.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_DISCO")
public class Disco extends Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  Generación automática de ID
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "precio", nullable = false)
    private float precio;

    @Column(name = "existencia", nullable = false)
    private Integer existencia;

    @Column(name = "descuento", nullable = false)
    private float descuento;

    @Column(name = "fechaLanzamiento", nullable = false)
    private java.sql.Date fechaLanzamiento;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "id_disquera", nullable = false)
    private Disquera disquera;

    @ManyToOne
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;

    @ManyToOne
    @JoinColumn(name = "id_genero_musical", nullable = false)
    private GeneroMusical generoMusical;


}