package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.strategy.IPaiementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
public class PaiementController {

    IPaiementService paiementService;

    @GetMapping("/retrieve-all-paiements")
    public List<Paiement> retrieveAllPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    @PostMapping("/add-paiement")
    public Paiement addPaiement(@RequestBody Paiement p) {
        return paiementService.addPaiement(p);
    }

    @PutMapping("/update-paiement")
    public Paiement updatePaiement(@RequestBody Paiement p) {
        return paiementService.updatePaiement(p);
    }

    @GetMapping("/retrieve-paiement/{id-paiement}")
    public Paiement retrievePaiement(@PathVariable("id-paiement") Long idPaiement) {
        return paiementService.retrievePaiement(idPaiement);
    }

    @DeleteMapping("/remove-paiement/{id-paiement}")
    public void removePaiement(@PathVariable("id-paiement") Long idPaiement) {
        paiementService.removePaiement(idPaiement);
    }

    @PostMapping("/add-paiements")
    public List<Paiement> addPaiements(@RequestBody List<Paiement> paiements) {
        return paiementService.addPaiements(paiements);
    }
}
