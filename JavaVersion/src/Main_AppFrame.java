import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 * @author Thomas Berger
 * @module Main_AppFrame.java
 *
 * @text   Implements the app frame
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
public class Main_AppFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel jPanel3 = new JPanel();
	private JScrollPane jScrollPane3;
	
	private static String Version = "1.00";

	private JMenuBar jMenuBar1 = new JMenuBar();
	
	private JMenu jMenu_File   = new JMenu();
	private JMenu jMenu_Help   = new JMenu();
	
	private JTextArea textLogArea;
	
	private JMenuItem menuItem_quit = new JMenuItem();
	private JMenuItem menuItem_about = new JMenuItem();

	
	private CardLayout cardLayout1 = new CardLayout();
	private GridBagLayout gridBagLayout1 = new GridBagLayout();

	/**
	 * creator for the main application frame
	 */
	public Main_AppFrame() {
		
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		
		this.setTitle("JavaVersion "+getVersion());
		
		this.setSize(800, 600);
		this.setLocation(20, 20);
	
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(cardLayout1);
		this.setLocale(java.util.Locale.getDefault());
		this.setJMenuBar(jMenuBar1);
		
		// ----------------------------------------------------------------------------------------------------------------
		jMenu_File.setText("File");

		menuItem_quit.setText("Quit");
		menuItem_quit.addActionListener(this);
		menuItem_quit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.Event.CTRL_MASK));
		jMenu_File.add(menuItem_quit);
		
		jMenuBar1.add(jMenu_File);

		// ----------------------------------------------------------------------------------------------------------------
		jMenu_Help.setText("Help");
		
		menuItem_about.setText("About");
		menuItem_about.addActionListener(this);
		jMenu_Help.add(menuItem_about);
		jMenuBar1.add(jMenu_Help);
		// ----------------------------------------------------------------------------------------------------------------

		textLogArea = new JTextArea();
		textLogArea.setEditable(false);
		((DefaultCaret)textLogArea.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		jScrollPane3 = new JScrollPane(textLogArea);
		jPanel3.setLayout(gridBagLayout1);
		contentPane.add(jPanel3, BorderLayout.SOUTH);
		jPanel3.add(
			jScrollPane3,
			new GridBagConstraints(
				0,
				0,
				1,
				1,
				1.0,
				1.0,
				GridBagConstraints.CENTER,
				GridBagConstraints.BOTH,
				new Insets(8, 0, 11, 9),
				-68,
				-110));

		
		new ShowJavaVersion(textLogArea);
		
		this.validate();
		this.setVisible(true);
	}
	
	//Overridden so we can exit when window is closed
	protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}

	/**
	 * call action routines to implement menu functions
	 * @param e event
	 */
	public void actionPerformed (ActionEvent e) {
	    if ("Quit".equals(e.getActionCommand())) {
			WindowEvent e1 = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
			getToolkit().getSystemEventQueue().postEvent(e1);
		}
	    
	    if ("About".equals(e.getActionCommand()))
			new About_Dialog();
	}
	
	/**
	 * @return the version (version cannot bet set)
	 */
	public static String getVersion() {
		return Version;
	}
}

/* end of Frame1.java */
