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
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DriverProfileGui extends JFrame {

	private JPanel contentPane;
	static Manager m;
	static Driver d;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverProfileGui frame = new DriverProfileGui(m,d);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DriverProfileGui(Manager m,Driver d) {
		
		DriverProfileGui.m=m;
		DriverProfileGui.d=d;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					m.saveonfiles();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				contentPane.setVisible(false);
				dispose();
				DriverLoginGui.main(null);
			}
		});
		button.setBounds(12, 13, 100, 53);
		contentPane.add(button);
		
		JLabel label = new JLabel("Assigned Trips:");
		label.setBounds(56, 113, 100, 16);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(169, 110, 327, 22);
		contentPane.add(comboBox);
		
		ArrayList<internal_trip>internal=	d.getInternal();
		int size=internal.size();
		while(size-->0)
		{   String bus,driver;
		  if(internal.get(size).getBus()==null)bus="null";else bus=String.valueOf(internal.get(size).getBus().getPlatenumber());
		  if(internal.get(size).getD()==null)driver="null";else driver=internal.get(size).getD().getName();
		  comboBox.addItem(internal.get(size));
		}
		
		ArrayList<External_trip>external=	d.getExternal();
		int size1=external.size();
		while(size1-->0)
		{   String bus,driver;
		  if(external.get(size1).getBus()==null)bus="null";else bus=String.valueOf(external.get(size1).getBus().getPlatenumber());
		  if(external.get(size1).getD()==null)driver="null";else driver=external.get(size1).getD().getName();
		  comboBox.addItem(external.get(size1));
		}
		
	}

}
