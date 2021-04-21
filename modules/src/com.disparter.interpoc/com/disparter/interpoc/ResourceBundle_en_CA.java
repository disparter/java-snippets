package com.disparter.interpoc;
import java.util.ListResourceBundle;
 
public class ResourceBundle_en_CA extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object [][] arr = {{"locale", "Canadian English"}};
        return arr;
    }
}