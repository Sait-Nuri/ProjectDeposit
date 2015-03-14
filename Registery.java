/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectdeposit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author said
 */
public class Registery{
    private LinkedList<HashMap<String, String>> inputField;
    private Data regdata;
    private BufferedReader br;
    private final Category category;
    int numberOfInputField;    
    String[] inputFieldsNames;
    
    public Registery(Category category){
        this.category = category;
        this.br = null;
        this.numberOfInputField = category.getInputStrings().length;
        this.inputFieldsNames = category.getInputStrings();
    }
    
    public void init(BufferedReader br){
        HashMap<String,String> map;
        this.br = br;
        this.inputField = new LinkedList<>();
        this.regdata = new Data(inputField);
        
        for(int i = 0; i < numberOfInputField; i++){
            
            //Prompt field value
            System.out.println(inputFieldsNames[i] + ": ");
            
            try {               
                String value = br.readLine(); // read from console
                map = new HashMap<>();
                map.put(inputFieldsNames[i], value);
                inputField.add(map);
            } catch (IOException ex) {
                System.out.println("Okuma hatası");
                ex.printStackTrace();
                System.exit(-1);
            }
        }
    }

    /**
     * @return the data
     */
    public Data getData() {
        return regdata;
    }

    /**
     * @return the inputField
     */
    public LinkedList<HashMap<String, String>> getInputField() {
        return inputField;
    }

    /**
     * @param data the data to set
     */
    public void setData(Data data) {
        regdata = data;
    }

    public void printData() {
        HashMap<String, String> map;
        String[] keys = category.getInputStrings();
        
        System.out.println("-----------------------------------");
        for (int i = 0; i < keys.length; i++) {
            map = regdata.getData().get(i);
            System.out.println(keys[i] + ": " + map.get(keys[i]));
        }
        System.out.println("-----------------------------------");
    }
    
    
}
