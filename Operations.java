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
interface Operations {
    public static String[] operations = {"add", "remove", "get", "modify"};
    
    public void add();
    public void remove();
    public void get();
    public void modify();
    
}
