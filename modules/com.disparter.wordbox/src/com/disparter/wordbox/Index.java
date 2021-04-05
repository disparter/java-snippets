package com.disparter.wordbox;

import java.util.HashMap;
import java.util.Map;

public class Index {
	private Map<Integer, Word> index;
	
	public Index() {
		this.index = new HashMap<>();
	}
	
	public Index(Map<Integer, Word> index) {
		this.index = index;
	}
	
	public void put(Integer key, Word word) {
		this.index.put(key, word);
	}
	
	public Word get(String key) {
		Word word = index.get(Hasher.hash(key));
		word.increaseCount();
		return word;
	}
}
