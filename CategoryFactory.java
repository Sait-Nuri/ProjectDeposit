/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectdeposit;

/**
 *
 * @author said
 */
class CategoryFactory {
    
    public static Category getRelatedCategory(int categoryId){
        
        if(categoryId == 1){
            return new Siber();
        }
        
        return null;
    }
}
