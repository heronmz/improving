package com.example.improving.reservation;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.improving.reservation.entity.ReservationEntity;
import com.example.improving.reservation.repository.ReservationRepository;

@Component
public class InitializeData implements CommandLineRunner{
	private static Logger log = LoggerFactory.getLogger(InitializeData.class);
	
	private ReservationRepository reservationRepository;
	
	public InitializeData(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Creating first registers");
		reservationRepository.save(new ReservationEntity(1, "David Williams", new Date()));
		reservationRepository.save(new ReservationEntity(2, "Sarah Connor",  new Date()));
		reservationRepository.save(new ReservationEntity(3, "Robert Stone",  new Date()));
		log.info("3 rows created");
	}

}
