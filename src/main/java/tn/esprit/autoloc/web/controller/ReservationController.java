package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.strategy.IReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    IReservationService reservationService;

    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> retrieveAllReservations() {
        return reservationService.retrieveAllReservations();
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation r) {
        return reservationService.addReservation(r);
    }

    @PutMapping("/update-reservation")
    public Reservation updateReservation(@RequestBody Reservation r) {
        return reservationService.updateReservation(r);
    }

    @GetMapping("/retrieve-reservation/{id-reservation}")
    public Reservation retrieveReservation(@PathVariable("id-reservation") Long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }

    @DeleteMapping("/remove-reservation/{id-reservation}")
    public void removeReservation(@PathVariable("id-reservation") Long idReservation) {
        reservationService.removeReservation(idReservation);
    }

    @PostMapping("/add-reservations")
    public List<Reservation> addReservations(@RequestBody List<Reservation> reservations) {
        return reservationService.addReservations(reservations);
    }
}
