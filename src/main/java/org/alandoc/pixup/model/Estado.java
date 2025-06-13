package org.alandoc.pixup.model;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_ESTADO")
public class Estado extends Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 🔥 Generación automática de ID
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
=======
public class Estado extends Catalogo {
    private int id;
    private String nombre;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return "Estado { ID=" + id + ", Nombre='" + nombre + "' }";
    }
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
}