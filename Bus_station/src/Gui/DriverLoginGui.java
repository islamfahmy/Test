package Gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus_station.Customer;
import bus_station.Driver;
import bus_station.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DriverLoginGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	static Manager m;
	DriverProfileGui p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverLoginGui frame = new DriverLoginGui(m);
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
	public DriverLoginGui(Manager m) {
		
		DriverLoginGui.m=m;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(171, 173, 71, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(171, 241, 71, 16);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(254, 170, 227, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(254, 238, 227, 22);
		contentPane.add(passwordField);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				try {
					PersonTypeGui.main(m);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBack.setBounds(12, 13, 97, 40);
		contentPane.add(btnBack);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Driver d=null;
				//if(c==null)
				
					String username = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				d = m.authenication_d(username, password);
				if(d==null)
				    JOptionPane.showMessageDialog(null, "wrong username or password");
				else{
					contentPane.setVisible(false);
					dispose();
					p = new DriverProfileGui(m,d);
					p.setVisible(true);
				}
			}
		});
		btnLogin.setBounds(171, 307, 97, 25);
		contentPane.add(btnLogin);
	}

}
