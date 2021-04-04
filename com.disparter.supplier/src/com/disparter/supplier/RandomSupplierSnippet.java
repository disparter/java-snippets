package com.disparter.supplier;

import java.util.Random;
import java.util.function.Supplier;
import java.lang.Number;

public class RandomSupplierSnippet implements Supplier<Number>{

	@Override
	public Number get() {
		return new Random().nextFloat();
	}
	
}
