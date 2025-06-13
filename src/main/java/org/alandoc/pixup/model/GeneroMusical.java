package org.alandoc.pixup.model;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_GENERO_MUSICAL")
public class GeneroMusical extends Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  Generación automática de ID
    private Integer id;

    @Column(name = "descripcion", nullable = false)
    private String nombre;
=======
public class GeneroMusical extends Catalogo {
    private String descripcion;

    public GeneroMusical() {}

    public GeneroMusical(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "GeneroMusical{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
}