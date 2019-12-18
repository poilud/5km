package fr.poilud.fivekm;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.poilud.fivekm.account.User;
import fr.poilud.fivekm.account.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de gestion des trajets
 * 
 * @author Ludovic Poirier
 * @version 1.0
 */
@Entity
@Table(name="ride")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ride extends SuperEntity {

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_user")
	private User user;
	
	@Column(name="dtStart")
	private LocalDateTime startDate;
	
	@Column(name="dtEnd")
	private LocalDateTime endDate;
	
	@Column
	private float distance;
}
