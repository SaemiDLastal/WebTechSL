package de.htw.berlin.Einkaufsliste1.web.api;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Embeddable
public class CreatedShoppingList implements Serializable {

    @Column(name = "items_id")
    private long itemsId;

    @Column(name = "shoppingList_id")
    private long shoppingListId;


    public long getItemsId() {
        return itemsId;
    }

    public void setItemsId(long itemsId) {
        this.itemsId = itemsId;
    }

    public long getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(long shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatedShoppingList that = (CreatedShoppingList) o;
        return itemsId == that.itemsId && shoppingListId == that.shoppingListId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemsId, shoppingListId);
    }
}
