package edu.pujadas.therecyclerview.Model;

import android.graphics.Bitmap;

public class Persona
{
    private Bitmap avatar;
    private String nom;
    private String cognom;


    public Persona()
    {
    }

    public Persona(Bitmap avatar, String nom, String cognom)
    {
        this.avatar = avatar;
        this.nom = nom;
        this.cognom = cognom;
    }

    public Bitmap getAvatar()
    {
        return avatar;
    }

    public void setAvatar(Bitmap avatar)
    {
        this.avatar = avatar;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getCognom()
    {
        return cognom;
    }

    public void setCognom(String cognom)
    {
        this.cognom = cognom;
    }
}

