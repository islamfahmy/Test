/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus_station;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import jdk.nashorn.internal.codegen.types.Type;

/**
 *
 * @author Islam
 */
public class Manager {

    ArrayList<Bus> buses = new ArrayList<Bus>();
    
    ArrayList<Limo> limos= new ArrayList<Limo>();
    ArrayList<internal_trip> internal = new ArrayList<internal_trip>();
    ArrayList<External_trip> external = new ArrayList<External_trip>();
    ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayList<Driver> drivers = new ArrayList<Driver>();
    // Manager manger = new Manager();
    ArrayList<Integer> driversid = new ArrayList<Integer>();
static int internal_id=0,external_id=0,bus_id=0,customer_id=0,driver_id=0;
    public void add_trip_internal(String source, String destination, float price, float dis, int nostops, Bus b) {
        internal_trip temp = new internal_trip(source, destination, price, dis, nostops, internal_id++);
     //   temp.addveichle(b);
        internal.add(temp);

    }

    public void add_trip_external(String source, String destination, float price, float dis, int nostops, Bus b) {
        External_trip temp = new External_trip(source, destination, price, dis, nostops, external_id++);
     //   temp.addveichle(b);
        external.add(temp);

    }
    public void add_trip_internal(String source, String destination, float price, float dis, int nostops, int id, Limo l) {
        internal_trip temp = new internal_trip(source, destination, price, dis, nostops, id);
        temp.addveichle(l);
        internal.add(temp);
}
    public void add_trip_external(String source, String destination, float price, float dis, int nostops, int id, Limo l) {
        External_trip temp = new External_trip(source, destination, price, dis, nostops, id);
        temp.addveichle(l);
        external.add(temp);

    }
    public int authenication_m(String username, String pass) {

    String user="l",passs="l";
    if(user.equals(username)&&passs.equals(pass))
    	return 1;
    return 0;
    }
    
    public int remove_limo(int id)
    {
        int size = limos.size();
             while (size-- > 0) {
                 if (limos.get(size).getPlatenumber() == id) {
                     break;
                 }
             }
             if (size < 0) {
                 return 0;
             }
             limos.get(size).excute();
             return 1;
    }
    
    public ArrayList<Limo> getlimos() {
        return limos;
    }

    
public void addLimo(int max , int plate)
     {
         Limo temp = new Limo(max, plate);
         limos.add(temp);
     }

    public void addbus(int max, int platenumber) {
        Bus temp = new Bus(max, bus_id++);
        buses.add(temp);
    }

    public void addcustomer(int id, String name, String username, String password) {
        Customer temp = new Customer(customer_id++, name, username, password);
        customers.add(temp);

    }

    public void addDriver(int id, String name, String username, String password) {
        Driver temp = new Driver(driver_id++, name, username, password);
        drivers.add(temp);

    }
    
    public internal_trip checkRound(internal_trip i) {
    	int size = internal.size();
    	while(size-- > 0) {
    		if(internal.get(size).getDest().equals(i.getSource())) {
    			if(internal.get(size).getSource().equals(i.getDest()))
    				return internal.get(size);
    		}
    	}return null;
    }
    
    public External_trip checkRound(External_trip i) {
    	int size = external.size();
    	while(size-- > 0) {
    		if(external.get(size).getDest().equals(i.getSource())) {
    			if(external.get(size).getSource().equals(i.getDest()))
    				return external.get(size);
    		}
    	}return null;
    }
    
    public Driver authenication_d(String username, String pass) {

        int size = drivers.size();
    //	System.out.println(username+pass);
       Driver c=null;
        while (size-- > 0) {
            if ((drivers.get(size).getUsername()).equals(username)) {
                if (drivers.get(size).getPassword().equals(pass)) {
                    return drivers.get(size);

                }
                return c;
            }
        }
       return c ;
    }

    public int remove_trip(internal_trip x) {
            int size = internal.size();
            while (size-- > 0) {
                if (internal.get(size).getId() == x.getId()) {
                    break;
                }
            }
            if (size < 0) {
                return 0;
            }
            internal_trip temp = internal.get(size);
            temp.excute();
            internal.remove(size);
            return 1;
    }
    
    public int remove_trip(External_trip x) {
    	int size = external.size();
        while (size-- > 0) {
            if (external.get(size).getId() == x.getId()) {
                break;
            }
        }
        if (size < 0) {
            return 0;
        }
        external.get(size).excute();
        external.remove(size);
        return 1;
    }

    public int remove_bus(int id) {
        int size = buses.size();
        while (size-- > 0) {
            if (buses.get(size).getPlatenumber() == id) {
                break;
            }
        }
        if (size < 0) {
            return 0;
        }
        buses.get(size).excute();
        return 1;
    }

    public int remove_customer(int id) {
        int size = customers.size();
        while (size-- > 0) {
            if (customers.get(size).getId() == id) {
                break;
            }
        }
        if (size < 0) {
            return 0;
        }
        customers.get(size).excute();
        return 1;
    }

    private Customer search_customers(int id) {
        int size = customers.size();
        while (size-- > 0) {
            if (customers.get(size).getId() == id) {
                return customers.get(size);
            }

        }
        return null;
    }

    public Customer authenication(String username, String pass) {
      
    	int size = customers.size();
    //	System.out.println(username+pass);
       Customer c=null;
        while (size-- > 0) {
            if ((customers.get(size).getUsername()).equals(username)) {
                if (customers.get(size).getPassword().equals(pass)) {
                    return customers.get(size);
                    
                }
                return c;
            }
        }
       return c ;
    }
    //read files 

    public ArrayList<Bus> getBuses() {
        return buses;
    }

    public ArrayList<internal_trip> getInternal() {
        return internal;
    }

    public ArrayList<External_trip> getExternal() {
        return external;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public ArrayList<Integer> getDriversid() {
        return driversid;
    }

    /**
     *
     * @throws FileNotFoundException
     */
        public void read() throws FileNotFoundException  {    // read
        Scanner x = new Scanner(new File("Bus.txt"));

        while (x.hasNext()) {
            int max = Integer.parseInt(x.next());
            int plate = Integer.parseInt(x.next());
            if(plate>=bus_id)
               bus_id=plate+1;
             
            Bus b = new Bus(max, plate);
            buses.add(b);
            String temp = x.nextLine();

        }
        x = new Scanner(new File("Limo.txt"));

        while (x.hasNext()) {
            int max = Integer.parseInt(x.next());
            int plate = Integer.parseInt(x.next());
            Limo b = new Limo(max, plate);
            limos.add(b);
            String temp = x.nextLine();

        }
        x = new Scanner(new File("Driver.txt"));
        while (x.hasNext()) {
            int id = Integer.parseInt(x.next());
            String name = x.next();
            String username = x.next();
            String password = x.next();
            Driver d = new Driver(id, name, username, password);
            drivers.add(d);
            String temp = x.nextLine();
        }

        x = new Scanner(new File("Customer.txt"));
        while (x.hasNext()) {
        	int id = Integer.parseInt(x.next());
        	if(id>=customer_id)
        		customer_id=id+1;
            String name = x.next();
            String username = x.next();
            String password = x.next();

            Customer c = new Customer(id, name, username, password);
            customers.add(c);
            String temp = x.nextLine();
        }
        x = new Scanner(new File("Trip.txt"));
        while (x.hasNext()) {
            String type = x.next();
            if ("1".equals(type)) {
                String source = x.next();
                String destination = x.next();
                float price = Float.parseFloat(x.next());
                float dis = Float.parseFloat(x.next());
                int no = Integer.parseInt(x.next());
                int id = Integer.parseInt(x.next());
                if(id>=internal_id)
                	internal_id=id+1;
                internal_trip i = new internal_trip(source, destination, price, dis, no, id);
                internal.add(i);
                String temp = x.nextLine();
            } else  {
                String source = x.next();
                String destination = x.next();
                float price = Float.parseFloat(x.next());
                float dis = Float.parseFloat(x.next());
                int no = Integer.parseInt(x.next());
                int id = Integer.parseInt(x.next());
                if(id>=external_id)
                	external_id=id+1;
                External_trip i = new External_trip(source, destination, price, dis, no, id);
                external.add(i);
                String temp = x.nextLine();
            }
        }
        x = new Scanner(new File("Bus.txt"));
        while (x.hasNext()) {
            int max = Integer.parseInt(x.next());
            int plate = Integer.parseInt(x.next());
            // Bus b = new Bus(max, plate);
            //buses.add(b);
            while (!x.hasNext("del")) {
                int i = Integer.parseInt(x.next());
                int size = internal.size();
                while (size-- > 0) {
                    if (internal.get(size).getId() == i) {
                        break;
                    }

                }
                int size1 = buses.size();
                while (size1-- > 0) {
                    if (buses.get(size1).getPlatenumber() == plate) {
                        break;
                    }
                }
                buses.get(size1).addtrip(internal.get(size));
            }
            String temp = x.next();
            while (!x.hasNext("del")) {
                int i = Integer.parseInt(x.next());
                int size = external.size();
                while (size-- > 0) {
                    if (external.get(size).getId() == i) {
                        break;
                    }

                }
                int size1 = buses.size();
                while (size1-- > 0) {
                    if (buses.get(size1).getPlatenumber() == plate) {
                        break;
                    }
                }
                buses.get(size1).addtrip(external.get(size));
            }
            temp = x.next();

        }
        x = new Scanner(new File("Driver.txt"));
        while (x.hasNext()) {

            int id = Integer.parseInt(x.next());
            if(id>=driver_id)
               driver_id=id+1;
            String name = x.next();
            String username = x.next();
            String password = x.next();
            while (!x.hasNext("del")) {
                int i = Integer.parseInt(x.next());
                int size = internal.size();
                while (size-- > 0) {
                    if (internal.get(size).getId() == i) {
                        break;
                    }

                }
                int size1 = drivers.size();
                while (size1-- > 0) {
                    if (drivers.get(size1).getId() == id) {
                        break;
                    }
                }
                drivers.get(size1).add_trip(internal.get(size));

            }
            String temp = x.next();
            while (!x.hasNext("del")) {
                int i = Integer.parseInt(x.next());
                int size = external.size();
                while (size-- > 0) {
                    if (external.get(size).getId() == i) {
                        break;
                    }

                }
                int size1 = drivers.size();
                while (size1-- > 0) {
                    if (drivers.get(size1).getId() == id) {
                        break;
                    }
                }
                drivers.get(size1).add_trip(external.get(size));
            }
            temp = x.next();

        }

        x = new Scanner(new File("Customer.txt"));
        while (x.hasNext()) {
            int id = Integer.parseInt(x.next());
            String name = x.next();
            String username = x.next();
            String password = x.next();
            while (!x.hasNext("del")) {
               String s=x.next();
                System.out.println("internal"+s);
                int i = Integer.parseInt(s);
                int size = internal.size();
                while (size-- > 0) {
                    if (internal.get(size).getId() == i) {
                        break;
                    }
                    
                }
                int size1 = customers.size();
                while (size1-- > 0) {
                    if (customers.get(size1).getId() == id) {
                        break;
                    }
                }
                customers.get(size1).reserve(internal.get(size));

            }
            String temp = x.next();
            while (!x.hasNext("del")) {
               String s=x.next();
                System.out.println("External"+s);
               
                int i = Integer.parseInt(s);
                int size = external.size();
                while (size-- > 0) {
                    if (external.get(size).getId() == i) {
                        break;
                    }

                }
                int size1 = customers.size();
                while (size1-- > 0) {
                    if (customers.get(size1).getId() == i) {
                        break;
                    }
                }
                customers.get(size1).reserve(external.get(size));
            }
            temp = x.next();

        }
        x = new Scanner(new File("Trip.txt"));
        while (x.hasNext()) {
            String type = x.next();
            String source = x.next();
            String destination = x.next();
            float price = Float.parseFloat(x.next());
            float dis = Float.parseFloat(x.next());
            int no = Integer.parseInt(x.next());
            int id = Integer.parseInt(x.next());
          String s= x.next();
          int bus_plate=0;
          int trigger =0;
          if(!s.equals("null"))
          {
            bus_plate = Integer.parseInt(s);

          }
          else trigger=1;
            if("1".equals(type)){
                            int size = buses.size();

            if(trigger==0){
            while (size-- > 0) {
                if (buses.get(size).getPlatenumber() == bus_plate) {
                    break;
                }
            }
            
            }
            
            int size1 = internal.size();
            while (size1-- > 0) {
                if (internal.get(size1).getId() == id) {
                    break;
                }
            } Bus b =null;
            if(trigger ==0)
            internal.get(size1).addveichle(buses.get(size));
            else  internal.get(size1).addveichle(b);
            size = drivers.size();
            if (x.hasNext("null")) {
                {internal.get(size1).setD(null);String temp =x.next();}
            } else  {
                int driver_id = Integer.parseInt(x.next());
                while (size-- > 0) {
                    if (drivers.get(size).getId() == driver_id) {
                        internal.get(size1).setD(drivers.get(size));
                        break;
                    }
                }
            }
            size = customers.size();
           while(!x.hasNext("del"))
           {int sizetemp = size;
                int customer_id = Integer.parseInt(x.next());
                while (sizetemp-- > 0) {
                    if (customers.get(sizetemp).getId() == customer_id) {
                        internal.get(size1).addcustomer(customers.get(sizetemp));
                    }
                }
           }
            String temp = x.next();
        }
        else  { int size =buses.size();
             
        	if(trigger==0){
                while (size-- > 0) {
                    if (buses.get(size).getPlatenumber() == bus_plate) {
                        break;
                    }
                }
                
                }
                
                int size1 = external.size();
                while (size1-- > 0) {
                    if (external.get(size1).getId() == id) {
                        break;
                    }
                } Bus b =null; 
                if(trigger ==0)
                external.get(size1).addveichle(buses.get(size));
                else  external.get(size1).addveichle(b);
                size = drivers.size();
                if (x.hasNext("null")) {
                    {external.get(size1).setD(null);String temp =x.next();}
                } else  {
                    int driver_id = Integer.parseInt(x.next());
                    while (size-- > 0) {
                        if (drivers.get(size).getId() == driver_id) {
                            external.get(size1).setD(drivers.get(size));
                            break;
                        }
                    }
                }
                size = customers.size();
               while(!x.hasNext("del"))
               {int sizetemp = size;
                    int customer_id = Integer.parseInt(x.next());
                    while (sizetemp-- > 0) {
                        if (customers.get(sizetemp).getId() == customer_id) {
                            external.get(size1).addcustomer(customers.get(sizetemp));
                        }
                    }
               }
                String temp = x.next();
            }        }
    }


    public void saveonfiles() throws IOException {
        FileWriter writer = new FileWriter("Bus.txt", false);
        int size = buses.size();
        while (size-- > 0) {
                Bus temp = buses.get(size);
            writer.write(String.valueOf(temp.getMax_capacity()));
            writer.write(" ");
            writer.write(String.valueOf(temp.getPlatenumber()));
            writer.write(" ");

            ArrayList<internal_trip> temp_list;
            temp_list = temp.getInternal();
            int size1 = temp_list.size();
            while (size1-- > 0) {
                writer.write(String.valueOf(temp_list.get(size1).getId()));
                writer.write(" ");
            }
            writer.write("del");
            writer.write(" ");
            ArrayList<External_trip> temp_list1 = temp.getExternal();
            size1 = temp_list1.size();
            while (size1-- > 0) {
                writer.write(String.valueOf(temp_list1.get(size1).getId()));
                writer.write(" ");
            }
            writer.write("del");
            writer.write("\n");

        } 
        
        writer.close();
        writer = new FileWriter("Limo.txt", false);
        size = limos.size();
       while (size-- > 0) {
               Limo temp = limos.get(size);
               writer.write("2 ");
           writer.write(String.valueOf(temp.getMax_capacity()));
           writer.write(" ");
           writer.write(String.valueOf(temp.getPlatenumber()));
           writer.write(" ");

           ArrayList<internal_trip> temp_list;
           temp_list = temp.getInternal();
           int size1 = temp_list.size();
           while (size1-- > 0) {
               writer.write(String.valueOf(temp_list.get(size1).getId()));
               writer.write(" ");
           }
           writer.write("del");
           writer.write(" ");
           ArrayList<External_trip> temp_list1 = temp.getExternal();
           size1 = temp_list1.size();
           while (size1-- > 0) {
               writer.write(String.valueOf(temp_list1.get(size1).getId()));
               writer.write(" ");
           }
           writer.write("del");
           writer.write("\n");

       } 
       writer.close();
       
        writer = new FileWriter("Driver.txt", false);
        size = drivers.size();
        while (size-- > 0) {
            Driver temp = drivers.get(size);
            writer.write(String.valueOf(temp.getId()));
            writer.write(" ");
            writer.write(temp.getName());
            writer.write(" ");
           writer.write(temp.getUsername());
           writer.write(" ");
            writer.write(temp.getPassword());
            writer.write(" ");
            ArrayList<internal_trip> temp_list;
            temp_list = temp.getInternal();
            int size1 = temp_list.size();
            while (size1-- > 0) {
                writer.write(String.valueOf(temp_list.get(size1).getId()));
                writer.write(" ");
            }
           writer.write("del");
            writer.write(" ");
            ArrayList<External_trip> temp_list1 = temp.getExternal();
            size1 = temp_list1.size();
            while (size1-- > 0) {
                writer.write(String.valueOf(temp_list1.get(size1).getId()));
                writer.write(" ");
            }
            writer.write("del");
            writer.write("\n");
        }
        writer.close();
        writer = new FileWriter("Customer.txt", false);
        size = customers.size();
        while (size-- > 0) {
            Customer temp = customers.get(size);
            writer.write(String.valueOf(temp.getId()));
            writer.write(" ");
            writer.write(temp.getName());
            writer.write(" ");
            writer.write(temp.getUsername());
            writer.write(" ");
            writer.write(temp.getPassword());
            writer.write(" ");
            ArrayList<internal_trip> temp_list;
            temp_list = temp.getInternal();
            int size1 = temp_list.size();
            while (size1-- > 0) {
                writer.write(String.valueOf(temp_list.get(size1).getId()));
                writer.write(" ");
            }
           writer.write("del");
            writer.write(" ");
            ArrayList<External_trip> temp_list1 = temp.getExternal();
            size1 = temp_list1.size();
            while (size1-- > 0) {
                writer.write(String.valueOf(temp_list1.get(size1).getId()));
                writer.write(" ");
            }
            writer.write("del");
            writer.write("\n");

        }
        writer.close();
        writer = new FileWriter("Trip.txt");
        size = internal.size();
        while (size-- > 0) {
            writer.write("1");
            
            writer.write(" ");
            internal_trip temp = internal.get(size);
            writer.write(temp.getSource());
            writer.write(" ");
            writer.write(temp.getDest());
            writer.write(" ");
            writer.write(String.valueOf(temp.getPrice()));
            writer.write(" ");
            writer.write(String.valueOf(temp.getDist()));
            writer.write(" ");
            writer.write(String.valueOf(temp.getNo_stops()));
            writer.write(" ");
            writer.write(String.valueOf(temp.getId()));
            writer.write(" ");
            if(temp.getBus()==null)
                writer.write("null");
            else writer.write(String.valueOf(temp.getBus().getPlatenumber()));
            writer.write(" ");
            if (temp.getD() == null) {
                writer.write("null");
                writer.write(" ");
            } else {
                writer.write(String.valueOf(temp.getD().getId()));
                writer.write(" ");
            }
            ArrayList<Customer> temp_list = temp.getCustomers();

            int size1 = temp_list.size();
            while (size1-- > 0) {
                writer.write(String.valueOf(temp_list.get(size1).getId()));
                writer.write(" ");
            }
            writer.write("del");    
            writer.write("\n");

        }
        size = external.size();
        while (size-- > 0) {
            External_trip temp = external.get(size);
            writer.write("2");
            writer.write(" ");
            writer.write(temp.getSource());
            writer.write(" ");
            writer.write(temp.getDest());
            writer.write(" ");
            writer.write(String.valueOf(temp.getPrice()));
            writer.write(" ");
            writer.write(String.valueOf(temp.getDist()));
            writer.write(" ");
            writer.write(String.valueOf(temp.getNo_stops()));
            writer.write(" ");
            writer.write(String.valueOf(temp.getId()));
            writer.write(" ");
            if(temp.getBus()==null)
                writer.write("null");
            else writer.write(String.valueOf(temp.getBus().getPlatenumber()));
            writer.write(" ");
            if (temp.getD() == null) {
                writer.write("null");
                writer.write(" ");
            } else {
                writer.write(String.valueOf(temp.getD().getId()));
                writer.write(" ");
            }
            ArrayList<Customer> temp_list = temp.getCustomers();

            int size1 = temp_list.size();
            while (size1-- > 0) {
                writer.write(String.valueOf(temp_list.get(size1).getId()));
                writer.write(" ");
            }
            writer.write("del");
            writer.write(" ");
            writer.write("\n");
        }
        writer.close();
    }
}
