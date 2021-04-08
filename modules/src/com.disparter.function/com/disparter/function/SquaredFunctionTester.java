package com.disparter.function;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SquaredFunctionTester {
    
	int errors = 0;
	
	public void test_allTests() {
		test_squareNumber();
		test_staticForm();
		test_thenFunction();
		System.exit(errors);
	}
	
	public void test_thenFunction() {
        final Integer EXPECTED = 2;    
        final Integer testSubject = 2;       

        Integer result = new SquaredFunction().andThen(i -> i/2).apply(testSubject);
       
        if(EXPECTED == result){
            System.out.printf("SquaredFunctionTester::: TEST for half andThen double {%d} have PASSED, expected {%d}, result {%d}\n",
                testSubject, EXPECTED, result);
        }else {
            System.err.printf("SquaredFunctionTester::: TEST for half andThen double {%d} have FAILED, expected {%d}, result {%d}\n",
                testSubject, EXPECTED, result);
            
            errors++;
        }       
 
		
	}
    
    public void test_squareNumber(){
        final Integer EXPECTED = 4;    
        final Integer testSubject = 2;       

    	Integer result = new SquaredFunction().apply(testSubject);
    	
        if(EXPECTED == result){
            System.out.printf("SquaredFunctionTester::: TEST for double {%d} have PASSED, expected {%d}, result {%d}\n",
                testSubject, EXPECTED, result);
        }else {
            System.err.printf("SquaredFunctionTester::: TEST for double {%d} have FAILED, expected {%d}, result {%d}\n",
                testSubject, EXPECTED, result);
            
            errors++;
        }       
 
    }

    public void test_staticForm(){
        try{
            Stream.of(1).mapToInt(SquaredFunction::sqrt).mapToObj(SquaredFunction::sqrt).collect(Collectors.toList());
            System.out.println("SquaredFunctionTester::: TEST for staticQuadratic have PASSED"); 
        } catch(Exception e){
            System.err.printf("SquaredFunctionTester::: TEST for staticQuadratic have FAILED {%s}\n", e); 
            errors++;
        }
    }
    
}
