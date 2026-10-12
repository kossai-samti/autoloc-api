package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.strategy.IAgenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agence")
public class AgenceController {

    IAgenceService agenceService;

    @GetMapping("/retrieve-all-agences")
    public List<Agence> retrieveAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    @PostMapping("/add-agence")
    public Agence addAgence(@RequestBody Agence a) {
        return agenceService.addAgence(a);
    }

    @PutMapping("/update-agence")
    public Agence updateAgence(@RequestBody Agence a) {
        return agenceService.updateAgence(a);
    }

    @GetMapping("/retrieve-agence/{id-agence}")
    public Agence retrieveAgence(@PathVariable("id-agence") Long idAgence) {
        return agenceService.retrieveAgence(idAgence);
    }

    @DeleteMapping("/remove-agence/{id-agence}")
    public void removeAgence(@PathVariable("id-agence") Long idAgence) {
        agenceService.removeAgence(idAgence);
    }

    @PostMapping("/add-agences")
    public List<Agence> addAgences(@RequestBody List<Agence> agences) {
        return agenceService.addAgences(agences);
    }
}
