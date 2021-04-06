package com.disparter.wordbox;

public class Word {

	private final String text;
	private Long count;
	
	public Word(String text) {
		this.text = text.intern();
		this.count = 1L;
	}
	
	protected void increaseCount() {
		this.count++;
	}
	
	public Long getCount() {
		return this.count;
	}

	@Override
	public String toString() {
		return text;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	
}
