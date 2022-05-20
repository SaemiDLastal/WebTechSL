package de.htw.berlin.Einkaufsliste1.presistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VegetablesRepo extends JpaRepository<VegetablesEntity,Long> {

    List<VegetablesEntity> findAllByName(String name);
}

