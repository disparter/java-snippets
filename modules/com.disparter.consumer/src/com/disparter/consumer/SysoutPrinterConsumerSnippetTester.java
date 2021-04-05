package com.disparter.consumer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SysoutPrinterConsumerSnippetTester {

    private final String PRINTABLE_STRING = "printable";
    private final PrintStream ORIGINAL_OUT = System.out;

    
    public void testOutputPrint(){
    	final String EXPECTED_OUTPUT = PRINTABLE_STRING + System.lineSeparator();
    	ByteArrayOutputStream outContent = captureOutput();
        
        new SysoutPrinterConsumerSnippet<String>().accept(PRINTABLE_STRING);
        
        if(EXPECTED_OUTPUT.equals(outContent.toString())){
        	restore();
            System.out.println("SysoutPrinterConsumerSnippetTester::: TEST for print subjects have PASSED");
        }else {
        	restore();
            System.out.println("SysoutPrinterConsumerSnippetTester::: TEST for print subjects have FAILED");
        }       
 
    }

    private ByteArrayOutputStream captureOutput() {
    	ByteArrayOutputStream result = new ByteArrayOutputStream();
        System.setOut(new PrintStream(result));
        return result;
	}

	private void restore() {
    	System.setOut(ORIGINAL_OUT);
    }
    
}
