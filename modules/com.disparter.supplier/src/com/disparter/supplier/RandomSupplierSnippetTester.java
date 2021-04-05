package com.disparter.supplier;

public class RandomSupplierSnippetTester {

    public void testRandomNumberSupplied(){
 
    	Number testSubject = new RandomSupplierSnippet().get();
    	
        if(testSubject != null){
            System.out.printf("RandomSupplierSnippetTester::: TEST for number supplied have PASSED, value {%f}", testSubject);
        }else {
            System.out.println("RandomSupplierSnippetTester::: TEST for number supplied have FAILED");
        }       
 
    }
    
}
