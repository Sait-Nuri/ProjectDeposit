/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectdeposit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author said
 */
public class Menu extends OptionalProcess implements Operations{
    
    private int operationId;
    private int categoryId;
    private int numberOfOp; 
    private int numberOfCategory;
    private Category currentCategory;
    private List<Category> categoryList;
    private BufferedReader br;
    
    public Menu() {
        
    }
    
    
    @Override
    public void init() {
        categoryList = new LinkedList<>();
        br = new BufferedReader(new InputStreamReader(System.in));
        numberOfOp = Operations.operations.length;
        numberOfCategory = Category.categories.length;
        currentCategory = null;
    }

    @Override
    public void progress() {
        
        String value = null;
        
        while(true){
            
            promptOptions();
            
            startOperation(); //add(), remove(), get() runs here
            
            System.out.print("Back to Main Menu? (y/n):");
        
            try {              
                value = br.readLine(); // read from console
            } catch (IOException ex) {
                Logger.getLogger(Registery.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(!value.equals("y")){
                System.out.println("Progress finished");
                break;
            }
        }
        
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void promptOptions() {
        
        selectOperation();
        selectCategory();
    }
    
    private void selectOperation() {
        
        printOperations();

        try {               
            String value = br.readLine(); // read from console
            operationId = Integer.valueOf(value);
        } catch (IOException ex) {
            Logger.getLogger(Registery.class.getName()).log(Level.SEVERE, null, ex);
        }

        if( (operationId > operations.length) || operationId <= 0 ){
            System.out.println("\nInvalid Selection! Try again...");
        }
        
    }

    private void printOperations(){
        
        System.out.println("Select an operation:");
        
        for (int i = 0; i < numberOfOp; i++) {
            System.out.println( i+1 + "- " + operations[i]);
        }
        
        System.out.print("\n>");
        
    }
    
    private void selectCategory() {
        
        printCategories();
        
        try {               
            String value = br.readLine(); // read from console
            categoryId = Integer.valueOf(value);
        } catch (IOException ex) {
            Logger.getLogger(Registery.class.getName()).log(Level.SEVERE, null, ex);
        }

        if( (categoryId > Category.categories.length) || categoryId <= 0 ){
            System.out.println("\nInvalid Selection! Try again...");
        }
    }
    
    private void printCategories() {
        System.out.println("Select a category:");
        
        for (int i = 0; i < numberOfCategory; i++) {
            System.out.println( i+1 + "- " + Category.categories[i]);
        }
        
        System.out.print("\n>");
    }
    
    private void startOperation() {
        
        currentCategory = CategoryFactory.getRelatedCategory(categoryId);
        getCategoryList().add(currentCategory);
        
        if(operationId == 1){
            add();
        }else if(operationId == 2){
            remove();
        }else if(operationId == 3){
            get();
        }else if(operationId == 4){
            modify();
        }
        
        
    }
    
    
    
    @Override
    public void add() {
        Registery reg;
        
        String value = null;
        
        while(true){
            
            reg = new Registery(currentCategory);
            currentCategory.addRegistery(reg);    
            
            reg.init(br);
            
            System.out.print("Continue? (y/n):");
        
            try {              
                value = br.readLine(); // read from console
            } catch (IOException ex) {
                ex.printStackTrace();
                System.exit(-1);
            }
            
            if(!(value.equals("y"))){
                System.out.println("Progress finished");
                break;
            }
        }
        
        ObjectStorage store = new ObjectStorage(categoryList);
        store.run();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void get() {
        GetDataOptional getdata = new GetObjectOptional(currentCategory, br);
        getdata.run();
    }

    @Override
    public void modify() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the categoryList
     */
    public List<Category> getCategoryList() {
        return categoryList;
    }

    

    

    

    

    
    
}
