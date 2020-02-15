package Gui;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.swing.internal.plaf.metal.resources.metal;

import bus_station.Manager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import bus_station.Manager;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PersonTypeGui {




    static Manager m;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	public static void main(Manager m) throws IOException {
            PersonTypeGui.m = m;
		


	 // m.saveonfiles();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonTypeGui window = new PersonTypeGui(m);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public PersonTypeGui(Manager m) throws FileNotFoundException {
        /*this.m = new Manager();
        this.m = new Manager();*/
		PersonTypeGui.m=m;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 697, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPassenger = new JButton("Passenger");
		btnPassenger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				PassengerLoginGui plg = new PassengerLoginGui(m);
				plg.setVisible(true);
			}
		});
		btnPassenger.setBounds(250, 71, 97, 47);
		frame.getContentPane().add(btnPassenger);
		
		JButton btnDriver = new JButton("Driver");
		btnDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DriverLoginGui dlg = new DriverLoginGui(m);
				dlg.setVisible(true);
			}
		});
		btnDriver.setBounds(250, 157, 97, 47);
		frame.getContentPane().add(btnDriver);
		
		JButton btnManager = new JButton("Manager");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ManagerLoginGui mlg = new ManagerLoginGui(m);
				mlg.setVisible(true);
			}
		});
		btnManager.setBounds(250, 234, 97, 40);
		frame.getContentPane().add(btnManager);
	}

}
