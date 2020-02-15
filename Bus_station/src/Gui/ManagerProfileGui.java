package Gui;


import bus_station.Manager;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ManagerProfileGui extends JFrame {

	private JPanel contentPane;
	static Manager m;
	ManagerAddTripGui p;
	ManagerReviewGui p1;
	ManagerAssignTripGui p2;
	ManagerRemoveTripGui p3;


    public Manager getM() {
        return m;
    }
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerProfileGui frame = new ManagerProfileGui(m);
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
	public ManagerProfileGui(Manager m) {
		
		ManagerProfileGui.m=m;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 418);
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
				ManagerLoginGui.main(null);
			}
		});
		button.setBounds(12, 13, 97, 48);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Review Trips");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				try {
					p1 = new ManagerReviewGui(m);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				p1.setVisible(true);
			}
		});
		button_1.setBounds(237, 57, 154, 54);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Assign Trip to Driver");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				try {
					p2 = new ManagerAssignTripGui(m);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				p2.setVisible(true);
			}
		});
		button_2.setBounds(237, 124, 154, 48);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Add Trip");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				p = new ManagerAddTripGui(m);
				p.setVisible(true);
				
			}
		});
		button_3.setBounds(237, 185, 154, 48);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("remove trip");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				try {
					p3 = new ManagerRemoveTripGui(m);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				p3.setVisible(true);
			}
		});
		button_4.setBounds(237, 246, 154, 48);
		contentPane.add(button_4);
	}

}
