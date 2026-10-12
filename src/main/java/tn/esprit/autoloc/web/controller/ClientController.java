package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.strategy.IClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    IClientService clientService;

    @GetMapping("/retrieve-all-clients")
    public List<Client> retrieveAllClients() {
        return clientService.retrieveAllClients();
    }

    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client c) {
        return clientService.addClient(c);
    }

    @PutMapping("/update-client")
    public Client updateClient(@RequestBody Client c) {
        return clientService.updateClient(c);
    }

    @GetMapping("/retrieve-client/{id-client}")
    public Client retrieveClient(@PathVariable("id-client") Long idClient) {
        return clientService.retrieveClient(idClient);
    }

    @DeleteMapping("/remove-client/{id-client}")
    public void removeClient(@PathVariable("id-client") Long idClient) {
        clientService.removeClient(idClient);
    }

    @PostMapping("/add-clients")
    public List<Client> addClients(@RequestBody List<Client> clients) {
        return clientService.addClients(clients);
    }
}
