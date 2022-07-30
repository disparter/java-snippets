package com.disparter.math.prime;

import java.util.function.Function;

public class PrimeChecker implements Function<Integer, Boolean>{

    @Override
    public Boolean apply(Integer number) {
        if(number < 2){
            return false;
        }

        for(int i = 2; i < number; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
