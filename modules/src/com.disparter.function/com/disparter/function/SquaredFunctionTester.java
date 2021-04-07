package com.disparter.function;

public class SquaredFunctionTester {
    
    
    public void test_squareNumber(){
        final Integer EXPECTED = 4;    
        final Integer testSubject = 2;       

    	Integer result = new SquaredFunction().apply(testSubject);
    	
        if(EXPECTED == result){
            System.out.printf("SquaredFunctionTester::: TEST for double {%d} have PASSED, expected {%d}, result {%d}",
                testSubject, EXPECTED, result);
        }else {
            System.err.printf("SquaredFunctionTester::: TEST for double {%d} have FAILED, expected {%d}, result {%d}",
                testSubject, EXPECTED, result);
        }       
 
    }
    
}
