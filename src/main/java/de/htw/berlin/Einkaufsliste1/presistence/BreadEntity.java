package de.htw.berlin.Einkaufsliste1.presistence;

import javax.persistence.*;

@Entity(name="Bread")
public class BreadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "cutted")
    private boolean cut;

    public BreadEntity(String name, boolean cut) {
        this.name = name;
        this.cut = cut;
    }
    protected BreadEntity(){}

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCut() {
        return cut;
    }

    public void setCut(boolean cut) {
        this.cut = cut;
    }
}
