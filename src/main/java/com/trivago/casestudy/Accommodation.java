package com.trivago.casestudy;

import java.util.List;

public class Accommodation {

    private int id;
    private List<Price> prices;

    public Accommodation() {}

    public Accommodation(int id, List<Price> prices) {
        this.id = id;
        this.prices = prices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
