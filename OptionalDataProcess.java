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
public abstract class OptionalDataProcess extends DataProcess implements Optional{
    
    String[] options;
    
    @Override
    public void run(){
        init();
        promptOptions();
        progress();
    }
    
    public String[] getOptions(){
        return options;
    }
}
