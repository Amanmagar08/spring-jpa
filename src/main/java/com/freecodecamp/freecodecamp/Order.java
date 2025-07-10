package com.freecodecamp.freecodecamp;

public class Order {
    private String name;
    private String product;
    private int quantity;

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
