package com.disparter.luckygame;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LuckyBox {

	private Map<String, Wisher> wishes;
	
	public LuckyBox() {
		this.wishes = new HashMap<>();
	}
	
	public Optional<String> storeMyLuck(String wish, String wisherName){
		
		try {
			Wisher wisher =  new Wisher(wisherName);
			wishes.put(wish,wisher);
			return Optional.of(wisher.get());
		} catch (EncriptionException e) {
			System.err.println(e.getMessage());
		}
		
		return Optional.empty();
		
	}
	
	
}
