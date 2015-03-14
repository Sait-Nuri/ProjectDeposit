/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectdeposit;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author said
 */
public class ObjectStorage extends StoreRegistery{
    
    private ObjectOutputStream oos;
    
    ObjectStorage(List<Category> catList) {
        this.categoryList = catList;
    }
    
    @Override
    public void store() {
        this.data = currentCategory.getRegisteryList();
        try {
            this.oos = new ObjectOutputStream(fout);
        } catch (IOException ex) {
            Logger.getLogger(ObjectStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < numofreg; i++) {
            try {
                Data d = data.get(i).getData(); 
                oos.writeObject(d);
                oos.flush();
                
            } catch (IOException ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
        }
        
        try {
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(ObjectStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Data has been stored successfully");
    }

    @Override
    public void init() {
        
        
    }

    
}
