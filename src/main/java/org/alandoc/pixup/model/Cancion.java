package org.alandoc.pixup.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_CANCION")
public class Cancion extends Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  Generación automática de ID
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "duracion", nullable = false)
    private java.sql.Time duracion;
    @ManyToOne
    @JoinColumn(name = "id_disco", nullable = false)
    private Disco disco;

}
