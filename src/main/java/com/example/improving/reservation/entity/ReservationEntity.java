package com.example.improving.reservation.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "reservation")
public class ReservationEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_reservation")
	private Integer id;
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;
	

	public ReservationEntity(Integer id, String name, LocalDateTime time) {
		this.id = id;
		this.name = name;
		this.time = Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
	}
}
