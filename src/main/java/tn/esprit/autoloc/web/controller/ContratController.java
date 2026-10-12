package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.strategy.IContratService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratController {

    IContratService contratService;

    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> retrieveAllContrats() {
        return contratService.retrieveAllContrats();
    }

    @PostMapping("/add-contrat")
    public Contrat addContrat(@RequestBody Contrat c) {
        return contratService.addContrat(c);
    }

    @PutMapping("/update-contrat")
    public Contrat updateContrat(@RequestBody Contrat c) {
        return contratService.updateContrat(c);
    }

    @GetMapping("/retrieve-contrat/{id-contrat}")
    public Contrat retrieveContrat(@PathVariable("id-contrat") Long idContrat) {
        return contratService.retrieveContrat(idContrat);
    }

    @DeleteMapping("/remove-contrat/{id-contrat}")
    public void removeContrat(@PathVariable("id-contrat") Long idContrat) {
        contratService.removeContrat(idContrat);
    }

    @PostMapping("/add-contrats")
    public List<Contrat> addContrats(@RequestBody List<Contrat> contrats) {
        return contratService.addContrats(contrats);
    }
}
