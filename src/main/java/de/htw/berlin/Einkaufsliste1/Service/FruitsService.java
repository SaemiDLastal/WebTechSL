package de.htw.berlin.Einkaufsliste1.Service;

import de.htw.berlin.Einkaufsliste1.presistence.FruitsEntity;
import de.htw.berlin.Einkaufsliste1.presistence.FruitsRepo;
import de.htw.berlin.Einkaufsliste1.web.api.Fruits;
import de.htw.berlin.Einkaufsliste1.web.api.FruitsManipulationRequest;
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
    public Fruits findById(Long id){
        var fruitsEntity= fruitsRepo.findById(id);
        return fruitsEntity.map(this::transfromEntity).orElse(null);
    }
    public Fruits create(FruitsManipulationRequest request){
        var fruitsEntity= new FruitsEntity( request.getName(), request.isBio());
       fruitsEntity= fruitsRepo.save(fruitsEntity);
       return transfromEntity(fruitsEntity);
    }

    public Fruits update(Long id, FruitsManipulationRequest request){
        var fruitsEntityOptional= fruitsRepo.findById(id);
        if(fruitsEntityOptional.isEmpty()){
            return null;
        }
        var fruitsEntity = fruitsEntityOptional.get();
        fruitsEntity.setName(request.getName());
        fruitsEntity.setBio(request.isBio());
        fruitsEntity= fruitsRepo.save(fruitsEntity);
        return transfromEntity(fruitsEntity);
    }

    public boolean deleteById(Long id){
        if(fruitsRepo.existsById(id)){
            return false;
        }
        fruitsRepo.deleteById(id);
        return true;
    }

    private Fruits transfromEntity(FruitsEntity fruitsEntity) {

        return new Fruits(fruitsEntity.getId(), fruitsEntity.getName(), fruitsEntity.isBio());
    }
}
