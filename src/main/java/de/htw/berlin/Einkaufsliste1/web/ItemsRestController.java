package de.htw.berlin.Einkaufsliste1.web;

import de.htw.berlin.Einkaufsliste1.Service.ItemsService;
import de.htw.berlin.Einkaufsliste1.web.api.Items;
import de.htw.berlin.Einkaufsliste1.web.api.ItemsManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;



@RestController
public class ItemsRestController {
    private final ItemsService itemsService;

    public ItemsRestController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }
    @GetMapping(path= "/api/v1/items")
    public ResponseEntity<List<Items>> fetchItems()
    {

        return ResponseEntity.ok(itemsService.findAll());
    }

    @GetMapping(path ="/api/v1/items/{id}" )
    public ResponseEntity<Items> fetchItemsById(@PathVariable Long id){
        var items= itemsService.findById(id);
        return  items != null? ResponseEntity.ok(items): ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/api/v1/items")
    public ResponseEntity<Void> createItems(@RequestBody ItemsManipulationRequest request) throws URISyntaxException {
         var items= itemsService.create(request);
         URI uri= new URI("/api/v1/items/" + items.getId());
         return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/items/{id}")
    public ResponseEntity<Items> updateItems(@PathVariable Long id, @RequestBody ItemsManipulationRequest request){
        var items= itemsService.update(id, request);
        return  items!=null? ResponseEntity.ok(items): ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/items/{id}")
    public ResponseEntity<Void> deleteItems(@PathVariable Long id){
        boolean completed= itemsService.deleteById(id);
        return completed? ResponseEntity.ok().build(): ResponseEntity.notFound().build();
    }


}
