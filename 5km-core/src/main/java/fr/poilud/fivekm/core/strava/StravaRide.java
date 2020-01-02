package fr.poilud.fivekm.core.strava;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.poilud.fivekm.core.common.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Classe de gestion des trajets
 * 
 * @author Ludovic Poirier
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "strava", name="ride")
public class StravaRide extends SuperEntity {

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_user")
	private StravaUser user;
	
	@Column(name="dtStart")
	private LocalDateTime startDate;
	
	@Column(name="dtEnd")
	private LocalDateTime endDate;
	
	@Column
	private float distance;
}
