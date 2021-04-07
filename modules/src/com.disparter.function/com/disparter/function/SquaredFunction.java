package com.disparter.function;

import java.util.function.Function;
import java.lang.Number;

public class SquaredFunction implements Function<Integer, Integer>{

	@Override
	public Integer apply(Integer number){
		return number * number;
	}

	public static Integer sqrt(Integer number){
		return number * number;
	}
	
}
