package fr.poilud.fivekm.core.strava;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.poilud.fivekm.core.common.SuperEntity;
import fr.poilud.fivekm.core.common.UserDescription;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Class use to manage Strava user account
 * 
 * @author poilud
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(schema = "strava", name="rider")
public class StravaUser extends SuperEntity {

	@Embedded
	private UserDescription userDescription;
	
	@Column
	private String code;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<StravaRide> rides;

	@Builder
	public StravaUser(Long id, UserDescription userDescription, String code, List<StravaRide> rides) {
		super(id);
		this.userDescription = userDescription;
		this.code = code;
		this.rides = rides;
	}
	
	
	
}
