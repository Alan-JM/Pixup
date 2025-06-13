package org.alandoc.pixup.model;

<<<<<<< HEAD
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
=======
public class Cancion extends Catalogo {
    private String titulo;
    private String duracion;
    private Disco disco;

    public Cancion() {}

    public Cancion(String titulo, String duracion, Disco disco) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.disco = disco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "titulo='" + titulo + '\'' +
                ", duracion='" + duracion + '\'' +
                ", disco=" + (disco != null ? disco.getTitulo() : "Sin disco") +
                '}';
    }
}
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
