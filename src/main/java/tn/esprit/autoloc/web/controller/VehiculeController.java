package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.strategy.IVehiculeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
@Tag(name = "Véhicules", description = "Gestion CRUD des véhicules")
public class VehiculeController {

    IVehiculeService vehiculeService;

    @GetMapping("/retrieve-all-vehicules")
    @Operation(summary = "Lister les véhicules")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée")
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @PostMapping("/add-vehicule")
    @Operation(summary = "Créer un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule créé"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public Vehicule addVehicule(@RequestBody Vehicule v) {
        return vehiculeService.addVehicule(v);
    }

    @PutMapping("/update-vehicule")
    @Operation(summary = "Modifier un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule modifié"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public Vehicule updateVehicule(@RequestBody Vehicule v) {
        return vehiculeService.updateVehicule(v);
    }

    @GetMapping("/retrieve-vehicule/{id-vehicule}")
    @Operation(summary = "Récupérer un véhicule par son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule récupéré"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    public Vehicule retrieveVehicule(@PathVariable("id-vehicule") Long idVehicule) {
        return vehiculeService.retrieveVehicule(idVehicule);
    }

    @DeleteMapping("/remove-vehicule/{id-vehicule}")
    @Operation(summary = "Supprimer un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule supprimé"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    public void removeVehicule(@PathVariable("id-vehicule") Long idVehicule) {
        vehiculeService.removeVehicule(idVehicule);
    }

    @PostMapping("/add-vehicules")
    public List<Vehicule> addVehicules(@RequestBody List<Vehicule> vehicules) {
        return vehiculeService.addVehicules(vehicules);
    }
}
