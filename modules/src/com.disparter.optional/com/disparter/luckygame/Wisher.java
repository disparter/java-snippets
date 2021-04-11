package com.disparter.luckygame;

public final class Wisher {
	
	private final String key;
	
	public Wisher(String wisherName) throws EncriptionException {
		this.key = Encripter.encript(wisherName, "serial");
	}	
	
	public Boolean isSame(String key) {
		return this.key.equals(key);
	}
	
	public final String get() {
		return this.key;
	}
}
