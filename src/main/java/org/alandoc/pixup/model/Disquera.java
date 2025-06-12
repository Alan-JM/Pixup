package org.alandoc.pixup.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_DISQUERA")
public class Disquera extends Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  Generación automática de ID
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
}