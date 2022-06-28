package de.htw.berlin.Einkaufsliste1.web;

import de.htw.berlin.Einkaufsliste1.Service.ShoppingListService;
import de.htw.berlin.Einkaufsliste1.presistence.ShoppingListEntity;
import de.htw.berlin.Einkaufsliste1.web.api.ShoppingList;
import de.htw.berlin.Einkaufsliste1.web.api.ShoppingListCreateRequest;
import de.htw.berlin.Einkaufsliste1.web.api.ShoppingListManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ShoppingListRestController {

    private final ShoppingListService shoppingListService;

    public ShoppingListRestController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping(path = "/api/v1/shoppinglist")
    public ResponseEntity<List<ShoppingList>> fetchShoppingList(){

        return ResponseEntity.ok(shoppingListService.findAll());
    }

    @GetMapping(path = "/api/v1/shoppinglist/{id}")
    public ResponseEntity<ShoppingList> fetchShoppingListsById(@PathVariable Long id){
        var shoppingList= shoppingListService.findById(id);

        return shoppingList != null? ResponseEntity.ok(shoppingList): ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/shoppinglist")
    public ResponseEntity<Void> createShoppingList(@RequestBody ShoppingListCreateRequest request) throws URISyntaxException {
        var shoppingList = shoppingListService.create(request);
        URI uri = new URI("/api/v1/shoppinglist/" + shoppingList.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/api/v1/shoppinglist/{id}")
    public ResponseEntity<ShoppingList> updateShoppingList(@RequestBody ShoppingListManipulationRequest request, @PathVariable Long id){
        var shoppingList= shoppingListService.update(id, request);
        return shoppingList != null? ResponseEntity.ok(shoppingList): ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/shoppinglist/{id}")
    public ResponseEntity<ShoppingList> deleteShoppingList(@PathVariable Long id){
        boolean completed= shoppingListService.deleteById(id);
        return completed? ResponseEntity.ok().build(): ResponseEntity.notFound().build();
    }
}
