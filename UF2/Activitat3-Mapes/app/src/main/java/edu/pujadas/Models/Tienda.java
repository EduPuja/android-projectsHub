package edu.pujadas.Models;



public class Tienda {

    int id;
    String name;
    Tipus type;

    float latitude;
    float longitude;

    public Tienda(int id, String name, Tipus type, float latitude, float longitude) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
