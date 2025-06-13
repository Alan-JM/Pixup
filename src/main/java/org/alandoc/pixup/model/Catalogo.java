package org.alandoc.pixup.model;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Catalogo
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
=======
public abstract class Catalogo
{
    public Integer id;

    public Catalogo()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Catalogo{" +
                "id=" + id +
                '}';
    }
>>>>>>> cbb4b166cfd9062e113830306bf1d30d1dfb7707
}