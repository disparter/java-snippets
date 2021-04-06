package com.disparter.wordbox;

public class WordboxTester {

	private static final String EXPECTED = "expected";
	
	private Index index;
	private Box box;
	private Store store;
	
	public WordboxTester() {
		this.index = new Index();
		this.box = new Box();
		this.store = new Store(box, index);
	}
	
    public void test_Storage() {
    	Word word = store.store(EXPECTED);
    	
    	if(word.getCount() == 1L) {
    		System.out.println("WordboxTester::test_Storage -> First store Success");
    	}else {
    		System.err.printf("WordboxTester::test_Storage -> First Store Failure. Word {%s}\n", word);
    	}
    	
    	Word alreadyWord = store.store(EXPECTED);
    	
    	if(alreadyWord.getCount() == 2L) {
    		System.out.println("WordboxTester::test_Storage -> Already Exists Word Success");
    	}else {
    		System.err.printf("WordboxTester::test_Storage -> Already Exists Word Failure. Word {%s}", alreadyWord);
    	}
    	
    }
    
}
