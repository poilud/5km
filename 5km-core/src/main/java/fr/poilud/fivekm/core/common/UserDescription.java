package fr.poilud.fivekm.core.common;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Class use to manage user account
 * 
 * @author Ludovic Poirier
 * @version 1.0
 */
@Embeddable
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDescription {

	@Column(length=50)
	private String lastname;
	
	@Column(length=50)
	private String firstname;
	
	@Column(length=50, unique = true)
	private String username;
	
	@Column(name="disable")
	private LocalDate disableDate;
	
}
