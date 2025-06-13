package org.alandoc.pixup.model;

<<<<<<< HEAD
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


=======
public class Disco extends Catalogo {
    private String titulo;
    private float precio;
    private int existencia;
    private float descuento;
    private String fechaLanzamiento;
    private String imagen;
    private Disquera disquera;
    private Artista artista;
    private GeneroMusical generoMusical;

    public Disco() {}

    public Disco(String titulo, float precio, int existencia, float descuento, String fechaLanzamiento, String imagen, Disquera disquera, Artista artista, GeneroMusical generoMusical) {
        this.titulo = titulo;
        this.precio = precio;
        this.existencia = existencia;
        this.descuento = descuento;
        this.fechaLanzamiento = fechaLanzamiento;
        this.imagen = imagen;
        this.disquera = disquera;
        this.artista = artista;
        this.generoMusical = generoMusical;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Disquera getDisquera() {
        return disquera;
    }

    public void setDisquera(Disquera disquera) {
        this.disquera = disquera;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(GeneroMusical generoMusical) {
        this.generoMusical = generoMusical;
    }

    @Override
    public String toString() {
        return "Disco{" +
                "titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", existencia=" + existencia +
                ", descuento=" + descuento +
                ", fechaLanzamiento='" + fechaLanzamiento + '\'' +
                ", disquera=" + (disquera != null ? disquera.getNombre() : "Sin disquera") +
                ", artista=" + (artista != null ? artista.getArtista() : "Sin artista") +
                ", generoMusical=" + (generoMusical != null ? generoMusical.getDescripcion() : "Sin género musical") +
                '}';
    }
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
}