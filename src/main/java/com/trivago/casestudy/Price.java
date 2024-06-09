package com.trivago.casestudy;

public class Price {

    private String currency;
    private String price;

    public Price() {}

    public Price(String currency, String price) {
        this.currency = currency;
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
