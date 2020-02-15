package Gui;

import java.io.FileNotFoundException;
import java.io.IOException;

import bus_station.Manager;

public class Main {
	static Manager m = new Manager();
	static PersonTypeGui p;

	public static void main(String[] args) throws IOException {
		m.read();
		PersonTypeGui.main(m);
		
		// TODO Auto-generated constructor stub
	}

}
