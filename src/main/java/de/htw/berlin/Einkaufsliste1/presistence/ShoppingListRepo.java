package de.htw.berlin.Einkaufsliste1.presistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListRepo extends JpaRepository<ShoppingListEntity,Long> {

    List<ShoppingListEntity> findAllByTitle(String title);
}
