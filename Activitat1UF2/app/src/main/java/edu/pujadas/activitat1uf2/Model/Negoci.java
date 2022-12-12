package edu.pujadas.activitat1uf2.Model;

public class Negoci
{
    int idNegoci;
    String nom;
    String tipusNegoci;
    int longitud;
    int latitud;

    public Negoci()
    {
    }

    public Negoci(int idNegoci, String nom, String tipusNegoci, int longitud, int latitud)
    {
        this.idNegoci = idNegoci;
        this.nom = nom;
        this.tipusNegoci = tipusNegoci;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public int getIdNegoci()
    {
        return idNegoci;
    }

    public void setIdNegoci(int idNegoci)
    {
        this.idNegoci = idNegoci;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getTipusNegoci()
    {
        return tipusNegoci;
    }

    public void setTipusNegoci(String tipusNegoci)
    {
        this.tipusNegoci = tipusNegoci;
    }

    public int getLongitud()
    {
        return longitud;
    }

    public void setLongitud(int longitud)
    {
        this.longitud = longitud;
    }

    public int getLatitud()
    {
        return latitud;
    }

    public void setLatitud(int latitud)
    {
        this.latitud = latitud;
    }
}
