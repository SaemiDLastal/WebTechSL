package de.htw.berlin.Einkaufsliste1.web.api;



public class Vegetables {

    private long id;
    private String name;
    private boolean bio;

    public Vegetables(long id, String name, boolean bio) {
        this.id = id;
        this.name = name;
        this.bio = bio;
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

    public boolean isBio() {
        return bio;
    }

    public void setBio(boolean bio) {
        this.bio = bio;
    }
}
