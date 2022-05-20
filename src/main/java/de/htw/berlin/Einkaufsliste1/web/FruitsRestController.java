package de.htw.berlin.Einkaufsliste1.web;

import de.htw.berlin.Einkaufsliste1.Service.FruitsService;
import de.htw.berlin.Einkaufsliste1.web.api.Fruits;
import de.htw.berlin.Einkaufsliste1.web.api.FruitsCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;



@RestController
public class FruitsRestController {
    private final FruitsService fruitsService;

    public FruitsRestController(FruitsService fruitsService) {
        this.fruitsService = fruitsService;
    }
    @GetMapping(path= "/api/v1/fruits")
    public ResponseEntity<List<Fruits>> fetchFruits()
    {

        return ResponseEntity.ok(fruitsService.findAll());
    }

    @PostMapping(path = "/api/v1/fruits")
    public ResponseEntity<Void> createFruit(@RequestBody FruitsCreateRequest request) throws URISyntaxException {
         var fruits=fruitsService.create(request);
         URI uri= new URI("/api/v1/fruits" + fruits.getId());
         return ResponseEntity.created(uri).build();
    }


}
