package org.alandoc.pixup.model;

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
}