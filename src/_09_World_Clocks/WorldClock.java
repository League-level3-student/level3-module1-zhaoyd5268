package _09_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class WorldClock implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextArea text = new JTextArea();

	ClockUtilities util = new ClockUtilities();
	TimeZone zone;
	Timer timer;

	String city;
	String time;
	String date;

	public WorldClock() {
		city = JOptionPane.showInputDialog("Please enter a city by typing in a state, then a comma space, then a country in that state. "
				+ "REMEMBER TO CAPITALIZE THE FIRST LETTER OF ALL STATES AND CITIES");
		zone = util.getTimeZoneFromCityName(city);
		
		Calendar cal = Calendar.getInstance(zone);
		String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		String day = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
		 date = day + " " + month + " " + cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.YEAR);
		 
		 System.out.println(date);
		 
		 frame.add(panel);
		 panel.add(text);
		 text.setText(city + "\n" + date);
		 frame.setVisible(true);
		 frame.pack();
		 
		 timer = new Timer(1000, this);
		 timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		  Calendar cal = Calendar.getInstance(zone);
	        String militaryTime = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
	        String twelveHourTime = " [" + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND) + "]";
	        time = militaryTime + twelveHourTime;
	        text.setText(city + "\n" + date + "\n" + time);
	        frame.pack();
	}

}
