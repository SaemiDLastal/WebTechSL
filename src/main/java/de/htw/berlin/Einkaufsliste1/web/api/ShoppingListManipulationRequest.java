package de.htw.berlin.Einkaufsliste1.web.api;

import java.util.List;

public class ShoppingListManipulationRequest {

    private String title;
    private double amount;
    private boolean bought;

    public ShoppingListManipulationRequest(String title, double amount, boolean bought) {
        this.title = title;
        this.amount = amount;
        this.bought = bought;
    }

    public ShoppingListManipulationRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

}
