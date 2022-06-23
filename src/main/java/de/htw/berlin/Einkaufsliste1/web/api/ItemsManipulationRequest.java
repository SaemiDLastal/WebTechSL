package de.htw.berlin.Einkaufsliste1.web.api;

public class ItemsManipulationRequest {
    private String name;

    private String category;



    public ItemsManipulationRequest(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public ItemsManipulationRequest() {
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
