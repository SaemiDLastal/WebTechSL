package de.htw.berlin.Einkaufsliste1.web.api;

public class BreadCreateRequest {

    private String name;
    private int amount;
    private boolean cut;

    public BreadCreateRequest(String name, int amount, boolean cut) {
        this.name = name;
        this.amount = amount;
        this.cut = cut;
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
