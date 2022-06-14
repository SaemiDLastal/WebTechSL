package de.htw.berlin.Einkaufsliste1.web.api;

public class ItemsManipulationRequest {
    private String name;

    private String category;
    private double amount;



    public ItemsManipulationRequest(String name, String category, double amount) {
        this.name = name;
        this.category = category;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
