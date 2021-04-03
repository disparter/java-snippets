package com.disparter.predicate;

public final class SimpleObject {
    public final String name;

    public SimpleObject(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
