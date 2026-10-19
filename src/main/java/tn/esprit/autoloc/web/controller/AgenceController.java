package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.strategy.IAgenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agence")
@Tag(name = "Agences", description = "Gestion CRUD des agences")
public class AgenceController {

    IAgenceService agenceService;

    @GetMapping("/retrieve-all-agences")
    @Operation(summary = "Lister les agences")
    @ApiResponse(responseCode = "200", description = "Liste des agences récupérée")
    public List<Agence> retrieveAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    @PostMapping("/add-agence")
    @Operation(summary = "Créer une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence créée"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public Agence addAgence(@RequestBody Agence a) {
        return agenceService.addAgence(a);
    }

    @PutMapping("/update-agence")
    @Operation(summary = "Modifier une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence modifiée"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public Agence updateAgence(@RequestBody Agence a) {
        return agenceService.updateAgence(a);
    }

    @GetMapping("/retrieve-agence/{id-agence}")
    @Operation(summary = "Récupérer une agence par son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence récupérée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
    })
    public Agence retrieveAgence(@PathVariable("id-agence") Long idAgence) {
        return agenceService.retrieveAgence(idAgence);
    }

    @DeleteMapping("/remove-agence/{id-agence}")
    @Operation(summary = "Supprimer une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence supprimée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
    })
    public void removeAgence(@PathVariable("id-agence") Long idAgence) {
        agenceService.removeAgence(idAgence);
    }

    @PostMapping("/add-agences")
    public List<Agence> addAgences(@RequestBody List<Agence> agences) {
        return agenceService.addAgences(agences);
    }
}
