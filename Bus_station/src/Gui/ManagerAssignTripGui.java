package Gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus_station.Driver;
import bus_station.External_trip;
import bus_station.Manager;
import bus_station.internal_trip;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ManagerAssignTripGui extends JFrame {

	private JPanel contentPane;
	static Manager m;
	ManagerProfileGui p;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerAssignTripGui frame = new ManagerAssignTripGui(m);
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
	public ManagerAssignTripGui(Manager m) throws FileNotFoundException {
		
		ManagerAssignTripGui.m=m;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				p = new ManagerProfileGui(m);
				p.setVisible(true);
			}
		});
		button.setBounds(12, 13, 98, 51);
		contentPane.add(button);
		
		JLabel lblInternalTrip = new JLabel("internal Trip:");
		lblInternalTrip.setBounds(29, 103, 81, 16);
		contentPane.add(lblInternalTrip);
		
		JLabel label_1 = new JLabel("select driver:");
		label_1.setBounds(29, 274, 81, 16);
		contentPane.add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(140, 271, 348, 22);
		contentPane.add(comboBox);
		
		ArrayList<Driver>drivers = m.getDrivers();
		int size2=drivers.size();
		while(size2-->0) {
			comboBox.addItem(drivers.get(size2));
		}
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setBounds(140, 100, 348, 22);
		contentPane.add(comboBox_1);
		
		
		ArrayList<internal_trip> internal =	m.getInternal();
		int size=internal.size();
		while(size-->0)
		{   
			String bus,driver;
		  if(internal.get(size).getBus()==null)bus="null";else bus=String.valueOf(internal.get(size).getBus().getPlatenumber());
		  if(internal.get(size).getBus()==null)
		  {  
		  if(internal.get(size).getD()==null)driver="null";else driver=internal.get(size).getD().getName();
		  comboBox_1.addItem(internal.get(size));}
		  else if (!internal.get(size).getBus().isfull())
		  {
			  if(internal.get(size).getD()==null)driver="null";else driver=internal.get(size).getD().getName();
			  comboBox_1.addItem(internal.get(size));}
			   
		  }
		
		JButton button_1 = new JButton("Assign");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Driver)comboBox.getSelectedItem()).add_trip((internal_trip)comboBox_1.getSelectedItem());
				((internal_trip)comboBox_1.getSelectedItem()).setD((Driver)comboBox.getSelectedItem());
			}
		});
		button_1.setBounds(515, 99, 97, 25);
		contentPane.add(button_1);
		
		JLabel lblExternalTrip = new JLabel("external Trip:");
		lblExternalTrip.setBounds(29, 158, 81, 16);
		contentPane.add(lblExternalTrip);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("");
		comboBox_2.setBounds(140, 155, 348, 22);
		contentPane.add(comboBox_2);
		
		ArrayList<External_trip> external =	m.getExternal();
		int size1=external.size();
		while(size1-->0)
		{   
			String bus,driver;
		  if(external.get(size1).getBus()==null)bus="null";else bus=String.valueOf(external.get(size1).getBus().getPlatenumber());
		  if(external.get(size1).getBus()==null)
		  {  
		  if(external.get(size1).getD()==null)driver="null";else driver=external.get(size1).getD().getName();
		  comboBox_2.addItem(external.get(size1));}
		  else if (!external.get(size1).getBus().isfull())
		  {
			  if(external.get(size1).getD()==null)driver="null";else driver=external.get(size1).getD().getName();
			  comboBox_1.addItem(external.get(size1));}
			   
		  }
		
		JButton button_2 = new JButton("Assign");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((Driver)comboBox.getSelectedItem()).add_trip((External_trip)comboBox_2.getSelectedItem());
				((External_trip)comboBox_2.getSelectedItem()).setD((Driver)comboBox.getSelectedItem());
			}
		});
		button_2.setBounds(515, 154, 97, 25);
		contentPane.add(button_2);
	}
}
