package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CalWeather implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton name = new JButton();
	JButton conditions = new JButton();
	JButton minmax = new JButton();
	HashMap<String, WeatherData> weatherdata = Utilities.getWeatherData();

	void start() {
		frame.add(panel);
		panel.add(name);
		name.setText("find the weather conditions by city name");
		name.addActionListener(this);
		panel.add(conditions);
		conditions.setText("Find cities by weather type");
		conditions.addActionListener(this);
		panel.add(minmax);
		minmax.setText("Find cities by minimum and maximum temperatures");
		minmax.addActionListener(this);
		frame.pack();
		frame.setVisible(true);

	}

	public void namerun() {
		String name = JOptionPane.showInputDialog("Enter the name of the city you would like to see the weather of");
		String nameOfCity = Utilities.capitalizeWords(name);
		WeatherData datum = weatherdata.get(nameOfCity);
		if (datum == null) {
			System.out.println("Unable to find weather data for: " + nameOfCity);
		} else {
			System.out.println(
					nameOfCity + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		}

	}

	public void conditionrun() {
		String conditions = JOptionPane.showInputDialog("Enter the weather of the cities you would prefer listed");
		if (conditions == null) {
			System.out.println("Unable to find cities with weather type:" + conditions);
		} else if (conditions.equalsIgnoreCase("Overcast")) {
			String list = "";
			for (String key : weatherdata.keySet()) {
				if (weatherdata.get(key).weatherSummary.equalsIgnoreCase(conditions)) {
					list += key + ", ";
				}
			}
			System.out.println("These are the cities I found with weather type: " + conditions + " : " + list);
		} else if (conditions.equalsIgnoreCase("mostly cloudy")) {
			String list = "";
			for (String key : weatherdata.keySet()) {
				if (weatherdata.get(key).weatherSummary.equalsIgnoreCase(conditions)) {
					list += key + ", ";
				}
			}
			System.out.println("These are the cities I found with weather type: " + conditions + " : " + list);
		} else if (conditions.equalsIgnoreCase("cloudy")) {
			String list = "";
			for (String key : weatherdata.keySet()) {
				if (weatherdata.get(key).weatherSummary.equalsIgnoreCase(conditions)) {
					list += key + ", ";
				}
			}
			System.out.println("These are the cities I found with weather type: " + conditions + " : " + list);
		} else if (conditions.equalsIgnoreCase("clear")) {
			String list = "";
			for (String key : weatherdata.keySet()) {
				if (weatherdata.get(key).weatherSummary.equalsIgnoreCase(conditions)) {
					list += key + ", ";
				}
			}
			System.out.println("These are the cities I found with weather type: " + conditions + " : " + list);
		}
	}

	public void minmaxrun() {
		String min = JOptionPane.showInputDialog("Enter the minimum temperature for the cities");
		int minAsInt = Integer.parseInt(min);
		String max = JOptionPane.showInputDialog("Enter the maximum temperature for the cities");
		int maxAsInt = Integer.parseInt(max);
		String list = "";
		for (String i : weatherdata.keySet()) {
			if (weatherdata.get(i).temperatureF >= minAsInt && weatherdata.get(i).temperatureF <= maxAsInt) {
				list += i + ", ";
			}
		}
		System.out.println("These are the cities I found with the temperatures given: " + list);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton pressedbutton = (JButton) e.getSource();
		if (pressedbutton == name) {
			namerun();
		} else if (pressedbutton == conditions) {
			conditionrun();
		} else if (pressedbutton == minmax) {
			minmaxrun();
		}
	}
}
