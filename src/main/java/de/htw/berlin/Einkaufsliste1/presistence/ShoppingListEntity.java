package de.htw.berlin.Einkaufsliste1.presistence;

import de.htw.berlin.Einkaufsliste1.web.api.Items;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ShoppingListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "amount")
    private double amount;

    @Column(name="bought")
    private boolean bought;

    @ManyToMany
    Set<ItemsEntity> createdShoppingList;



    public ShoppingListEntity( String title, double amount, boolean bought) {
        this.title = title;
        this.amount = amount;
        this.bought = bought;
    }

    public ShoppingListEntity() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public Set<ItemsEntity> getCreatedShoppingList() {
        return createdShoppingList;
    }

    public void setCreatedShoppingList(Set<ItemsEntity> createdShoppingList) {
        this.createdShoppingList = createdShoppingList;
    }
}
