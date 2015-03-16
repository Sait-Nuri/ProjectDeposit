/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectdeposit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    File file;
    String filename;
    Category currentCategory;
    boolean exist;
    public abstract int store();
    
    @Override
    public void init() {
        
        
    }
    
    @Override
    public void progress() {
        int category_size = categoryList.size();
        int totalregnum = 0;
        
        for (int i = 0; i < category_size; i++) {
            currentCategory = categoryList.get(i);
            
            this.filename = currentCategory.getFileName();
            this.location = currentCategory.getLocation();
            this.numofreg = currentCategory.getRegisteryList().size();

            try {
                this.file = new File(location+filename);
                
                if(!file.exists()){
                    exist = false;
                    this.fout = new FileOutputStream(file);
                    //this.oos = new ObjectOutputStream(fout);
                }else{
                    exist = true;
                    this.fout = new FileOutputStream(file, true);
                    //this.oos = new AppendableObjectOutputStream(fout);
                }
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GetObjectOptional.class.getName()).log(Level.SEVERE, file.getAbsolutePath() + " not found", ex);
                break;
            }
            
            totalregnum += store();
        }
        
        System.out.println(totalregnum + " data has been stored successfully");
    }
    
    
    
    
}
