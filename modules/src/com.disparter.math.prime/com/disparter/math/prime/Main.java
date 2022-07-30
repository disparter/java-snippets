package com.disparter.math.prime;

public class Main {

    public static void main(String[] args) {
    	int errors = 0;
        PrimeCheckerTester tester = new PrimeCheckerTester();
    	errors += tester.test_allTests();

        PrimeDivisorsTester tester2 = new PrimeDivisorsTester();
        errors += tester2.test_allTests();

        System.exit(errors);
    }
    
}
