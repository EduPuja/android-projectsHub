package edu.pujadas.eduard_pujadas_act8.Models;

public class Valoracions
{



    private String nomUser;
    private String descrip;
    private int punts;

    public Valoracions ()
    {

    }



    // SEETTERS
    public void setAllValoration(String nomUser,String descrip,int punts)
    {
        this.descrip=descrip;
        this.nomUser=nomUser;
        this.punts=punts;
    }

    public String getInfoValo()
    {
        return this.nomUser +" "+this.descrip+" "+this.punts;
    }


    public void setNomUser(String nomUser)
    {
        this.nomUser = nomUser;
    }
    public void setDescrip(String descrip)
    {
        this.descrip = descrip;
    }

    public void setPunts(int punts)
    {
        this.punts = punts;
    }




    //GETTERS
    public String getNomUser()
    {
        return nomUser;
    }


    public String getDescrip()
    {
        return descrip;
    }



    public int getPunts()
    {
        return punts;
    }





}
