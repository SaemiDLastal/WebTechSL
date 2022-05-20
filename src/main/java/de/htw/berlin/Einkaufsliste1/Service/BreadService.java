package de.htw.berlin.Einkaufsliste1.Service;

import de.htw.berlin.Einkaufsliste1.presistence.BreadEntity;
import de.htw.berlin.Einkaufsliste1.presistence.BreadRepo;
import de.htw.berlin.Einkaufsliste1.web.api.Bread;
import de.htw.berlin.Einkaufsliste1.web.api.BreadCreateRequest;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
@Service
public class BreadService {

    private final BreadRepo breadRepo;

    public BreadService(BreadRepo breadRepo) {
        this.breadRepo = breadRepo;
    }
    public List<Bread> findAll(){
        List<BreadEntity> breads= breadRepo.findAll();
        return breads.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public Bread create(BreadCreateRequest request)
    {
        var breadEntity= new BreadEntity(request.getName(),request.isCut());
        breadEntity= breadRepo.save(breadEntity);
        return transformEntity(breadEntity);

    }
    private Bread transformEntity(BreadEntity breadEntity){

        return new Bread(breadEntity.getId(),breadEntity.getName(),breadEntity.isCut());
    }
}
