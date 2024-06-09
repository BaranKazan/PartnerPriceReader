package com.trivago.casestudy;

import java.util.List;

public class Advertiser {

    private String name;
    private int id;
    private List<Accommodation> accommodation;

    public Advertiser() {}

    public Advertiser(String name, int id, List<Accommodation> accommodation) {
        this.name = name;
        this.id = id;
        this.accommodation = accommodation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Accommodation> getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(List<Accommodation> accommodation) {
        this.accommodation = accommodation;
    }
}
