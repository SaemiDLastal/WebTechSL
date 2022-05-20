package de.htw.berlin.Einkaufsliste1.Service;

import de.htw.berlin.Einkaufsliste1.presistence.FruitsEntity;
import de.htw.berlin.Einkaufsliste1.presistence.FruitsRepo;
import de.htw.berlin.Einkaufsliste1.web.api.Fruits;
import de.htw.berlin.Einkaufsliste1.web.api.FruitsCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FruitsService {
    private final FruitsRepo fruitsRepo;

    public FruitsService(FruitsRepo fruitsRepo) {
        this.fruitsRepo = fruitsRepo;

    }
    public List<Fruits> findAll(){
        List<FruitsEntity> fruits= fruitsRepo.findAll();
        return fruits.stream().map(this::transfromEntity
                ).collect(Collectors.toList());
    }
    public Fruits create(FruitsCreateRequest request){
        var fruitsEntity= new FruitsEntity( request.getName(), request.isBio());
       fruitsEntity= fruitsRepo.save(fruitsEntity);
       return transfromEntity(fruitsEntity);
    }

    private Fruits transfromEntity(FruitsEntity fruitsEntity) {

        return new Fruits(fruitsEntity.getId(), fruitsEntity.getName(), fruitsEntity.isBio());
    }
}
