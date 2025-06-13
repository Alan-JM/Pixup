package org.alandoc.pixup.model;

<<<<<<< HEAD
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
=======
public class Disquera extends Catalogo {
    private String nombre;

    public Disquera() {}

    public Disquera(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Disquera{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
}