/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus_station;

/**
 *
 * @author Islam
 */
public class External_trip extends Trip {
   static int type=2;

    public  External_trip(String source, String destination, float price, float dis, int no_stops, int id) {
        setDest(destination);
        setDist(dis);
        setPrice(price);
        setSource(source);
        setNo_stops(no_stops);
        setId(id);
    }
    public String toString() {
    	String s = "external "+" "+getSource()+" "+getDest()+" "+String.valueOf(getPrice())+" "+String.valueOf(getDist())+" "+String.valueOf(getNo_stops());
		return s;
	}

    public void excute()
    {
         int size= customers.size();
         while(size-->0)
         {
            customers.get(size).deletetrip(this);
         }
         size= customers.size();
         while(size-->0)
         {
            customers.get(size).deletetrip(this);
         }if(getD()!=null)getD().remove_trip(this);
    }
}
