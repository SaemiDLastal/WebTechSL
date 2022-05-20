package de.htw.berlin.Einkaufsliste1.presistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitsRepo extends JpaRepository<FruitsEntity,Long> {

    List<FruitsEntity> findAllByName(String name);
}
