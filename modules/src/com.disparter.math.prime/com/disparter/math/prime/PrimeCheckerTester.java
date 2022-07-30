package com.disparter.math.prime;

public class PrimeCheckerTester {
    
	int errors = 0;
	
	public Integer test_allTests() {
        test_whenNumberIsPrime();
        test_whenNumberIsNotPrime();
        return errors;
	}
	
	public void test_whenNumberIsPrime() {
        final Boolean EXPECTED = true;
        final Integer testSubject = 2;       

        Boolean result = new PrimeChecker().apply(testSubject);
       
        if(EXPECTED == result){
            System.out.printf("PrimeCheckerTester::: TEST that check if number {%d} is prime PASSED, expected {%b}, result {%b}\n",
                testSubject, EXPECTED, result);
        }else {
            System.out.printf("PrimeCheckerTester::: TEST that check if number {%d} is prime FAILED, expected {%b}, result {%b}\n",
                testSubject, EXPECTED, result);
            
            errors++;
        }
	}

    public void test_whenNumberIsNotPrime() {
        final Boolean EXPECTED = false;
        final Integer testSubject = 4;

        Boolean result = new PrimeChecker().apply(testSubject);

        if(EXPECTED == result){
            System.out.printf("PrimeCheckerTester::: TEST that check if number {%d} is prime PASSED, expected {%b}, result {%b}\n",
                    testSubject, EXPECTED, result);
        }else {
            System.out.printf("PrimeCheckerTester::: TEST that check if number {%d} is prime FAILED, expected {%b}, result {%b}\n",
                    testSubject, EXPECTED, result);

            errors++;
        }
    }

}
