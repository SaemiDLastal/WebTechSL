package de.htw.berlin.Einkaufsliste1.presistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepo extends JpaRepository<ItemsEntity,Long> {

    List<ItemsEntity> findAllByName(String name);
}
