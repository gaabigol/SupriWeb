/**
 * 
 */
package com.supriweb.supriweb.model.enums;

/**
 * @author bernardo
 *
 */
public enum Sex {

	MASCULINE("Masculine"), 
	FEMININE("Feminine");

	private String description;

	Sex(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
}
