import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextArea;

/**
 * @author Thomas Berger
 * @module ShowJavaVersion.java
 *
 * @text   Implements the java information display
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
public class ShowJavaVersion {
	
	public ShowJavaVersion(JTextArea textLogArea) {

		textLogArea.append("active JAVA version="+System.getProperty("java.version")+"\n");
		if (isJava8())
			textLogArea.append("OK: java is version 8\n\n");
		else
			textLogArea.append("ERROR: active java version is not 8\n\n");
			
		textLogArea.append("active java bitness="+getSystemBitness()+"-bit\n");
		if (getSystemBitness() == 64)
			textLogArea.append("OK: java is 64-bit\n\n");
		else
			textLogArea.append("ERROR: active java is not 64-bit\n\n");

		textLogArea.append("active java is running from=\n");
		textLogArea.append(System.getProperty("java.home")+"\n");
		
	}

	private int getSystemBitness() {
        String keys [] = {
                "sun.arch.data.model",
                "com.ibm.vm.bitmode",
                "os.arch",
            };

        	for (int i=0; i<keys.length; i++) {
                String property = System.getProperty(keys[i]);
                if (property != null) {
                   if (property.indexOf("64") >= 0) {
                       return(64);
                   }
                }
            }
            return(32);
	}
	
	private boolean isJava8 () {
		boolean JavaOK = false;
		Pattern patJavaVersion = Pattern.compile("^([0-9])[.]([0-9])[.]([0-9])");
		Matcher matJavaVersion = patJavaVersion.matcher(System.getProperty("java.version"));
		if (matJavaVersion.find()) {
			try {
				if (matJavaVersion.group(2) != null) {
					if (Integer.parseInt(matJavaVersion.group(2)) >= 8)
						JavaOK = true;
				}
			}
			catch (Exception e) {};
		}
		return (JavaOK);
	}

}
