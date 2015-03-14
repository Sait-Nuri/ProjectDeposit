/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectdeposit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author said
 */
public abstract class StoreRegistery extends Process{
    
    String location;
    int numofreg;
    List<Registery> data;
    List<Category> categoryList;
    FileOutputStream fout;
    String filename;
    Category currentCategory;
    
    public abstract void store();
    
    @Override
    public void progress() {
        int category_size = categoryList.size();
        
        for (int i = 0; i < category_size; i++) {
            currentCategory = categoryList.get(i);
            
            this.filename = currentCategory.getFileName();
            this.location = currentCategory.getLocation();
            this.numofreg = currentCategory.getRegisteryList().size();

            try {
                this.fout = new FileOutputStream(location+filename, true);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                System.exit(-1);
            } catch (IOException ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
            
            store();
        }
    }
}
