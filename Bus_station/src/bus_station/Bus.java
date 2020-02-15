/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus_station;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 *
 * @author Islam
 */
public class Bus extends Veichle {
    
    public Bus(int max,int platenumber) {
         
         setMax_capacity(max);
         setPlatenumber(platenumber);
    }
    
    
    
}
