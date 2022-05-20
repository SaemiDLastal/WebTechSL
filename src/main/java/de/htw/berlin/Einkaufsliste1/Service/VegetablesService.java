package de.htw.berlin.Einkaufsliste1.Service;

import de.htw.berlin.Einkaufsliste1.presistence.VegetablesEntity;
import de.htw.berlin.Einkaufsliste1.presistence.VegetablesRepo;
import de.htw.berlin.Einkaufsliste1.web.api.Vegetables;
import de.htw.berlin.Einkaufsliste1.web.api.VegetablesCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VegetablesService {

    private final VegetablesRepo vegetablesRepo;

    public VegetablesService(VegetablesRepo vegetablesRepo) {
        this.vegetablesRepo = vegetablesRepo;
    }

    public List<Vegetables> findAll(){
        List<VegetablesEntity> vegs= vegetablesRepo.findAll();
        return vegs.stream().map(this::transformEntity
        ).collect(Collectors.toList());
    }
    public Vegetables create(VegetablesCreateRequest request){
        var vegetablesEntity = new VegetablesEntity(request.getName(),request.isBio());
        vegetablesEntity= vegetablesRepo.save(vegetablesEntity);
        return transformEntity(vegetablesEntity);
    }

    private Vegetables transformEntity(VegetablesEntity vegetablesEntity)
    {
        return new Vegetables(vegetablesEntity.getId(),vegetablesEntity.getName(),vegetablesEntity.isBio());
    }
}
