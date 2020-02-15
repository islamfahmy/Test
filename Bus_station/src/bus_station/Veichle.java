/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bus_station;
import java.util.ArrayList;
/**
 *
 * @author Islam
 */
public class Veichle {
  
        private int Max_capacity;
        private int Current_capacity=0;
        private int platenumber;
        //Driver d;
        
        ArrayList<internal_trip> internal= new ArrayList<internal_trip>();
        ArrayList<External_trip> external= new ArrayList<External_trip>(); 
    
    public int add_customer( )//returns 1 when added 0 when exceeded max number 
    {
        if(Current_capacity++<Max_capacity)
        {   
                    return  1;
        }
        
        Current_capacity--;
        return 0;
    }
    public void remove_customer()//returns 1 when added 0 when exceeded max number 
    {   
      Current_capacity--;
    }

    public int getCurrent_capacity() {
        return Current_capacity;
    }

    /*public ArrayList<Integer> getPassenger_id() {
        return Passenger_id;
    }*/
    
    public void setMax_capacity(int Max_capacity) {
        this.Max_capacity = Max_capacity;
    }

    public int getMax_capacity() {
        return Max_capacity;
    }

    
    

    public void setPlatenumber(int platenumber) {
        this.platenumber = platenumber;
    }

    public int getPlatenumber() {
        return platenumber;
    }
    public void addtrip(internal_trip i)
    {  
        internal.add(i);
    }
    public boolean isfull()
    {
        return Current_capacity==Max_capacity;
    }
    public void addtrip(External_trip i)
    {  
        external.add(i);
    }
    public int removetrip(internal_trip i)
    {
        if(!internal.contains(i))
            return 0 ;
        internal.remove(i);
        return 1;
    }
    public int removetrip(External_trip i)
    {
        if(!external.contains(i))
            return 0 ;
        external.remove(i);
        return 1;
    }
    public void excute()
    {
        
        int size = internal.size();
        while(size-->0)
        {
         internal.get(size).removeveichle();
        }
        size = external.size();
        while(size-->0)
        {
         external.get(size).removeveichle();
        }
    }

    public ArrayList<internal_trip> getInternal() {
        return internal;
    }

    public ArrayList<External_trip> getExternal() {
        return external;
    }
    }
