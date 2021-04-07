package com.disparter.calculator;

import java.util.function.BiFunction;

public class Divider implements  BiFunction<Integer, Integer, Integer>{

    @Override
    public Integer apply(Integer a, Integer b){
        return a / b;
    }

    public static Integer divide(Integer a, Integer b){
        return new Divider().apply(a, b);
    }
}