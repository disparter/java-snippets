package com.disparter.interpoc;
import java.util.ListResourceBundle;
 
public class ResourceBundle_fr extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object [][] arr = {{"locale", "French"}};
        return arr;
    }
}