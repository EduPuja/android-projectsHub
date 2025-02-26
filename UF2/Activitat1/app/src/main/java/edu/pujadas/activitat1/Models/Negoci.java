package edu.pujadas.activitat1.Models;

public class Negoci
{
     int idNegoci;
     String nom;
     String tipusNegoci;
     double latitud;
     double longitud;

    public Negoci()
    {
    }

    public Negoci(int idNegoci, String nom, String tipusNegoci, double latitud, double longitud)
    {
        this.idNegoci = idNegoci;
        this.nom = nom;
        this.tipusNegoci = tipusNegoci;
        this.latitud = latitud;
        this.longitud = longitud;
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

    public double getLatitud()
    {
        return latitud;
    }

    public void setLatitud(int latitud)
    {
        this.latitud = latitud;
    }

    public double getLongitud()
    {
        return longitud;
    }

    public void setLongitud(int longitud)
    {
        this.longitud = longitud;
    }
}
