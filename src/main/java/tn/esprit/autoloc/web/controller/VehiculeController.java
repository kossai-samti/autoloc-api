package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.strategy.IVehiculeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeController {

    IVehiculeService vehiculeService;

    @GetMapping("/retrieve-all-vehicules")
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    @PostMapping("/add-vehicule")
    public Vehicule addVehicule(@RequestBody Vehicule v) {
        return vehiculeService.addVehicule(v);
    }

    @PutMapping("/update-vehicule")
    public Vehicule updateVehicule(@RequestBody Vehicule v) {
        return vehiculeService.updateVehicule(v);
    }

    @GetMapping("/retrieve-vehicule/{id-vehicule}")
    public Vehicule retrieveVehicule(@PathVariable("id-vehicule") Long idVehicule) {
        return vehiculeService.retrieveVehicule(idVehicule);
    }

    @DeleteMapping("/remove-vehicule/{id-vehicule}")
    public void removeVehicule(@PathVariable("id-vehicule") Long idVehicule) {
        vehiculeService.removeVehicule(idVehicule);
    }

    @PostMapping("/add-vehicules")
    public List<Vehicule> addVehicules(@RequestBody List<Vehicule> vehicules) {
        return vehiculeService.addVehicules(vehicules);
    }
}
