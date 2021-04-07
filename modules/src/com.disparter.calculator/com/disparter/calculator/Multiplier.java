package com.disparter.calculator;

import java.util.function.BiFunction;

public class Multiplier implements  BiFunction<Integer, Integer, Integer>{

    @Override
    public Integer apply(Integer a, Integer b){
        return a * b;
    }

    public static Integer x(Integer a, Integer b){
        return new Multiplier().apply(a, b);
    }
}