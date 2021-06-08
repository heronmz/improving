package com.example.improving.reservation.service;

import java.util.List;

import com.example.improving.reservation.dto.ReservationDto;

public interface ReservationService {
	List<ReservationDto> getAllReservations();
	void saveReservation(ReservationDto dto);
	void deleteReservation(Integer id);
	void editReservation(Integer id, ReservationDto dto);
}
