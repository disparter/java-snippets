package com.disparter.remover;

public final class SimpleObject {
    public final String name;

    public SimpleObject(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public boolean equals(Object other) {
    	if(name == null || other == null || !(other instanceof SimpleObject)) {
    		return false;
    	}
    	SimpleObject otherSO = (SimpleObject) other;
    	return name.equals(otherSO.name);
    }
    
    @Override
    public int hashCode() {
    	if(name == null) {
    		return super.hashCode();
    	}
    	return name.hashCode();
    }
}
