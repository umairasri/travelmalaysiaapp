package com.example.travelmalaysia.Objects;

public class FavPlace {

    private String place_title;
    private String key_id;
    private int place_image;

    public FavPlace() {
    }

    public FavPlace(String place_title, String key_id, int place_image) {
        this.place_title = place_title;
        this.key_id = key_id;
        this.place_image = place_image;
    }

    public String getPlace_title() {
        return place_title;
    }

    public void setPlace_title(String place_title) {
        this.place_title = place_title;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public int getPlace_image() {
        return place_image;
    }

    public void setPlace_image(int place_image) {
        this.place_image = place_image;
    }
}
