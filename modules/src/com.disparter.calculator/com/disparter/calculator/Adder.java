package com.disparter.calculator;

import java.util.function.BinaryOperator;

public class Adder implements BinaryOperator<Integer>{

	@Override
    public Integer apply(Integer a, Integer b){
        return a + b;
    }

    public static Integer sum(Integer a, Integer b){
        return new Adder().apply(a, b);
    }

}