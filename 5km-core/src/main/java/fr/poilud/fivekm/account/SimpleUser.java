package fr.poilud.fivekm.account;

import javax.persistence.Column;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

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
@Table(schema = "application", name="app_user")
public class SimpleUser extends User {

	@ColumnTransformer(read ="pgp_sym_decrypt(password,current_setting('encrypt.key'))",
			write = "pgp_sym_encrypt(?, current_setting('encrypt.key'))")
	@Column(length=30, columnDefinition="bytea")
	private String password;
}
