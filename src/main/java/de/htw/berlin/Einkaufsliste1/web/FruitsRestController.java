package de.htw.berlin.Einkaufsliste1.web;

import de.htw.berlin.Einkaufsliste1.Service.FruitsService;
import de.htw.berlin.Einkaufsliste1.web.api.Fruits;
import de.htw.berlin.Einkaufsliste1.web.api.FruitsManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path ="/api/v1/fruits/{id}" )
    public ResponseEntity<Fruits> fetchFruitsById(@PathVariable Long id){
        var fruit= fruitsService.findById(id);
        return  fruit != null? ResponseEntity.ok(fruit): ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/api/v1/fruits")
    public ResponseEntity<Void> createFruit(@RequestBody FruitsManipulationRequest request) throws URISyntaxException {
         var fruits=fruitsService.create(request);
         URI uri= new URI("/api/v1/fruits/" + fruits.getId());
         return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/fruits/{id}")
    public ResponseEntity<Fruits> updateFruit(@PathVariable Long id,@RequestBody FruitsManipulationRequest request){
        var fruit= fruitsService.update(id, request);
        return  fruit!=null? ResponseEntity.ok(fruit): ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/fruits/{id}")
    public ResponseEntity<Void> deletePersom(@PathVariable Long id){
        boolean completed= fruitsService.deleteById(id);
        return completed? ResponseEntity.ok().build(): ResponseEntity.notFound().build();
    }


}
