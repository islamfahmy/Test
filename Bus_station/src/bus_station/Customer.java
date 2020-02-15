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
public class Customer extends Person {

    ArrayList<internal_trip> internal = new ArrayList<internal_trip>();
    ArrayList<External_trip> external = new ArrayList<External_trip>();

    public Customer(int id, String name, String username, String password) {
        setId(id);
        setName(name);
        setPassword(password);
        setUsername(username);
    }

    public ArrayList<internal_trip> getInternal() {
        return internal;
    }

    public ArrayList<External_trip> getExternal() {
        return external;
    }

    public int reserve(External_trip t) {
        if (t.addcustomer(this) == 1) {
            external.add(t);
            return 1;
        }
  return 0 ;
    }

    /* String  printAvailabletrips(Manager m )
    {
        ArrayList<internal_trip> temp_internal=m.getInternal();
        ArrayList<External_trip> temp_external=m.getExternal();
        
        
    }*/
    public int reserve(internal_trip t) {
          if (t.addcustomer(this) == 1) {
            internal.add(t);
            return 1;
        }
  return 0 ;
    }

    public ArrayList<internal_trip> print_int() {
        return internal;
    }

    public ArrayList<External_trip> print_ext() {
        return external;
    }

    public void deletetrip(internal_trip e) {
    	internal.remove(e);
    	e.removecustomer(this);
    }
    public void deletetrip(External_trip e) {
        external.remove(e);
        e.removecustomer(this);
    }

    public void print_trips() {
        int size = internal.size();
        internal_trip temp;
        while (size-- > 0) {
            temp = internal.get(size);
            System.out.println("source :" + temp.getSource() + " Price :" + temp.getPrice());
        }
    }

    public void excute() {
        int size = external.size();
        while (size-- > 0) {
            external.get(size).removecustomer(this);

        }
        size = internal.size();
        while (size-- > 0) {
            internal.get(size).removecustomer(this);

        }

    }
}
