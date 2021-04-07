package com.disparter.function;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
            
            System.exit(1);
        }       
 
    }

    public void test_staticForm(){
        try{
            Stream.of(1).mapToInt(SquaredFunction::sqrt).mapToObj(SquaredFunction::sqrt).collect(Collectors.toList());
            System.out.println("SquaredFunctionTester::: TEST for staticQuadratic have PASSED"); 
        } catch(Exception e){
            System.err.printf("SquaredFunctionTester::: TEST for staticQuadratic have FAILED {%s}", e); 
            System.exit(1);
        }
    }
    
}
