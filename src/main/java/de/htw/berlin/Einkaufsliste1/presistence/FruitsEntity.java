package de.htw.berlin.Einkaufsliste1.presistence;


import javax.persistence.*;


@Entity(name="fruits")
public class FruitsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;
    @Column(name= "name",nullable = false)
    private String name;
    @Column(name= "is_bio")
    private boolean bio;

    public FruitsEntity( String name, boolean bio) {
        this.name = name;
        this.bio = bio;
    }

    protected FruitsEntity() {}

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
