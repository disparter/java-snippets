package com.disparter.interpoc;
import java.util.ListResourceBundle;
 
public class ResourceBundle extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object [][] arr = {{"locale", "default"}};
        return arr;
    }
}