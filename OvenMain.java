import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

//Name: Robert Oller
//Title: Homework 4
//Class Name: OvenMain.java
//Instructor: Mr. Selgrad
//Description: Creates the gui frame and the two panel objects in the OvenPanel class
//Date: 7/7/2018

public class OvenMain
{			
	boolean on = false;
	static int count = 0;
	
	public static void main(String[] args)
	{	
		JFrame frame = new JFrame("Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		OvenPanel btnPanel = new OvenPanel(new GridBagLayout());
		frame.getContentPane().add(btnPanel);
		
		frame.pack();
		frame.setVisible(true);
	}
}
