package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.strategy.IClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
@Tag(name = "Clients", description = "Gestion CRUD des clients")
public class ClientController {

    IClientService clientService;

    @GetMapping("/retrieve-all-clients")
    @Operation(summary = "Lister les clients")
    @ApiResponse(responseCode = "200", description = "Liste des clients récupérée")
    public List<Client> retrieveAllClients() {
        return clientService.retrieveAllClients();
    }

    @PostMapping("/add-client")
    @Operation(summary = "Créer un client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client créé"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public Client addClient(@RequestBody Client c) {
        return clientService.addClient(c);
    }

    @PutMapping("/update-client")
    @Operation(summary = "Modifier un client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client modifié"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public Client updateClient(@RequestBody Client c) {
        return clientService.updateClient(c);
    }

    @GetMapping("/retrieve-client/{id-client}")
    @Operation(summary = "Récupérer un client par son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client récupéré"),
            @ApiResponse(responseCode = "404", description = "Client introuvable")
    })
    public Client retrieveClient(@PathVariable("id-client") Long idClient) {
        return clientService.retrieveClient(idClient);
    }

    @DeleteMapping("/remove-client/{id-client}")
    @Operation(summary = "Supprimer un client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client supprimé"),
            @ApiResponse(responseCode = "404", description = "Client introuvable")
    })
    public void removeClient(@PathVariable("id-client") Long idClient) {
        clientService.removeClient(idClient);
    }

    @PostMapping("/add-clients")
    public List<Client> addClients(@RequestBody List<Client> clients) {
        return clientService.addClients(clients);
    }
}
