package fr.poilud.fivekm.core.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AccountLevel {

	ADMINISTRATOR(0),
	USER(1),
	APPLICATION(2);
	
	public int level;
}
