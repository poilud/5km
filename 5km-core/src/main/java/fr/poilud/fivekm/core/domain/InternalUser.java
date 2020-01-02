package fr.poilud.fivekm.core.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

import fr.poilud.fivekm.core.common.SuperEntity;
import fr.poilud.fivekm.core.common.UserDescription;
import fr.poilud.fivekm.core.util.AccountLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class use to manage internal application user
 * 
 * @author poilud
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "application", name="app_user")
public class InternalUser extends SuperEntity {

	@Embedded
	private UserDescription userDescription;
	
	@ColumnTransformer(read ="pgp_sym_decrypt(password,current_setting('encrypt.key'))",
			write = "pgp_sym_encrypt(?, current_setting('encrypt.key'))")
	@Column(length=30, columnDefinition="bytea")
	private String password;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	private AccountLevel level;
}
