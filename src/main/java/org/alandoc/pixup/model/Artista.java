package org.alandoc.pixup.model;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_ARTISTA")
public class Artista extends Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  Generación automática de ID
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
=======
public class Artista extends Catalogo{
    private String artista;

    public Artista() {
    }

    public Artista(String artista) {
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "artista='" + artista + '\'' +
                ", id=" + id +
                '}';
    }
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
}
