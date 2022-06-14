package de.htw.berlin.Einkaufsliste1.presistence;

import javax.persistence.*;

@Entity(name= "created_shopping_list")
public class CreatedShoppingListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "items_id", referencedColumnName = "id")
    private ItemsEntity items;

    @ManyToOne
    @JoinColumn(name = "shoppongList_id", referencedColumnName = "id")
    private ShoppingListEntity shoppingList;

    protected CreatedShoppingListEntity(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ItemsEntity getItems() {
        return items;
    }

    public void setItems(ItemsEntity items) {
        this.items = items;
    }

    public ShoppingListEntity getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingListEntity shoppingList) {
        this.shoppingList = shoppingList;
    }

}
