package com.disparter.wordbox;

public class Hasher {

	public static synchronized Integer hash(String word) {
		return Math.abs(word.hashCode());
	}
	
}
