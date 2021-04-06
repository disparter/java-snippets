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
    	var errors = 0;
    	if(word.getCount() == 1L) {
    		System.out.println("WordboxTester::test_Storage -> TEST for first time store have PASSED");
    	}else {
			errors++;
    		System.err.printf("WordboxTester::test_Storage -> TEST for first time store have FAILED. Word {%s}\n", word);
    	}
    	
    	Word alreadyWord = store.store(EXPECTED);
    	
    	if(alreadyWord.getCount() == 2L) {
    		System.out.println("WordboxTester::test_Storage -> TEST for already exits time store have PASSED");
    	}else {
			errors++;
    		System.err.printf("WordboxTester::test_Storage -> TEST for already exits time store have FAILED. Word {%s}", alreadyWord);
    	}
		System.exit(errors);
	}
    
}
