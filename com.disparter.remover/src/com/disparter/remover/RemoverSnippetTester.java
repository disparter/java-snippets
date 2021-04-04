package com.disparter.remover;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoverSnippetTester {

    private SimpleObject CHOSEN_OBECT = new SimpleObject("THE CHOSEN ONE");
    private SimpleObject DISPOSABLE_OBJECT = new SimpleObject("IM A DISPOSABLE OBJECT BUT IM STILL USEFUL");
    private SimpleObject DISPOSABLE_OBJECT2 = new SimpleObject("IM A DISPOSABLE OBJECT BUT IM STILL USEFUL");
    private SimpleObject DISPOSABLE_OBJECT3 = new SimpleObject("IM A DISPOSABLE OBJECT BUT IM STILL USEFUL");

    private ArrayList<SimpleObject> testSubjects = Stream.of(CHOSEN_OBECT, DISPOSABLE_OBJECT, DISPOSABLE_OBJECT2)
    		.collect(Collectors.toCollection(ArrayList::new));

    public void predicateSnippetTestFiltering(){
        List<SimpleObject> expectedSubjectsToPass = Stream.of(CHOSEN_OBECT).collect(Collectors.toList());
        List<SimpleObject> expectedSubjectsToFail = Stream.of(DISPOSABLE_OBJECT, DISPOSABLE_OBJECT2, DISPOSABLE_OBJECT3)
        		.collect(Collectors.toList());

        if(testSubjects.removeIf(new RemoverSnippet(DISPOSABLE_OBJECT))) {
            System.out.println("RemoverSnippetTester::: TEST for removing disposable objects have PASSED");
        }
        
        if(expectedSubjectsToPass.equals(testSubjects)){
            System.out.println("RemoverSnippetTester::: TEST for filtering positive have PASSED");
        }else {
            System.out.println("RemoverSnippetTester::: TEST for filtering positive have FAILED");
        }       

        if(!expectedSubjectsToFail.equals(testSubjects)){
            System.out.println("RemoverSnippetTester::: TEST for filtering negative have PASSED");
        }else {
            System.out.println("RemoverSnippetTester::: TEST for filtering negative have FAILED");
        }     
    }

}
