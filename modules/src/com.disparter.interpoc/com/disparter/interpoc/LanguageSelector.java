package com.disparter.interpoc;

import java.util.Locale;
import java.util.ResourceBundle;

public final class LanguageSelector {

	private final static String DEFAULT_PACKAGE = com.disparter.interpoc.ResourceBundle.class.getName();
	
	private LanguageSelector() {
		super();
	}
	
	public static String get(String resource) {
		return getOn(resource, DEFAULT_PACKAGE);
	}
	
	public static String get(String resource,  String language) {
		final var RB = ResourceBundle.getBundle(DEFAULT_PACKAGE, new Locale(language));
		return get(resource, RB);
	}
	
	public static String get(String resource,  String language, String packageName) {
		final var RB = ResourceBundle.getBundle(packageName, new Locale(language));
		return get(resource, RB);
	}
	
	public static String getOn(String resource, String packageName) {
		final var RB = ResourceBundle.getBundle(packageName);
		return get(resource, RB);
	}
	
	public static String get(String resource, ResourceBundle resourceBundle) {
		return resourceBundle.getString(resource);
	}

	public static String get(String resource, AvailableLanguages language) {
		final var RB = ResourceBundle.getBundle(DEFAULT_PACKAGE, language.get());
		return get(resource, RB);
	}
	
}
