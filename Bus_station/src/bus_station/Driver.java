/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus_station;
//import java.sql.Driver;

import java.util.ArrayList;

/**
 *
 * @author Islam
 */
public class Driver extends Person {

    ArrayList<internal_trip> internal = new ArrayList<internal_trip>();
    ArrayList<External_trip> external = new ArrayList<External_trip>();

    public Driver(int id, String name, String username, String password) {
        setId(id);
        setName(name);
        setPassword(password);
        setUsername(username);
    }
    
    public String toString() {
    	String s = this.getName();
		return s;
	}

    public ArrayList<internal_trip> getInternal() {
        return internal;
    }

    public ArrayList<External_trip> getExternal() {
        return external;
    }

    public void add_trip(internal_trip i) {
        internal.add(i);
    }

    public void add_trip(External_trip e) {
        external.add(e);
    }

    public int remove_trip(internal_trip i) {
        if (!internal.contains(i)) {
            return 0;
        }
        internal.remove(i);
        return 1;
    }

    public int remove_trip(External_trip i) {
        if (!external.contains(i)) {
            return 0;
        }
        external.remove(i);
        return 1;
    }
    public void excute() {
        int size = external.size();
        while (size-- > 0) {
            external.get(size).setD(null);

        }
        size = internal.size();
        while (size-- > 0) {
            internal.get(size).setD(null);

        }
    }
}
