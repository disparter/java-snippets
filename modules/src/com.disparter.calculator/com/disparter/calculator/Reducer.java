package com.disparter.calculator;

import java.util.function.BiFunction;

public class Reducer implements BiFunction<Integer, Integer, Integer>{

    @Override
    public Integer apply(Integer a, Integer b){
        return a - b;
    }

    public static Integer diff(Integer a, Integer b){
        return new Reducer().apply(a, b);
    }
}