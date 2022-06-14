package de.htw.berlin.Einkaufsliste1.web.api;

import java.util.List;

public class ShoppingList {

    private long id;

    private String title;

    private double amount;
    private boolean bought;
    private List<Items> shoppingList;

    public ShoppingList(long id, String title, double amount, boolean bought, List<Items> shoppingList) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.bought = bought;
        this.shoppingList = shoppingList;
    }

    public ShoppingList() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Items> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Items> shoppingList) {
        this.shoppingList = shoppingList;
    }
}
