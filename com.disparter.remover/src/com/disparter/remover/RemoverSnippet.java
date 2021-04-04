package com.disparter.remover;

import java.util.function.Predicate;

public class RemoverSnippet implements Predicate<SimpleObject>{
    private final SimpleObject disposableObject;

    public RemoverSnippet(SimpleObject disposableObject){
        this.disposableObject = disposableObject;
    }

	public RemoverSnippet() {
		this.disposableObject = new SimpleObject("");
	}

	@Override
	public boolean test(SimpleObject object) {
		return disposableObject.equals(object);
	}

}
