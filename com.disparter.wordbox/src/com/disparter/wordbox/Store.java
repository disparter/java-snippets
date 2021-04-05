package com.disparter.wordbox;

public class Store {
	
	private Box box;
	private Index index;
	
	public Store(Box box, Index index) {
		this.box = box;
		this.index = index;
	}
	
	public Word store(String word) {
		if(!mightContain(word)) {
			String intern = word.intern();
			Integer wordIndex = box.put(intern);
			Word result = new Word(intern);
			index.put(wordIndex, result);
			return result;
		}
		return index.get(word);
	}
	
	public Boolean mightContain(String word) {
		return box.get(Hasher.hash(word));
	}
		
}
