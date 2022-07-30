package com.disparter.math.prime;

import java.util.List;

public class PrimeDivisorsTester {

    int errors = 0;

    public int test_allTests() {
        test_whenNumberIsPrime();
        test_whenNumberIsNotPrime();
        return errors;
    }

    public void test_whenNumberIsPrime() {
        //Given
        final Integer testSubject = 2;
        final List<Integer> EXPECTED = List.of(1,2);

        //When
        List<Integer> result = new PrimeDivisors().apply(testSubject);

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
        final List<Integer> EXPECTED = List.of(1,2,4);

        //When
        List<Integer> result = new PrimeDivisors().apply(testSubject);

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
