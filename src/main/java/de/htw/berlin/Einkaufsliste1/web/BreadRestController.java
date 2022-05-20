package de.htw.berlin.Einkaufsliste1.web;

import de.htw.berlin.Einkaufsliste1.Service.BreadService;
import de.htw.berlin.Einkaufsliste1.web.api.Bread;
import de.htw.berlin.Einkaufsliste1.web.api.BreadCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class BreadRestController {

        private final BreadService breadService;

    public BreadRestController(BreadService breadService) {
        this.breadService = breadService;
    }


    @GetMapping(path= "/api/v1/bread")
        public ResponseEntity<List<Bread>> fetchBread()
        {

            return ResponseEntity.ok(breadService.findAll());
        }
        @PostMapping(name = "/api/v1/bread")
    public ResponseEntity<Void> createBread( @RequestBody BreadCreateRequest request) throws URISyntaxException {
        var breads= breadService.create(request);
        URI uri= new URI("/api/v1/bread");
        return ResponseEntity.created(uri).build();

        }

    }
