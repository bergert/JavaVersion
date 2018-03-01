import javax.swing.UIManager;

/**
 * @author Thomas Berger
 * @module Application.java
 *
 * @text   Implements the Application
 *
 *   1.00  01-Mar-2018  first release
 *
 * Copyright (c) 2018 by Thomas Berger. All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or any later
 * version.
 */
public class Application {
	
	/**
	 * This is the main class for the JavaVersion application
	 */
	public Application() {
		
		new Main_AppFrame();
	}

	/**
	 * @param args main entry point
	 */
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}

		new Application();
	}
}