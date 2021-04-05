package com.disparter.wordbox;

import java.util.BitSet;

public class Box {

	protected volatile BitSet cache;
	
	public Box() {
		this.cache = new BitSet();
	}
	
	protected boolean get(Integer bit) {
		return cache.get(bit);
	}
	
	protected Integer put(String word) {
		Integer result = Hasher.hash(word);
		cache.set(result, true);
		return result;
	}
	
}
