package Gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus_station.Manager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ManagerAddTripGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	static Manager m;
	ManagerProfileGui p;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerAddTripGui frame = new ManagerAddTripGui(m);
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
	public ManagerAddTripGui(Manager m) {
		
		ManagerAddTripGui.m=m;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				ManagerProfileGui.main(null);
			}
		});
		button.setBounds(12, 13, 98, 41);
		contentPane.add(button);
		
		JLabel label = new JLabel("Trip type:");
		label.setBounds(12, 116, 56, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("vehicle type:");
		label_1.setBounds(12, 164, 78, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("source:");
		label_2.setBounds(12, 210, 56, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("destination:");
		label_3.setBounds(12, 261, 78, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("number of stops:");
		label_4.setBounds(12, 309, 98, 16);
		contentPane.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(115, 306, 116, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(94, 258, 161, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(94, 207, 161, 22);
		contentPane.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(122, 161, 363, 22);
		contentPane.add(comboBox);
		
		comboBox.addItem("Bus");
		comboBox.addItem("car");
		comboBox.addItem("Limousine");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(122, 113, 363, 22);
		contentPane.add(comboBox_1);
		
		comboBox_1.addItem("Internal");
		comboBox_1.addItem("external");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(369, 207, 116, 22);
		contentPane.add(textField_4);
		
		JLabel label_6 = new JLabel("price:");
		label_6.setBounds(314, 213, 56, 16);
		contentPane.add(label_6);
		
		JLabel lblDistance = new JLabel("Distance:");
		lblDistance.setBounds(314, 261, 78, 16);
		contentPane.add(lblDistance);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(394, 258, 116, 22);
		contentPane.add(textField_5);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_1.getSelectedIndex()==0)m.add_trip_internal(textField_3.getText(), textField_2.getText(), Float.parseFloat(textField_4.getText()), Float.parseFloat(textField_5.getText()), Integer.parseInt(textField_1.getText()) , null);
				else m.add_trip_external(textField_3.getText(), textField_2.getText(), Float.parseFloat(textField_4.getText()), Float.parseFloat(textField_5.getText()), Integer.parseInt(textField_1.getText()) , null);
				try {
					m.saveonfiles();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				contentPane.setVisible(false);
				dispose();
				p = new ManagerProfileGui(m);
				p.setVisible(true);
			}
		});
		btnAdd.setBounds(388, 40, 97, 25);
		contentPane.add(btnAdd);
		
		
		
		
		

	}
}
