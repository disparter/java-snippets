package com.disparter.calculator;

import java.util.stream.IntStream;

public class CalculatorTester {
	
	public void demo_streamOperations() {
		int simpleSomatory = IntStream.rangeClosed(1, 10).reduce(Adder::sum).getAsInt();
    	System.out.printf("Simple Sommatory Demo: %d\n", simpleSomatory);
    	
    	int simpleNegativeSomatory = IntStream.rangeClosed(1, 10).reduce(Reducer::diff).getAsInt();
    	System.out.printf("Simple Negative Somatory Demo: %d\n", simpleNegativeSomatory);
    	
    	int simpleFactorial = IntStream.rangeClosed(1, 10).reduce(Multiplier::x).getAsInt();
    	System.out.printf("Simple Factorial Demo: %d\n", simpleFactorial);
    	
    	int simpleFractionProgression = IntStream.rangeClosed(1, 10).reduce(Divider::divide).getAsInt();
    	System.out.printf("Simple Fraction Demo: %d\n", simpleFractionProgression);
    }

	public void test_basicOperations(){
		final Integer testSubject = 1;

		final Integer expectedSumResult = 2;
		final Integer expectedDiffResult = 0;
		final Integer expectedDivisionResult = 1;
		final Integer expectedMutiplicationResult = 1;

		final Integer sum            = Adder.sum(testSubject, testSubject);
		final Integer diff           = Reducer.diff(testSubject, testSubject);
		final Integer division       = Divider.divide(testSubject, testSubject);
		final Integer multiplication = Multiplier.x(testSubject, testSubject);
		
		var errors = 0;
		
		if(expectedSumResult == sum) {
			System.out.printf("CalculatorTester::: TEST for sum {%d} have PASSED, expected {%d}, result {%d}\n",
	                   testSubject, expectedSumResult, sum);
	    }else {
	    	errors++;
	    	System.err.printf("CalculatorTester::: TEST for sum {%d} have FAILED, expected {%d}, result {%d}\n",
	                   testSubject, expectedSumResult, sum);
	    }

		if(expectedDiffResult == diff) {
			System.out.printf("CalculatorTester::: TEST for diff {%d} have PASSED, expected {%d}, result {%d}\n",
	                   testSubject, expectedDiffResult, diff);
	    }else {
	    	errors++;
	    	System.err.printf("CalculatorTester::: TEST for diff {%d} have FAILED, expected {%d}, result {%d}\n",
	                   testSubject, expectedDiffResult, diff);
	    }

		if(expectedDivisionResult == division) {
			System.out.printf("CalculatorTester::: TEST for division {%d} have PASSED, expected {%d}, result {%d}\n",
	                   testSubject, expectedDivisionResult, division);
	    }else {
	    	errors++;
	    	System.err.printf("CalculatorTester::: TEST for division {%d} have FAILED, expected {%d}, result {%d}\n",
	                   testSubject, expectedDivisionResult, division);
	    }

		if(expectedMutiplicationResult == multiplication) {
			System.out.printf("CalculatorTester::: TEST for multiplication {%d} have PASSED, expected {%d}, result {%d}\n",
	                   testSubject, expectedMutiplicationResult, multiplication);
	    }else {
	    	errors++;
	    	System.err.printf("CalculatorTester::: TEST for multiplication {%d} have FAILED, expected {%d}, result {%d}\n",
	                   testSubject, expectedMutiplicationResult, multiplication);
	    }

		System.exit(errors);

	}
    
}
