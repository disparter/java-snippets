package com.disparter.math.prime;

import java.util.function.Function;

public class PrimeCheckerWithDivisorsList implements Function<Integer, Boolean>{

    private final PrimeDivisors primeDivisor;

    public PrimeCheckerWithDivisorsList(PrimeDivisors primeDivisors) {
        this.primeDivisor = primeDivisors;
    }

    public PrimeCheckerWithDivisorsList() {
        this.primeDivisor = new PrimeDivisors();
    }


    @Override
    public Boolean apply(Integer number) {
        var divisors = primeDivisor.apply(number);
        return divisors.size() == 2;
    }
}
