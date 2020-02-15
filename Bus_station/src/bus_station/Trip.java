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
public class Trip {

    private String source;
    private String dest;
    private float price;
    private float dist;
    private int no_stops;
    protected int type;
    protected Bus bus=null;
    private int id;
    Driver d;
    private Limo limo=null;
    
    public void addveichle(Limo limo) {
        this.limo = limo;
    }
    public Limo getLimo()
    {
        return limo;
    } 
    public void setD(Driver d) {
        this.d = d;
    }

    public Driver getD() {
        return d;
    }
    ArrayList<Customer> customers = new ArrayList<Customer>();
    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Bus getBus() {
        return bus;
    }

    public ArrayList<Customer> getlist() {
        return customers;
    }

    void addveichle(Bus bus) {
        type = 0;
        this.bus = bus;
    }

    public void removeveichle() {
        bus = null;
        limo = null;
    }

  
    public int getId() {
        return id;
    }
  public int addcustomer (Customer c)
  {  if(bus==null)
	  return 1;
      if(bus.add_customer()==0)
          return 0 ;
      customers.add(c);
      return bus.add_customer();
  }
    public int removecustomer(Customer c)
    {
       if(bus!=null)
    	bus.remove_customer();
         customers.remove(c);
         return 1;
    }
    public int getNo_stops() {
        return no_stops;
    }

    public void setNo_stops(int no_stops) {
        this.no_stops = no_stops;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDist(float dist) {
        this.dist = dist;
    }

    public String getSource() {
        return source;
    }

    public String getDest() {
        return dest;
    }

    public float getPrice() {
        return price;
    }

    public float getDist() {
        return dist;
    }
   
    public void excute()
    {}
}


