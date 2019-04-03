import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

//Name: Robert Oller
//Title: Homework 4
//Class Name: OvenPanel.java
//Instructor: Mr. Selgrad
//Description: Creates the gui compnents for the button panel and window panel
//Date: 7/7/2018

public class OvenPanel extends JPanel
{
	/**
	 * 
	 */
	private JPanel pnl_Buttons;
	private JPanel pnl_Oven;
	
	private static final long serialVersionUID = 1L;
	private JLabel clockLabel;
	private JRadioButton btnLow;
	private JRadioButton btnHigh;
	
	private JButton btnStart;
	private JButton btnClear;
	
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	private JButton b0;
	
	private Timer timer;
	private int delay = 1000;
	private Timer clock;
	
	int minutesNum = 0;
	int secondsNum = 0;
	String clockString = "--:--";
	private String minutes = "";
	private String seconds = "";
	
	//Constructor for the button panel
	public OvenPanel(GridBagLayout gridBagLayout)
	{	
		this.pnl_Buttons = new JPanel();
		this.pnl_Oven = new JPanel();
		
		this.pnl_Buttons.setLayout(new GridBagLayout());
		GridBagConstraints gridBag = new GridBagConstraints();
		
		//Adds the clock label
		clockLabel = new JLabel("--:--");
		clockLabel.setFont(new Font("--:--", 50, 50));
		clockLabel.setBackground(Color.black);
		clockLabel.setOpaque(true);
		clockLabel.setForeground(Color.green);
		gridBag.fill = GridBagConstraints.CENTER;
		gridBag.gridx = 1;
		gridBag.gridy = 0;
		gridBag.gridwidth = 3;
		gridBag.gridheight = 1;
		this.pnl_Buttons.add(clockLabel, gridBag);
		
		clock = new Timer(50, new ClockListener());
		clock.start();
		
		//Adds the 10 number buttons of a numpad
		b1 = new JButton("1");
		gridBag.gridx = 1;
		gridBag.gridy = 1;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		b1.addActionListener(new NumPadListener());
		this.pnl_Buttons.add(b1, gridBag);
		
		b2 = new JButton("2");
		gridBag.gridx = 2;
		gridBag.gridy = 1;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		b2.addActionListener(new NumPadListener());
		this.pnl_Buttons.add(b2, gridBag);
		
		b3 = new JButton("3");
		gridBag.gridx = 3;
		gridBag.gridy = 1;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		b3.addActionListener(new NumPadListener());
		this.pnl_Buttons.add(b3, gridBag);
		
		b4 = new JButton("4");
		gridBag.gridx = 1;
		gridBag.gridy = 2;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		b4.addActionListener(new NumPadListener());
		this.pnl_Buttons.add(b4, gridBag);
		
		b5 = new JButton("5");
		gridBag.gridx = 2;
		gridBag.gridy = 2;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		b5.addActionListener(new NumPadListener());
		this.pnl_Buttons.add(b5, gridBag);
		
		b6 = new JButton("6");
		gridBag.gridx = 3;
		gridBag.gridy = 2;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		b6.addActionListener(new NumPadListener());
		this.pnl_Buttons.add(b6, gridBag);
		
		b7 = new JButton("7");
		gridBag.gridx = 1;
		gridBag.gridy = 3;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		b7.addActionListener(new NumPadListener());
		this.pnl_Buttons.add(b7, gridBag);
		
		b8 = new JButton("8");
		gridBag.gridx = 2;
		gridBag.gridy = 3;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		b8.addActionListener(new NumPadListener());
		this.pnl_Buttons.add(b8, gridBag);
		
		b9 = new JButton("9");
		gridBag.gridx = 3;
		gridBag.gridy = 3;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		b9.addActionListener(new NumPadListener());
		this.pnl_Buttons.add(b9, gridBag);
		
		b0 = new JButton("0");
		gridBag.gridx = 2;
		gridBag.gridy = 4;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		b0.addActionListener(new NumPadListener());
		this.pnl_Buttons.add(b0, gridBag);

		//Adds the 2 heat settings high and low
		btnLow = new JRadioButton("Low");
		gridBag.gridx = 1;
		gridBag.gridy = 5;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		this.pnl_Buttons.add(btnLow, gridBag);
		
		btnHigh = new JRadioButton("High");
		gridBag.gridx = 3;
		gridBag.gridy = 5;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		this.pnl_Buttons.add(btnHigh, gridBag);
		
		ButtonGroup group = new ButtonGroup();
		group.add(btnLow);
		group.add(btnHigh);
		btnLow.setSelected(true);
		
		//Adds the start button
		btnStart = new JButton("Start");
		gridBag.gridx = 1;
		gridBag.gridy = 6;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		btnStart.addActionListener(new StartListener());
		this.pnl_Buttons.add(btnStart, gridBag);
		
		//Adds the clear button
		btnClear = new JButton("Clear");
		gridBag.gridx = 3;
		gridBag.gridy = 6;
		gridBag.gridwidth = 1;
		gridBag.gridheight = 1;
		btnClear.addActionListener(new ClearListener());
		this.pnl_Buttons.add(btnClear, gridBag);
		
		this.pnl_Oven.setBackground(Color.BLACK);
		this.pnl_Oven.setPreferredSize(new Dimension(1000, 600));
		this.add(this.pnl_Oven);
		
		this.add(this.pnl_Buttons);
		
	}
	//Occurs when a number on the numpad is pressed
	private class NumPadListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			//Stops the clock timer if it's running and sets the clock label
			if(clock.isRunning() || clockLabel.getText() == " ? ? ? ")
			{
				clock.stop();
				clockLabel.setText("--:--");
			}
			clockString = clockLabel.getText();
			
			//Calls the reverseNumber method inputting the pressed number 
			if(event.getSource() == b1)
			{
				reverseNumber("1");
			}
			else if(event.getSource() == b2)
			{
				reverseNumber("2");
			}
			else if(event.getSource() == b3)
			{
				reverseNumber("3");	
			}
			else if(event.getSource() == b4)
			{
				reverseNumber("4");
			}
			else if(event.getSource() == b5)
			{
				reverseNumber("5");
			}
			else if(event.getSource() == b6)
			{
				reverseNumber("6");
				clockLabel.setText(clockString);
			}
			else if(event.getSource() == b7)
			{
				reverseNumber("7");
			}
			else if(event.getSource() == b8)
			{
				reverseNumber("8");
			}
			else if(event.getSource() == b9)
			{
				reverseNumber("9");
			}
			else if(event.getSource() == b0)
			{
				reverseNumber("0");
			}
		}
		
		//Records the inputed numbers in reverse order according to string location
		private void reverseNumber(String num)
		{
			char numChar = num.charAt(0);

			for(int i = clockString.length() - 1; i >= 0; i--)
			{
				if(i == 4 && clockString.charAt(i) == '-')
				{
					clockString = "--:-" + numChar;
					break;
				}
				else if(i == 3 && clockString.charAt(i) == '-')
				{
					clockString = "--:" + clockString.charAt(4) + numChar;
					break;
				}
				else if(i == 1 && clockString.charAt(i) == '-')
				{
					clockString = "-" + clockString.charAt(3) + ":" + clockString.charAt(4) + numChar;
					break;
				}
				else if(i == 0 && clockString.charAt(i) == '-')
				{
					clockString = clockString.charAt(1) + "" + clockString.charAt(3) + ":" + clockString.charAt(4) + numChar;
					break;
				}
			}
			clockLabel.setText(clockString);	
		}
	}
	
	//Occurs when the start button is pressed
	private class StartListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event)
		{	
			setNumbers();
			
			//Creates the 1 second timer and stops any current timers
			if(timer != null)
			{
				if(timer.isRunning())
				{
					timer.stop();
				}
			}
			timer = new Timer(1000, new TimerListener());
			
			//Removes the colon in the middle
			if(minutesNum != 0 && clockString.length() == 5 && clockString != "--:--")
			{
				clockString = clockString.substring(0, 2) + clockString.substring(3);
			}
			else if(minutesNum == 0 && clockString.length() == 5 && clockString != "--:--")
			{
				clockString = clockString.substring(clockString.indexOf(':') + 1);
			}
			else
			{
				clockLabel.setText(" ? ? ? ");
			}
			
			//Deletes leading zeros of the timer
			if(!clockString.equals("00"))
			{
				if(btnLow.isSelected())
				{
					pnl_Oven.setBackground(Color.orange);
				}
				else
				{
					pnl_Oven.setBackground(Color.yellow);
				}
				
				for(int i = 0; i < clockString.length(); i++)
				{
					if(clockString.charAt(0) == '0')
					{
						clockString = clockString.substring(i + 1);
					}
					else
					{
						break;
					}
				}
			}
			
			if(clockLabel.getText().length() == 5 && clockString != "--:--")
			{
				timer.start();
			}
		}
		
		//Creates the numbers for the timer in minutes and seconds
		private void setNumbers()
		{	
			//Makes left over hyphens to zeroes in the clockString
			for(int i = 0; i < clockString.length(); i++)
			{
				if(clockString.charAt(0) == '-')
				{
					clockString = clockString.replace('-', '0');
					clockLabel.setText(clockString);
				}
			}
			
			//Reads the amount of minutes and seconds entered in the numpad from the clockString
			for(int i = 0; i < clockString.length(); i++)
			{
				if(clockString.charAt(i) != '-' && i < 2)
				{
					minutes = clockString.substring(0, i + 1);
					minutesNum = Integer.valueOf(minutes);
				}
				else if(clockString.charAt(i) != '-' && i > 2)
				{
					seconds = clockString.substring(3, i + 1);
					secondsNum = Integer.valueOf(seconds);
				}
			}
		}
	}
	
	private class ClearListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			clock.start();
			clockString = "--:--";
			minutes = "";
			seconds = "";
			pnl_Oven.setBackground(Color.black);
			secondsNum = 0;
			minutesNum = 0;
			delay = 1000;
			
			if(timer != null)
			{
				if(timer.isRunning())
				{
					timer.stop();
				}
			}
		}	
	}
	
	//Occurs when called in the start button action listener
	private class TimerListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{		
			//Series of if statements that change the clock label accordingly
			if(minutesNum > 9 && secondsNum > 10)
			{
				secondsNum--;
				clockLabel.setText(minutesNum + ":" + secondsNum);
				timer.restart();
			}
			else if(minutesNum <= 9 && secondsNum > 10)
			{
				secondsNum--;
				clockLabel.setText("0" + minutesNum + ":" + secondsNum);
				System.out.println(clockLabel.getText().toString() + "<2>");
				timer.restart();
			}
			else if(minutesNum > 9 && secondsNum == 0)
			{
				minutesNum--;
				secondsNum = 59;
				clockLabel.setText(minutesNum + ":" + secondsNum);
				timer.restart();
			}
			else if(minutesNum <= 10 && minutesNum > 0 && secondsNum == 0)
			{
				minutesNum--;
				secondsNum = 59;
				clockLabel.setText("0" + minutesNum + ":" + secondsNum);
				timer.restart();
			}
			else if(minutesNum > 9 && secondsNum <= 10)
			{
				secondsNum--;
				clockLabel.setText(minutesNum + ":" + "0" + secondsNum);
				timer.restart();
			}
			else if(minutesNum <= 10 && minutesNum > 0 && secondsNum <= 10 && secondsNum > 0)
			{
				secondsNum--;
				clockLabel.setText("0" + minutesNum + ":" + "0" + secondsNum);
				timer.restart();
			}
			else if(minutesNum == 0 && secondsNum <= 10 && secondsNum > 0)
			{
				secondsNum--;
				clockLabel.setText("0" + minutesNum + ":" + "0" + secondsNum);
				timer.restart();
			}
			else if(minutesNum == 0 && secondsNum == 0)
			{
				pnl_Oven.setBackground(Color.black);
				
				timer.stop();
				timer = new Timer(700, new TimerListener());
				timer.start();
				
				if(clockLabel.getText() == "00:00")
				{
					clockLabel.setText("         ");
				}
				else
				{
					clockLabel.setText("00:00");
				}
			}
		}
	}
	
	//Occurs when called either at the beginning or when the clear button is pressed
	private class ClockListener implements ActionListener
	{
		//Activates the clock using the system's time
		@Override
		public void actionPerformed(ActionEvent e)
		{
				Calendar cal = Calendar.getInstance();
				
				int hours = cal.get(Calendar.HOUR);
				int minutes = cal.get(Calendar.MINUTE);
				
				//Adjusts the string of the time if a unit is one digit or just 0
				if(hours > 9 && minutes > 9)
				{
					clockLabel.setText(hours + ":" + minutes);
				}
				else if(hours > 9 && minutes < 10)
				{
					clockLabel.setText(hours + ":" + "0" + minutes);
				}
				else if(hours == 0 && minutes > 9)
				{
					clockLabel.setText("12" + ":" + minutes);
				}
				else if(hours == 0 && minutes < 10)
				{
					clockLabel.setText("12" + ":" + "0" + minutes);
				}
				else if(hours < 10 && minutes > 9)
				{
					clockLabel.setText("0" + hours + ":" + minutes);
				}
				else if(hours < 10 && minutes < 10)
				{
					clockLabel.setText("0" + hours + ":" + "0" + minutes);
				}
				clock.restart();
		}
	}
}
