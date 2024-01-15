package edu.pujadas.Models;


import com.google.android.gms.maps.model.LatLng;

public class Tienda {

    int id;
    String name;
    Tipus type;

    LatLng position;

    public Tienda(int id, String name, Tipus type,LatLng position) {
        this.id = id;
        this.name = name;
        this.type = type;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tipus getType() {
        return type;
    }

    public void setType(Tipus type) {
        this.type = type;
    }


    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }
}
