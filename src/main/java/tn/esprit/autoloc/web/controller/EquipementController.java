package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.strategy.IEquipementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
public class EquipementController {

    IEquipementService equipementService;

    @GetMapping("/retrieve-all-equipements")
    public List<Equipement> retrieveAllEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    @PostMapping("/add-equipement")
    public Equipement addEquipement(@RequestBody Equipement e) {
        return equipementService.addEquipement(e);
    }

    @PutMapping("/update-equipement")
    public Equipement updateEquipement(@RequestBody Equipement e) {
        return equipementService.updateEquipement(e);
    }

    @GetMapping("/retrieve-equipement/{id-equipement}")
    public Equipement retrieveEquipement(@PathVariable("id-equipement") Long idEquipement) {
        return equipementService.retrieveEquipement(idEquipement);
    }

    @DeleteMapping("/remove-equipement/{id-equipement}")
    public void removeEquipement(@PathVariable("id-equipement") Long idEquipement) {
        equipementService.removeEquipement(idEquipement);
    }

    @PostMapping("/add-equipements")
    public List<Equipement> addEquipements(@RequestBody List<Equipement> equipements) {
        return equipementService.addEquipements(equipements);
    }
}
