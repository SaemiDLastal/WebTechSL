package de.htw.berlin.Einkaufsliste1.presistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreadRepo extends JpaRepository<BreadEntity, Long> {

    List<BreadEntity> findAllByName(String name);

}
