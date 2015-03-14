/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectdeposit;

import java.util.List;

/**
 *
 * @author said
 */
public interface Category {
    public static String[] categories = {"Siber"};
    
    public abstract String[] getInputStrings();
    public abstract void addRegistery(Registery reg);
    public abstract String getFileName();
    public abstract String getLocation();
    public abstract List<Registery> getRegisteryList();
}
