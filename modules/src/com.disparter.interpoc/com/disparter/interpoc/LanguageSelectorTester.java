package com.disparter.interpoc;

import java.util.Locale;

public class LanguageSelectorTester {
	
	private int errors = 0;
	private static final String LOCALE = "locale";
	
    public void runAllTestsAndExit() {
    	test_NoLanguageSelected();
    	test_LanguageChanging();
    	System.exit(errors);
    }
    
    public void test_NoLanguageSelected(){
    	
    	final var EXPECTED = "default";
    	final var testSubject = LanguageSelector.get(LOCALE);
    	
        if(EXPECTED.equals(testSubject)){
            System.out.printf("LanguageSelectorTester::: TEST for no Language Selected PASSED, value {%s}\n", testSubject);
        }else {
            System.err.printf("LanguageSelectorTester::: TEST for no Language Selected have FAILED, expected {%s} value {%s}\n", testSubject, EXPECTED);
            errors++;
        }       
 
    }
    
    public void test_LanguageChanging(){
    	
		Locale.setDefault(AvailableLanguages.fr.get());

    	var EXPECTED = "French";
    	
    	var testSubject = LanguageSelector.get(LOCALE);
    	
        if(EXPECTED.equals(testSubject)){
            System.out.printf("LanguageSelectorTester::: TEST after setting default to fr PASSED, value {%s}\n", testSubject);
        }else {
            System.err.printf("LanguageSelectorTester::: TEST after setting default to fr, expected {%s} value {%s}\n", testSubject, EXPECTED);
            errors++;
        }
    	
       	testSubject = LanguageSelector.get(LOCALE, AvailableLanguages.fr_CA);
    	
        if(EXPECTED.equals(testSubject)){
            System.out.printf("LanguageSelectorTester::: TEST after change to fr_CA PASSED, value {%s}\n", testSubject);
        }else {
            System.err.printf("LanguageSelectorTester::: TEST after change to fr_CA FAILED, expected {%s} value {%s}\n", testSubject, EXPECTED);
            errors++;
        }       
 
        EXPECTED = "Canadian English";
        testSubject = LanguageSelector.get(LOCALE, AvailableLanguages.en_CA);
    	
        if(EXPECTED.equals(testSubject)){
            System.out.printf("LanguageSelectorTester::: TEST after change to en_CA PASSED, value {%s}\n", testSubject);
        }else {
            System.err.printf("LanguageSelectorTester::: TEST after change to en_CA FAILED, expected {%s} value {%s}\n", testSubject, EXPECTED);
            errors++;
        }   
    }
}
