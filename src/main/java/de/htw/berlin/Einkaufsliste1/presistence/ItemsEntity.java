package de.htw.berlin.Einkaufsliste1.presistence;


import javax.persistence.*;
import java.util.Set;


@Entity(name="items")
public class ItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;
    @Column(name= "name",nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    private String category;
    @Column(name= "amount")
    private double amount;


    @OneToMany(mappedBy = "items")
    Set<CreatedShoppingListEntity> createdShoppingList;

    public ItemsEntity(String name, String category, double amount) {
        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    protected ItemsEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public Set<CreatedShoppingListEntity> getCreatedShoppingList() {
        return createdShoppingList;
    }

    public void setCreatedShoppingList(Set<CreatedShoppingListEntity> createdShoppingList) {
        this.createdShoppingList = createdShoppingList;
    }

    public Set<CreatedShoppingListEntity> createdShoppingList(){
        return createdShoppingList;
    }
}
