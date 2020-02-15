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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PassengerBookedTripsGui extends JFrame {

	private JPanel contentPane;
    static Manager m;
    static Customer c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassengerBookedTripsGui frame = new PassengerBookedTripsGui(m,c);
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
	public PassengerBookedTripsGui(Manager m,Customer c) {
		
		PassengerBookedTripsGui.m=m;
		PassengerBookedTripsGui.c=c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				PassengerProfileGui.main(null);
			}
		});
		button.setBounds(12, 13, 100, 52);
		contentPane.add(button);
		
		JLabel lblInternalTrips = new JLabel("internal Trips:");
		lblInternalTrips.setBounds(12, 145, 108, 16);
		contentPane.add(lblInternalTrips);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(115, 142, 348, 22);
		contentPane.add(comboBox);
		
		ArrayList<internal_trip>internal=	c.getInternal();
		int size=internal.size();
		while(size-->0)
		{   String bus,driver;
		  if(internal.get(size).getBus()==null)bus="null";else bus=String.valueOf(internal.get(size).getBus().getPlatenumber());
		  if(internal.get(size).getD()==null)driver="null";else driver=internal.get(size).getD().getName();
		  comboBox.addItem(internal.get(size));
		}
		
		JButton button_1 = new JButton("cancel Reservation");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.deletetrip((internal_trip)comboBox.getSelectedItem());
				comboBox.removeItem((internal_trip)comboBox.getSelectedItem());
			}
		});
		button_1.setBounds(492, 141, 156, 25);
		contentPane.add(button_1);
		
		JLabel lblExternalTrips = new JLabel("external Trips:");
		lblExternalTrips.setBounds(12, 184, 100, 16);
		contentPane.add(lblExternalTrips);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(115, 181, 348, 22);
		contentPane.add(comboBox_1);
		
		ArrayList<External_trip>external=	c.getExternal();
		int size1=external.size();
		while(size1-->0)
		{   String bus,driver;
		  if(external.get(size1).getBus()==null)bus="null";else bus=String.valueOf(external.get(size1).getBus().getPlatenumber());
		  if(external.get(size1).getD()==null)driver="null";else driver=external.get(size1).getD().getName();
		  comboBox_1.addItem(external.get(size1));
		}
		
		JButton btnNewButton = new JButton("cancel reservation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.deletetrip((External_trip)comboBox_1.getSelectedItem());
				comboBox_1.removeItem((External_trip)comboBox_1.getSelectedItem());
			}
		});
		btnNewButton.setBounds(492, 180, 156, 25);
		contentPane.add(btnNewButton);
	}

}
