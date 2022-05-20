package de.htw.berlin.Einkaufsliste1.web;

import de.htw.berlin.Einkaufsliste1.Service.VegetablesService;
import de.htw.berlin.Einkaufsliste1.web.api.Vegetables;
import de.htw.berlin.Einkaufsliste1.web.api.VegetablesCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class VegetablesRestController {
    private final VegetablesService vegetablesService;

    public VegetablesRestController(VegetablesService vegetablesService) {

        this.vegetablesService = vegetablesService;
    }


    @GetMapping(path= "/api/v1/vegetables")
        public ResponseEntity<List<Vegetables>> fetchvegetables()
        {
            return ResponseEntity.ok(vegetablesService.findAll());
        }

        @PostMapping(path = "/api/v1/vegetables")
        public ResponseEntity<Void> createVegetable(@RequestBody VegetablesCreateRequest request) throws URISyntaxException {
            var vegetables= vegetablesService.create(request);
            URI uri = new URI("/api/v1/vegetables");
            return ResponseEntity.created(uri).build();
        }


}
