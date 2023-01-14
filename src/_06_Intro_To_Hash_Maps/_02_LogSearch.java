package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	HashMap <Integer, String> stuff = new HashMap <Integer, String> ();

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
    JButton AddEntry = new JButton();
	JButton IDSearch = new JButton();
	JButton ListView = new JButton();
	public void start() {
		frame.add(panel);
		panel.add(AddEntry);
		panel.add(IDSearch);
		panel.add(ListView);
		AddEntry.setText("Add Entry");
		IDSearch.setText("Search by ID");
		ListView.setText("View List");
		AddEntry.addActionListener(this);
		IDSearch.addActionListener(this);
		ListView.addActionListener(this);
		frame.setVisible(true);
	
	}


	
	public static void main(String[] args) {
		_02_LogSearch log = new _02_LogSearch();
		log.start();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.equals(AddEntry)) {
			String IDnum = JOptionPane.showInputDialog("Please enter an ID number");
			Integer IDasInt = Integer.parseInt(IDnum);
			String name = JOptionPane.showInputDialog("Please enter a name");
			stuff.put(IDasInt, name);
		}
		if (button.equals(IDSearch)) {
			String IDnum = JOptionPane.showInputDialog("Please enter an ID number");
			Integer IDasInt = Integer.parseInt(IDnum);
			if (stuff.containsKey(IDasInt)) {
				JOptionPane.showMessageDialog(null, "The name is " + stuff.get(IDasInt));
			} else {
				JOptionPane.showMessageDialog(null, "That name does not exist. Please check for typos or enter a different ID");
			}

		}
		
		if (button.equals(ListView)) {
		for(Integer i : stuff.keySet()) {
			JOptionPane.showMessageDialog(null, "ID:  " + i + "  Name:  " + stuff.get(i) );
		}
		
			
		}
	}
	
	
	
	/*		
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons.
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list.
     */

}
