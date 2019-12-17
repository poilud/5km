package fr.poilud.fivekm;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

import fr.poilud.fivekm.type.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de gestion des utilisateurs
 * 
 * @author Ludovic Poirier
 * @version 1.0
 */
@Entity
@Table(name="rider")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends SuperEntity {

	@Column(length=50)
	private String lastname;
	
	@Column(length=50)
	private String firstname;
	
	@Column(length=50, unique = true)
	private String email;
	
	@ColumnTransformer(read ="pgp_sym_decrypt(password,current_setting('encrypt.key'))",
    write = "pgp_sym_encrypt(?, current_setting('encrypt.key'))")
	@Column(length=30, columnDefinition="bytea")
	private String password;
	
	@Enumerated(EnumType.ORDINAL)
	private AccountType type;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Ride> rides;
	
	@Column(name="disable")
	private LocalDate disableDate;
}
