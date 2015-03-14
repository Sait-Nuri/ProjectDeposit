/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectdeposit;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author said
 */
public class Data  implements Serializable{
    
        private static final long serialVersionUID = 6529685098267757690L;
        private LinkedList<HashMap<String, String>> data;

        public Data(LinkedList<HashMap<String, String>> data) {
            this.data = data;
        }

    /**
     * @return the data
     */
    public LinkedList<HashMap<String, String>> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(LinkedList<HashMap<String, String>> data) {
        this.data = data;
    }
    }
