package de.htw.berlin.Einkaufsliste1.web.api;

public class Items {
    private long id;
    private String name;

    private String category;
    private double amount;


    public Items(long id, String name, String category, double amount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
