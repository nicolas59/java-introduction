package fr.epsi.spring.demo.web.v1.controller;

import fr.epsi.spring.demo.entity.GareEntity;
import fr.epsi.spring.demo.web.v1.dto.Guichet;
import fr.epsi.spring.demo.web.v1.mapper.GareMapper;
import fr.epsi.spring.demo.web.v1.dto.Gare;
import fr.epsi.spring.demo.service.GareService;
import fr.epsi.spring.demo.web.v1.mapper.GuichetMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/gares", produces = MediaType.APPLICATION_JSON_VALUE)
public class GareController {

    private GareService gareService;

    private GareMapper mapper;
    private GuichetMapper guichetMapper;

    public GareController(GareService gareService, GareMapper mapper, GuichetMapper guichetMapper) {
        this.gareService = gareService;
        this.mapper = mapper;
        this.guichetMapper = guichetMapper;
    }

    @Operation(description = "Permet de rechercher des gares")
    @GetMapping
    Page<Gare> search(Pageable page) {
        return gareService.findAll(page).map(mapper::gareEntityToGare);
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
        return gareService.findById(id).map(mapper::gareEntityToGare).orElseThrow(()-> new NotFoundException());
    }


    @Operation(description = "Permet de fournir la liste des guichets d'une gare")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Guichet.class))})
    })
    @GetMapping("/{id}/guichets")
    List<Guichet> allGuichets(@PathVariable("id") Long id) throws NotFoundException{
        return gareService.findById(id)
                .map(GareEntity::getGuichets)
                .orElse(List.of())
                .stream()
                .map(guichetMapper::guichetEntityToGuichet)
                .toList();
    }


    @PostMapping
    ResponseEntity<Void> create(@RequestBody Gare gare) {
        this.gareService.save(this.mapper.gareToGareEntity(gare));
        var createdObjectRequest = UriComponentsBuilder.fromPath("/v1/gares/{id}")
                .build(gare.getId());
        return ResponseEntity.created(createdObjectRequest).build();
    }
}
