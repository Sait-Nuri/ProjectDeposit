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
public abstract class AbstractCategory implements Category{
    
    int categoryId;
    int categoryNum;
    String CategoryName;
    List<Registery> entries;
    
    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @return the categoryNum
     */
    public int getCategoryNum() {
        return categoryNum;
    }

    /**
     * @return the CategoryName
     */
    public String getCategoryName() {
        return CategoryName;
    }
    
    @Override
    public void addRegistery(Registery reg) {
        entries.add(reg);
    }
    
    @Override
    public List<Registery> getRegisteryList() {
        return entries;
    }
}
