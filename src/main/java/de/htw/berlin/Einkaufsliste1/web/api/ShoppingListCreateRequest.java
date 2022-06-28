package de.htw.berlin.Einkaufsliste1.web.api;


public class ShoppingListCreateRequest {

    private String title;
    private double amount;
    private boolean bought;
//    private List<Items> shoppingList;

    public ShoppingListCreateRequest(String title, double amount, boolean bought) {
        this.title = title;
        this.amount = amount;
        this.bought = bought;
    }

    public ShoppingListCreateRequest() {
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

//    public List<Items> getShoppingList() {
//        return shoppingList;
//    }
//
//    public void setShoppingList(List<Items> shoppingList) {
//        this.shoppingList = shoppingList;
//    }
}
