package com.disparter.calculator;

import java.util.function.BinaryOperator;

public class Reducer implements BinaryOperator<Integer>{

    @Override
    public Integer apply(Integer a, Integer b){
        return a - b;
    }

    public static Integer diff(Integer a, Integer b){
        return new Reducer().apply(a, b);
    }
}