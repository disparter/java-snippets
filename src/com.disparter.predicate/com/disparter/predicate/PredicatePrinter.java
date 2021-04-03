package com.disparter.predicate;

import java.util.List;
import java.util.function.Predicate;

public class PredicatePrinter {
    
    private PredicateSnippet snippet;

    public PredicatePrinter(PredicateSnippet snippet){
        this.snippet = snippet;
    }

    public void print(List<SimpleObject> objects, Predicate<SimpleObject> predicate){
        snippet.filter(predicate).collect().forEach(o -> System.out.println(o));
    }
}
