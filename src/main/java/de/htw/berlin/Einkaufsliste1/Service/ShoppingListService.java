package de.htw.berlin.Einkaufsliste1.Service;

import de.htw.berlin.Einkaufsliste1.presistence.ItemsEntity;
import de.htw.berlin.Einkaufsliste1.presistence.ShoppingListEntity;
import de.htw.berlin.Einkaufsliste1.presistence.ShoppingListRepo;
import de.htw.berlin.Einkaufsliste1.web.api.Items;
import de.htw.berlin.Einkaufsliste1.web.api.ShoppingList;
import de.htw.berlin.Einkaufsliste1.web.api.ShoppingListCreateRequest;
import de.htw.berlin.Einkaufsliste1.web.api.ShoppingListManipulationRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShoppingListService {

    private final ShoppingListRepo shoppingListRepo;

    public ShoppingListService(ShoppingListRepo shoppingListRepo) {
        this.shoppingListRepo = shoppingListRepo;
    }

    @Transactional
    public List<ShoppingList> findAll(){
        List<ShoppingListEntity> shoppingLists = shoppingListRepo.findAll();
        List<ShoppingList> shoppList = new ArrayList<>();

        for(ShoppingListEntity shoppingListEntity: shoppingLists) {
            ArrayList<Items> items= new ArrayList<>();
            Set<ItemsEntity> createdShoppingList = shoppingListEntity.getCreatedShoppingList();
            for(ItemsEntity createdShoppingLists : createdShoppingList)
            {
                items.add(new Items(createdShoppingLists.getId(),createdShoppingLists.getName(),createdShoppingLists.getCategory()/*,createdShoppingLists.getAmount()*/));
            }
            ShoppingList shoppingList= new ShoppingList(shoppingListEntity.getId(),shoppingListEntity.getTitle(),shoppingListEntity.getAmount(),shoppingListEntity.isBought(),items);
            shoppList.add(shoppingList);
        }
        return shoppList;
    }

    public ShoppingList findById(Long id){
        var shoppingEntity= shoppingListRepo.findById(id);
        return shoppingEntity.map(this::transformEntity).orElse(null);
    }

    public ShoppingList create(ShoppingListCreateRequest request){
        var shoppingListEntity= new ShoppingListEntity
                (request.getTitle()
                ,request.getAmount()
                ,request.isBought());

        shoppingListEntity= shoppingListRepo.save(shoppingListEntity);
        return transformEntity(shoppingListEntity);
    }

    public ShoppingList update(Long id, ShoppingListManipulationRequest request){
        var shoppingListEntityOptional= shoppingListRepo.findById(id);
        if(shoppingListEntityOptional.isEmpty())
            return null;
        var shoppingListEntity= shoppingListEntityOptional.get();
        shoppingListEntity.setTitle(request.getTitle());
        shoppingListEntity.setAmount(request.getAmount());
        shoppingListEntity.setBought(request.isBought());

        shoppingListEntity= shoppingListRepo.save(shoppingListEntity);
        return transformEntity(shoppingListEntity);

    }

    public boolean deleteById(Long id){
        if(shoppingListRepo.existsById(id))
            return false;
        shoppingListRepo.deleteById(id);
        return true;
    }

    private ShoppingList transformEntity(ShoppingListEntity shoppingListEntity){
        ArrayList<Items> items= new ArrayList<>();
        return new ShoppingList(
                shoppingListEntity.getId(),
                shoppingListEntity.getTitle(),
                shoppingListEntity.getAmount(),
                shoppingListEntity.isBought(),
                items
        );
    }

}
