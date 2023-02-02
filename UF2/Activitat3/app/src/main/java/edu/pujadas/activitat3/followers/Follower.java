package edu.pujadas.activitat3.followers;

import android.graphics.Bitmap;


public class Follower
{

    private String nameFollower;
    private Bitmap avatarFollower;


    public Follower()
    {

    }

    public Follower(String nameFollower, Bitmap avatarFollower)
    {
        this.nameFollower = nameFollower;
        this.avatarFollower = avatarFollower;
    }

    public String getNameFollower()
    {
        return nameFollower;
    }

    public void setNameFollower(String nameFollower)
    {
        this.nameFollower = nameFollower;
    }

    public Bitmap getAvatarFollower()
    {
        return avatarFollower;
    }

    public void setAvatarFollower(Bitmap avatarFollower)
    {
        this.avatarFollower = avatarFollower;
    }
}
