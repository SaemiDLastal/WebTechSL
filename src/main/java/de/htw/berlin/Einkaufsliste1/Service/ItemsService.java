package de.htw.berlin.Einkaufsliste1.Service;

import de.htw.berlin.Einkaufsliste1.presistence.ItemsEntity;
import de.htw.berlin.Einkaufsliste1.presistence.ItemsRepo;
import de.htw.berlin.Einkaufsliste1.web.api.Items;
import de.htw.berlin.Einkaufsliste1.web.api.ItemsManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemsService {
    private final ItemsRepo itemsRepo;

    public ItemsService(ItemsRepo itemsRepo) {
        this.itemsRepo = itemsRepo;

    }
    public List<Items> findAll(){
        List<ItemsEntity> items= itemsRepo.findAll();
        return items.stream().map(this::transfromEntity
                ).collect(Collectors.toList());
    }
    public Items findById(Long id){
        var itemsEntity= itemsRepo.findById(id);
        return itemsEntity.map(this::transfromEntity).orElse(null);
    }
    public Items create(ItemsManipulationRequest request){
        var itemsEntity= new ItemsEntity( request.getName(), request.getCategory(), request.getAmount());
       itemsEntity= itemsRepo.save(itemsEntity);
       return transfromEntity(itemsEntity);
    }

    public Items update(Long id, ItemsManipulationRequest request){
        var itemsEntityOptional= itemsRepo.findById(id);
        if(itemsEntityOptional.isEmpty()){
            return null;
        }
        var itemsEntity = itemsEntityOptional.get();
        itemsEntity.setName(request.getName());

       itemsEntity.setAmount(request.getAmount());
        itemsEntity= itemsRepo.save(itemsEntity);
        return transfromEntity(itemsEntity);
    }

    public boolean deleteById(Long id){
        if(itemsRepo.existsById(id)){
            return false;
        }
        itemsRepo.deleteById(id);
        return true;
    }

    private Items transfromEntity(ItemsEntity itemsEntity) {

        return new Items(itemsEntity.getId(), itemsEntity.getName(), itemsEntity.getCategory(), itemsEntity.getAmount());
    }
}
