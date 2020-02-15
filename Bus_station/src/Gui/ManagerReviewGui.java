package Gui;


import java.awt.BorderLayout;
import java.io.File;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class ManagerReviewGui extends JFrame {

	private JPanel contentPane;
	int i;
    static Manager m;
    ManagerProfileGui p;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerReviewGui frame = new ManagerReviewGui(m);
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
	public ManagerReviewGui(Manager m) throws FileNotFoundException {
		
		ManagerReviewGui.m=m;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1081, 431);
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
		button.setBounds(12, 13, 99, 49);
		contentPane.add(button);
		
		JLabel label = new JLabel("Trips:");
		label.setBounds(55, 120, 56, 16);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 117, 777, 22);
		contentPane.add(comboBox);
		
		
		ArrayList<internal_trip> internal =	m.getInternal();
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
		
		ArrayList<External_trip>external=	m.getExternal();
		int size1=external.size();
		while(size1-->0)
		{   
			String bus,driver;
		  if(external.get(size1).getBus()==null)bus="null";else bus=String.valueOf(external.get(size1).getBus().getPlatenumber());
		  if(external.get(size1).getBus()==null)
		  {  
		  if(external.get(size1).getD()==null)driver="null";else driver=external.get(size1).getD().getName();
		  comboBox.addItem(external.get(size1));}
		  else if (!external.get(size1).getBus().isfull())
		  {
			  if(external.get(size1).getD()==null)driver="null";else driver=external.get(size1).getD().getName();
			  comboBox.addItem(external.get(size1));}
			   
		  }
		
		
	}

}
