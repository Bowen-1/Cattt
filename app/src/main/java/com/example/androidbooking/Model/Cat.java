package com.example.androidbooking.Model;

public class Cat {
    static int id = 0;
    private String name;
    private String temperament;
    private String wikipedia_url;

    public Cat(String name) {
        this.name = name;
        id++;
    }

    public Cat(String name, String temperament, String wikipedia_url) {
        this.name = name;
        this.temperament = temperament;
        this.wikipedia_url = wikipedia_url;
    }

    public Cat() {
        id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", temperament='" + temperament + '\'' +
                ", wikipedia_url='" + wikipedia_url + '\'' +
                '}';
    }
}


