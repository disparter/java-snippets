package com.disparter.math.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PrimeDivisors implements Function<Integer, List<Integer>>{

    @Override
    public List<Integer> apply(Integer number) {
        var divisors = new ArrayList<Integer>(number-1);

        for(int divisor = 1; divisor < number; divisor++){
            if(number % divisor == 0){
                divisors.add(divisor);
            }
        }

        divisors.add(number);
        return divisors;
    }
}
