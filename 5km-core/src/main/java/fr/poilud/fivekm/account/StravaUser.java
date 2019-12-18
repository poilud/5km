package fr.poilud.fivekm.account;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class use to manage Strava user account
 * 
 * @author poilud
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "strava", name="rider")
public class StravaUser extends User {

	@Column
	private String code;
}
