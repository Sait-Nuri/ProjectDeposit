/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectdeposit;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author said
 */
public class GetObjectOptional extends GetDataOptional{

    private final Category category;
    private ObjectInputStream ois;
    private final String filepath;
    private final List<Registery> registers;
    private final BufferedReader bf;
    private int printOption;
    
    GetObjectOptional(Category currentCategory, BufferedReader bf) {
        category = currentCategory;
        filepath = currentCategory.getLocation() + currentCategory.getFileName();
        registers = new LinkedList<>();
        this.bf = bf;
        super.options = new String[]{"Screen","File"};
    }
    
    @Override
    public void init() {
        
        try {
            ois = new ObjectInputStream(new FileInputStream(filepath));
        } catch (IOException ex) {
            Logger.getLogger(GetObjectOptional.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public void progress() {
        try {
            Data data;
            Registery reg;
            
            while(true){
                try{
                    data = (Data) ois.readObject();
                    reg = new Registery(category);
                    registers.add(reg);
                    reg.setData(data);
                }catch(EOFException ex){
                    break;
                }  
            }
            
            ois.close();
        }catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(GetObjectOptional.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.regdata = registers;
        
        startOperations();
    }

    @Override
    public void promptOptions() {
        
        printOptions();
    }

    private void printOptions() {
        
        System.out.println("Where to print data?");
        
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + ": " + options[i]);
        }
        
        try {
            System.out.print(">");
            printOption = Integer.valueOf(bf.readLine());
            
        } catch (IOException ex) {
            Logger.getLogger(GetObjectOptional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void startOperations() {
        
        if(printOption == 1){
            printToScreen();
        }else if(printOption == 2){
            PrintToFile();
        }
    }

    private void PrintToFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void printToScreen() {
        
        for (int i = 0; i < registers.size(); i++) {
            registers.get(i).printData();
        }
    }
    
}
