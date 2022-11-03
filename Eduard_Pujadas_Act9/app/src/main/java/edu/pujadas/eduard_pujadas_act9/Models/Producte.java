package edu.pujadas.eduard_pujadas_act9.Models;

import android.media.Image;

public class Producte
{   private String marcaProducte;
    private String modelProducte;
    private int quantitat;
    private Image imageProducte;


    /**
     * Builder
     */
    public Producte()
    {

    }

    public void setAllProducte(String marcaProducte, String modelProducte, int quantitat, Image imageProducte)
    {
        this.marcaProducte = marcaProducte;
        this.modelProducte = modelProducte;
        this.quantitat = quantitat;
        this.imageProducte = imageProducte;
    }

    public String  getInfoProduct()
    {
        return this.marcaProducte +" "+this.modelProducte+" "+this.quantitat+" "+this.imageProducte;
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

    public void setQuantitat(int quantitat)
    {
        this.quantitat = quantitat;
    }

    public void setImageProducte(Image imageProducte)
    {
        this.imageProducte = imageProducte;
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

    public int getQuantitat()
    {
        return quantitat;
    }

    public Image getImageProducte()
    {
        return imageProducte;
    }
}
