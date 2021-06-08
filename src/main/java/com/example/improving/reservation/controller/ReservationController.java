package com.example.improving.reservation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.improving.reservation.dto.ReservationDto;
import com.example.improving.reservation.service.ReservationService;


@RestController
@RequestMapping("reservations")
public class ReservationController {
	private static final Logger log = LoggerFactory.getLogger(ReservationController.class);

	private ReservationService reservationService;
	
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@GetMapping
	public List<ReservationDto> getAllReservations(){
		log.trace("Get in controller");
		return reservationService.getAllReservations();
	}
	
	@PostMapping
	public void saveReservation(@RequestBody ReservationDto dto) {
		log.trace("Post in controller");
		reservationService.saveReservation(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteReservation(@PathVariable Integer id) {
		log.trace("Delete in controller");
		reservationService.deleteReservation(id);
	}
	
	@PatchMapping(value = "/{id}")
	public void patchReservation(@PathVariable Integer id, @RequestBody ReservationDto dto) {
		log.trace("Patch in controller");
		reservationService.editReservation(id, dto);
	}
}
