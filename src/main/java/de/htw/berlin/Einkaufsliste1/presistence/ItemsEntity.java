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
    @ManyToMany
    Set<ShoppingListEntity> itemsForShoppingList;



    public ItemsEntity(String name, String category) {
        this.name = name;
        this.category = category;
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

    public Set<ShoppingListEntity> getItemsForShoppingList() {
        return itemsForShoppingList;
    }

    public void setItemsForShoppingList(Set<ShoppingListEntity> itemsForShoppingList) {
        this.itemsForShoppingList = itemsForShoppingList;
    }
}
