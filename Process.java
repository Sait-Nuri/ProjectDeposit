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
public abstract class Process {
    
    public abstract void init();
    public abstract void progress();
    
    public void run(){
        init();
        progress();
    }
}
