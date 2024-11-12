package fr.epsi.spring.demo.controller;

import fr.epsi.spring.demo.domain.Gare;
import fr.epsi.spring.demo.service.GareService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Book;

@RestController
@RequestMapping(value = "/v1/gares", produces = MediaType.APPLICATION_JSON_VALUE)
public class GareController {

    private GareService gareService;

    public GareController(GareService gareService) {
        this.gareService = gareService;
    }

    @Operation(description = "Permet de rechercher des gares")
    @GetMapping
    Page<Gare> search(Pageable page) {
        return gareService.findAll(page);
    }

    @Operation(description = "Permet de rechercher une gare à partir de son id")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Gare.class))}),
            @ApiResponse(responseCode = "404", description = "gare non trouvée", content = @Content())
    })
    @GetMapping("/{id}")
    Gare searchById(@PathVariable("id") Long id) throws NotFoundException{
        return gareService.findById(id).orElseThrow(()-> new NotFoundException());
    }


    @PostMapping
    ResponseEntity<Void> create(@RequestBody Gare gare) {
        this.gareService.save(gare);
        var createdObjectRequest = UriComponentsBuilder.fromPath("/v1/gares/{id}")
                .build(gare.getId());
        return ResponseEntity.created(createdObjectRequest).build();
    }
}
