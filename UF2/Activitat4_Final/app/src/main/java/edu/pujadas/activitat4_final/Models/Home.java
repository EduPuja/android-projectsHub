package edu.pujadas.activitat4_final.Models;

import android.graphics.Bitmap;

public class Home
{
    private String name;
    private Bitmap img;

    public Home()
    {

    }

    public Home(String name, Bitmap img)
    {
        this.name = name;
        this.img = img;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Bitmap getImg()
    {
        return img;
    }

    public void setImg(Bitmap img)
    {
        this.img = img;
    }
}
