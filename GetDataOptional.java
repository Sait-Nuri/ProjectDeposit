package projectdeposit;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author said
 */
public abstract class GetDataOptional extends OptionalDataProcess implements Optional{

    public GetDataOptional() {
        
    }
    
    public List<Registery> getRegData(){
        return regdata;
    }
}
