package com.disparter.math.prime;

import java.util.List;

public class PrimeCheckerWithDivisorsListTester {

    int errors = 0;

    public int test_allTests() {
        test_whenNumberIsPrime();
        test_whenNumberIsNotPrime();
        return errors;
    }

    public void test_whenNumberIsPrime() {
        //Given
        final Integer testSubject = 2;
        final Boolean EXPECTED = true;

        //When
        Boolean result = new PrimeCheckerWithDivisorsList(new PrimeDivisors()).apply(testSubject);

        //Then
        if(EXPECTED.equals(result)){
            System.out.printf("PrimeDivisorsTester::: TEST divisors result for subject {%d} PASSED, expected {%s}, result {%s}\n",
                    testSubject, EXPECTED, result);
        }else {
            System.err.printf("PrimeDivisorsTester::: TEST divisors result for subject {%d} FAILED, expected {%s}, result {%s}\n",
                    testSubject, EXPECTED, result);
            errors++;
        }
    }

    public void test_whenNumberIsNotPrime() {
        //Given
        final Integer testSubject = 4;
        final Boolean EXPECTED = false;

        //When
        Boolean result = new PrimeCheckerWithDivisorsList(new PrimeDivisors()).apply(testSubject);

        //Then
        if(EXPECTED.equals(result)){
            System.out.printf("PrimeDivisorsTester::: TEST divisors result for subject {%d} PASSED, expected {%s}, result {%s}\n",
                    testSubject, EXPECTED, result);
        }else {
            System.err.printf("PrimeDivisorsTester::: TEST divisors result for subject {%d} FAILED, expected {%s}, result {%s}\n",
                    testSubject, EXPECTED, result);
            errors++;
        }
    }

}
