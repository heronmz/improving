package com.example.improving.reservation.service;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.improving.reservation.dto.ReservationDto;
import com.example.improving.reservation.entity.ReservationEntity;
import com.example.improving.reservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
	private static Logger log = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	private ReservationRepository reservationRepository;

	public ReservationServiceImpl(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
	
	public List<ReservationDto> getAllReservations(){
		log.trace("Getting reservations");
		List<ReservationDto> dtos = reservationRepository.findAll().stream().map(t -> new ReservationDto(t.getId(), t.getName(), t.getTime())).collect(Collectors.toList());
		log.info("{} reservations found",dtos.size());
		return dtos;
	} 
	
	public void saveReservation(ReservationDto dto){
		log.trace("Save reservation");
		ReservationEntity entity = new ReservationEntity(dto.getId(), dto.getName(), dto.getTime());
		reservationRepository.save(entity);
		log.info("Entity {} saved", entity.getId());
	}
	
	public void deleteReservation(Integer id) {
		log.trace("Delete reservation");
		reservationRepository.deleteById(id);
		log.info("Entity {} deleted", id);
	}
	
	public void editReservation(Integer id, ReservationDto dto) {
		log.trace("Edit reservation");
		ReservationEntity entity = reservationRepository.getById(id);
		entity.setName(dto.getName());
		entity.setTime(Date.from(dto.getTime().atZone(ZoneId.systemDefault()).toInstant()));
		reservationRepository.save(entity);
		log.info("Entity {} modified", id);
	}
	
}
