package com.quangcao.bai3.POST;

public class ProductsPOST {
    private String name;
    private String price;
    private String desscription;

    public ProductsPOST() {
    }

    public ProductsPOST(String name, String price, String desscription) {
        this.name = name;
        this.price = price;
        this.desscription = desscription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesscription() {
        return desscription;
    }

    public void setDesscription(String desscription) {
        this.desscription = desscription;
    }
}
