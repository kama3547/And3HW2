package com.example.and3hw2.model;

import com.google.gson.annotations.SerializedName;

public class Character {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("status")
    private String status;

    @SerializedName("species")
    private String species;

    @SerializedName("gender")
    private String gender;

    @SerializedName("image")
    private String image;

    @SerializedName("created")
    private String created;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}
