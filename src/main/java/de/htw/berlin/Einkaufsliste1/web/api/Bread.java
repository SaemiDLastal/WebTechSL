package de.htw.berlin.Einkaufsliste1.web.api;

public class Bread {

    private long id;
    private String name;
    private int amount;
    private boolean cut;

    public Bread(long id, String name, boolean cut) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.cut = cut;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isCut() {
        return cut;
    }

    public void setCut(boolean cut) {
        this.cut = cut;
    }
}
