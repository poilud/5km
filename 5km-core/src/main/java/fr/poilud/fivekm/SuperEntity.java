package fr.poilud.fivekm;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Data;

/**
 * Classe de base pour la gestion des classes JPA
 * 
 * @author Ludovic Poirier
 * @version 1.0
 */
@Data
@MappedSuperclass
public class SuperEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Version
	private int version;
}
