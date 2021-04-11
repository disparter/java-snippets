package com.disparter.luckygame;

import java.util.Optional;

public class LuckyBoxTester {
    
	int errors = 0;
	LuckyBox luckyBox = new LuckyBox();
	
	public void test_allTests() {
		test_storage();
		System.exit(errors);
	}
	
    public void test_storage(){
        	final String wish = "subject";
        	final String wisher = "subjectWisher";
        	Optional<String> result = luckyBox.storeMyLuck(wish , wisher);
        	if(result.isPresent()) {
                System.out.printf("LuckyBoxTester::: TEST for storage have passed\n"); 
        	}else {
                System.err.printf("LuckyBoxTester::: TEST for storage have FAILED {%s}\n"); 
                errors++;
        	}

        	result = luckyBox.storeMyLuck("" , "");
           	if(!result.isPresent()) {
            	System.err.printf("LuckyBoxTester::: TEST for empty args storage have failed\n"); 
                errors++;        	
            }else {
                System.out.println("LuckyBoxTester::: TEST for empty args have passed\n"); 
        	}

    }
    
}
