package Gui;


import java.awt.BorderLayout;
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
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ManagerRemoveTripGui extends JFrame {

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
					ManagerRemoveTripGui frame = new ManagerRemoveTripGui(m);
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
	public ManagerRemoveTripGui(Manager m) throws FileNotFoundException {
		
		ManagerRemoveTripGui.m=m;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 370);
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
		button.setBounds(12, 13, 97, 41);
		contentPane.add(button);
		
		JLabel lblInternalTrip = new JLabel("internal Trip:");
		lblInternalTrip.setBounds(37, 122, 86, 16);
		contentPane.add(lblInternalTrip);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(135, 119, 571, 22);
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
		
		
		JButton button_1 = new JButton("Remove");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				m.remove_trip((internal_trip)comboBox.getSelectedItem());
				contentPane.setVisible(false);
				dispose();
				p = new ManagerProfileGui(m);
				p.setVisible(true);
			}
		});
		button_1.setBounds(757, 118, 97, 25);
		contentPane.add(button_1);
		
		JLabel lblExternalTrip = new JLabel("external Trip:");
		lblExternalTrip.setBounds(37, 169, 86, 16);
		contentPane.add(lblExternalTrip);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(135, 166, 571, 22);
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
		  
		  
		  JButton button_2 = new JButton("Remove");
		  button_2.setBounds(757, 165, 97, 25);
		  contentPane.add(button_2);
		  
		  button_2.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent arg0) {
				  m.remove_trip((External_trip)comboBox_1.getSelectedItem());
				  contentPane.setVisible(false);
				  dispose();
				  p = new ManagerProfileGui(m);
				  p.setVisible(true);
			  }
		  });
			   
		  }
	}

}
