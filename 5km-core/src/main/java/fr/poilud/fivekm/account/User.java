package fr.poilud.fivekm.account;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import fr.poilud.fivekm.Ride;
import lombok.Data;

/**
 * Class use to manage user account
 * 
 * @author Ludovic Poirier
 * @version 1.0
 */
@Data
@MappedSuperclass
public class User extends SuperEntity {

	@Column(length=50)
	private String lastname;
	
	@Column(length=50)
	private String firstname;
	
	@Column(length=50, unique = true)
	private String username;
			
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Ride> rides;
	
	@Column(name="disable")
	private LocalDate disableDate;
	
}
