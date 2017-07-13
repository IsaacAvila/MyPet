package com.example.hobo.mypet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PetsList extends AppCompatActivity {

    private int photo, likes;
    private String name;

    public PetsList(int photo, int likes, String name) {
        this.photo = photo;
        this.likes = likes;
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
