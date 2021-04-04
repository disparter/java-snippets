package com.disparter.comparator;

import java.util.Comparator;

public class AlphaNoCaseComparatorSnippet implements Comparator<String>{
	@Override
	public int compare(String word1, String word2) {
		return word1.compareToIgnoreCase(word2);
	}
}
