package de.htw.berlin.Einkaufsliste1.web.api;

public class VegetablesCreateRequest {

    private String name;
    private boolean bio;

    public VegetablesCreateRequest(String name, boolean bio) {
        this.name = name;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBio() {
        return bio;
    }

    public void setBio(boolean bio) {
        this.bio = bio;
    }
}
