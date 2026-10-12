package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.strategy.IMaintenanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceController {

    IMaintenanceService maintenanceService;

    @GetMapping("/retrieve-all-maintenances")
    public List<Maintenance> retrieveAllMaintenances() {
        return maintenanceService.retrieveAllMaintenances();
    }

    @PostMapping("/add-maintenance")
    public Maintenance addMaintenance(@RequestBody Maintenance m) {
        return maintenanceService.addMaintenance(m);
    }

    @PutMapping("/update-maintenance")
    public Maintenance updateMaintenance(@RequestBody Maintenance m) {
        return maintenanceService.updateMaintenance(m);
    }

    @GetMapping("/retrieve-maintenance/{id-maintenance}")
    public Maintenance retrieveMaintenance(@PathVariable("id-maintenance") Long idMaintenance) {
        return maintenanceService.retrieveMaintenance(idMaintenance);
    }

    @DeleteMapping("/remove-maintenance/{id-maintenance}")
    public void removeMaintenance(@PathVariable("id-maintenance") Long idMaintenance) {
        maintenanceService.removeMaintenance(idMaintenance);
    }

    @PostMapping("/add-maintenances")
    public List<Maintenance> addMaintenances(@RequestBody List<Maintenance> maintenances) {
        return maintenanceService.addMaintenances(maintenances);
    }
}
