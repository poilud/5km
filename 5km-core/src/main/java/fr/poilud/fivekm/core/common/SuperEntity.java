package fr.poilud.fivekm.core.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de base pour la gestion des classes JPA
 * 
 * @author Ludovic Poirier
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class SuperEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Version
	private int version;

	public SuperEntity(Long id) {
		this.id = id;
	}
	
	
	
}
