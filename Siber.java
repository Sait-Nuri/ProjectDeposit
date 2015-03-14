/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectdeposit;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author said
 */
public class Siber extends AbstractCategory{
    
    private final String CATEGORY_NAME = "siber";
    private static final String[] INPUTKEYS = {"Name", "Number", "Link", "Adv"};
    private final int CATEGORY_ID = 0;
    public static final String FILENAME = "facebook.reg";
    //public static final String LOCATION = "/home/said/Desktop/";
    public static final String LOCATION = "/usr/local/bin/";
    
    public Siber(){
        this.categoryId = CATEGORY_ID;
        this.categoryNum = INPUTKEYS.length;
        this.CategoryName = CATEGORY_NAME;
        this.entries = new LinkedList<>();
    }

    @Override
    public String[] getInputStrings() {
        return INPUTKEYS;
    }
    
    @Override
    public String getFileName() {
        return FILENAME;
    }

    @Override
    public String getLocation() {
        return LOCATION;
    }
    
    
}
