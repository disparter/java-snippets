package com.disparter.consumer;

import java.util.function.Consumer;

public class SysoutPrinterConsumerSnippet<T> implements Consumer<T>{
	@Override
	public void accept(T t) {
		System.out.println(t);		
	}
}
