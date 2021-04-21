package com.disparter.interpoc;

import java.util.Locale;

public enum AvailableLanguages {
	
	en_US("en", "US"),
	en_CA("en", "CA"),
	fr("fr", null),
	fr_CA("fr", "CA"),
	pt_BR("pt", "BR"),
	pt("pt", null);

	private final String language;
	private final String country;
	
	AvailableLanguages(String language, String country) {
		this.language = language;
		this.country = country;
	}

	public Locale get() {
		if(this.getCountry() == null) {
			return new Locale(this.getLanguage());
		}
		return new Locale(this.getLanguage(), this.getCountry());
	}

	public String getLanguage() {
		return language;
	}

	public String getCountry() {
		return country;
	}
	
}
