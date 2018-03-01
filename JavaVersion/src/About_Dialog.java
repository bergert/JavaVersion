import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Thomas Berger
 * @module About_Dialog.java
 *
 * @text   Implements the JavaVersion - about dialog
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
public class About_Dialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JButton jButton1 = new JButton();

	/**
	 * shows the about dialog
	 */
	About_Dialog() {
		
		//Dimension dlgSize = this.getPreferredSize();
		//Dimension frmSize = getSize();
		//Point loc = getLocation();
		//this.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,(frmSize.height - dlgSize.height) / 2 + loc.y);
		setLocation(50,50);
		setSize(560, 310);
		setModal(true);
	    this.getContentPane().setLayout(null);
	    this.setTitle("About JavaVersion "+Main_AppFrame.getVersion());
	    
	    JLabel jLabelc1 = new JLabel();
	    jLabelc1.setBounds(new Rectangle(10, 5, 500, 23));
	    jLabelc1.setText("v1.00 (c) Copyright 2018 by Thomas Berger");
	    this.getContentPane().add(jLabelc1, null);

	    JLabel jLabelc2 = new JLabel();
	    jLabelc2.setBounds(new Rectangle(10, 60, 500, 23));
	    jLabelc2.setText("Displays information about java installed");
	    this.getContentPane().add(jLabelc2, null);

	    jButton1.setBounds(new Rectangle(60, 235, 125, 29));
	    jButton1.setText("OK");
	    jButton1.addActionListener(new Frame2_jButton1_actionAdapter(this));
	    this.getContentPane().add(jButton1, null);
	    setVisible(true); 
	}

	/**
	 * @param e event
	 */
	void jButton1_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}

/**
 * This class implements the ActionListener for all menu items
 */
class Frame2_jButton1_actionAdapter implements java.awt.event.ActionListener {
  private About_Dialog adaptee;

	/**
	 * @param adaptee button event
	*/
	Frame2_jButton1_actionAdapter(About_Dialog adaptee) {
		this.adaptee = adaptee;
	}
	
	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}