package de.htw.berlin.Einkaufsliste1.web.api;

public class Items {
    private long id;
    private String name;
    private String category;



    public Items(long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
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
