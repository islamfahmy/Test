package Gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus_station.Customer;
import bus_station.External_trip;
import bus_station.Manager;
import bus_station.internal_trip;
import javafx.scene.control.ComboBox;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class PassengerProfileGui extends JFrame {

	private JPanel contentPane;
    static Manager m;
    int i;
     static Customer c;
 	PassengerLoginGui p;
	PassengerBookedTripsGui p1;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassengerProfileGui frame = new PassengerProfileGui(m,c);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public PassengerProfileGui(Manager m, Customer c) throws FileNotFoundException {
		
		PassengerProfileGui.m=m;
		PassengerProfileGui.c=c;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.c=c;
		this.m = m;
		JButton button_2 = new JButton("booked trips");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				p1 = new PassengerBookedTripsGui(m,c);
				p1.setVisible(true);
			}
		});
		button_2.setBounds(108, 298, 147, 60);
		contentPane.add(button_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(108, 117, 796, 22);
		contentPane.add(comboBox);
		
	    ArrayList<internal_trip>internal=	m.getInternal();
		int size=internal.size();
		while(size-->0)
		{   
			String bus,driver;
		  if(internal.get(size).getBus()==null)bus="null";else bus=String.valueOf(internal.get(size).getBus().getPlatenumber());
		  if(internal.get(size).getBus()==null)
		  {  
		  if(internal.get(size).getD()==null)driver="null";else driver=internal.get(size).getD().getName();
		  comboBox.addItem(internal.get(size));}
		  else if (!internal.get(size).getBus().isfull())
		  {
			  if(internal.get(size).getD()==null)driver="null";else driver=internal.get(size).getD().getName();
			  comboBox.addItem(internal.get(size));}
			   
		  }
		
		
		JButton button = new JButton("book Round Trip");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(	m.checkRound((internal_trip)comboBox.getSelectedItem())==null)
					JOptionPane.showMessageDialog(null, "not round trips ");
			
			else {
				c.reserve((internal_trip)comboBox.getSelectedItem());
				c.reserve(m.checkRound((internal_trip)comboBox.getSelectedItem()));
			}
			}
		});
		button.setBounds(762, 74, 142, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("book one Way");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                int x= c.reserve(((internal_trip)comboBox.getSelectedItem()));
                if(x==0)
                	JOptionPane.showMessageDialog(null, "no avaialable places");
                
			}
		});
		button_1.setBounds(762, 27, 142, 25);
		contentPane.add(button_1);
		
				
				
		JLabel lblInternalTrips = new JLabel("internal Trips:");
		lblInternalTrips.setBounds(12, 120, 84, 16);
		contentPane.add(lblInternalTrips);
		
		JButton button_3 = new JButton("Logout");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					m.saveonfiles();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				contentPane.setVisible(false);
				dispose();
				p = new PassengerLoginGui(m);
				p.setVisible(true);
			}
		});
		button_3.setBounds(12, 13, 99, 53);
		contentPane.add(button_3);
		
		JLabel lblExternalTrips = new JLabel("external Trips:");
		lblExternalTrips.setBounds(12, 163, 84, 16);
		contentPane.add(lblExternalTrips);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(108, 160, 796, 22);
		contentPane.add(comboBox_1);
		
		ArrayList<External_trip>external=	m.getExternal();
		int size1=external.size();
		while(size1-->0)
		{   
			String bus,driver;
		  if(external.get(size1).getBus()==null)bus="null";else bus=String.valueOf(external.get(size1).getBus().getPlatenumber());
		  if(external.get(size1).getBus()==null)
		  {  
		  if(external.get(size1).getD()==null)driver="null";else driver=external.get(size1).getD().getName();
		  comboBox_1.addItem(external.get(size1));}
		  else if (!external.get(size1).getBus().isfull())
		  {
			  if(external.get(size1).getD()==null)driver="null";else driver=external.get(size1).getD().getName();
			  comboBox_1.addItem(external.get(size1));}
			   
		  }
		
		JButton btnBookOneWay = new JButton("book one way");
		btnBookOneWay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int x= c.reserve(((External_trip)comboBox_1.getSelectedItem()));
	                if(x==0)
	                	JOptionPane.showMessageDialog(null, "no avaialable places");
			}
		});
		btnBookOneWay.setBounds(762, 195, 142, 25);
		contentPane.add(btnBookOneWay);
		
		JButton btnBookRoundTrip = new JButton("book round Trip");
		btnBookRoundTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(	m.checkRound((External_trip)comboBox_1.getSelectedItem())==null)
					JOptionPane.showMessageDialog(null, "not round trips ");
			
			else {
				c.reserve((External_trip)comboBox_1.getSelectedItem());
				c.reserve(m.checkRound((External_trip)comboBox_1.getSelectedItem()));
			}
			}
		});
		btnBookRoundTrip.setBounds(762, 233, 142, 25);
		contentPane.add(btnBookRoundTrip);
	}
}
