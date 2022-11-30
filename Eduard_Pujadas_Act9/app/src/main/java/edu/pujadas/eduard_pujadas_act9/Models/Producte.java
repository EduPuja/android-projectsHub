package edu.pujadas.eduard_pujadas_act9.Models;

import android.media.Image;

public class Producte
{   private String marcaProducte;
    private String modelProducte;
    private String quantitat;
    private String rutaImatge;


    /**
     * Builder
     */
    public Producte()
    {

    }

    public void setAllProducte(String marcaProducte, String modelProducte, String quantitat, String rutaImatge)
    {
        this.marcaProducte = marcaProducte;
        this.modelProducte = modelProducte;
        this.quantitat = quantitat;
        this.rutaImatge = rutaImatge;
    }

    public String  getInfoProduct()
    {
        return this.marcaProducte +" "+this.modelProducte+" "+this.quantitat+" "+this.rutaImatge;
    }


    // setters


    public void setMarcaProducte(String marcaProducte)
    {
        this.marcaProducte = marcaProducte;
    }

    public void setModelProducte(String modelProducte)
    {
        this.modelProducte = modelProducte;
    }

    public void setQuantitat(String quantitat)
    {
        this.quantitat = quantitat;
    }

    public void setImageProducte(String rutaImatge)
    {
        this.rutaImatge = rutaImatge;
    }



    // getters


    public String getMarcaProducte()
    {
        return marcaProducte;
    }

    public String getModelProducte()
    {
        return modelProducte;
    }

    public String getQuantitat()
    {
        return quantitat;
    }

    public String getRutaImatge()
    {
        return rutaImatge;
    }

  
}
