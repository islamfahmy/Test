/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus_station;

import java.util.ArrayList;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 *
 * @author Islam
 */
public class internal_trip extends Trip{
    static int type=1;
   // ArrayList<Customer> customers = new ArrayList<Customer>();
     int trigger = 0;
    public  internal_trip(String source,String destination,float price,float dis,int no_stops,int id) {
        setDest(destination);
        setDist(dis);
        setPrice(price);
        setSource(source);
        setNo_stops(no_stops);   
        setId(id);
    }
    public String toString() {
    	String s = "internal "+" "+getSource()+" "+getDest()+" "+String.valueOf(getPrice())+" "+String.valueOf(getDist())+" "+String.valueOf(getNo_stops());
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
         } //System.out.println(getD().getName());
         if(getD()!=null) 
         {getD().remove_trip(this);
         
         }
    }
   
   }

