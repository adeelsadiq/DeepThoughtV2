package deepThoughtV2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//this class is for drawing out the actual GUI component of the program
//https://www.geeksforgeeks.org/java-swing-jtextarea/ used this site for help with understanding the GUI 

public class DisplyWindow extends Message implements ActionListener {
	String name;

	JFrame frame = new JFrame("Deep Thought");
	JMenuBar menuBar = new JMenuBar();
	JMenu file = new JMenu("FILE");
	JMenuItem history = new JMenuItem("History");
	JMenuItem help = new JMenuItem("Help");
	
	JPanel panel = new JPanel(); 
	JLabel label = new JLabel("Ask your pesky questions!");
	JLabel topLabel = new JLabel("Ask DeepThought");
	JTextField myTextField = new JTextField(30); // accepts up to 30 characters
	JButton send = new JButton("Send");
	JButton reset = new JButton("Reset");

	// Text Area at the Centre
	JTextArea myTextArea = new JTextArea("Ask DeepThought anything!         \n");

	public DisplyWindow() {
		// Creating the Frame
		myTextArea.setEditable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		menuBar.add(file);
		this.name = JOptionPane.showInputDialog("What is your name buddy?");
		file.add(history);
		file.add(help);

		send.addActionListener(this);
		reset.addActionListener(this);
		history.addActionListener(this);
		help.addActionListener(this);

		panel.add(label); // Components Added using Flow Layout
		panel.add(myTextField);
		panel.add(send);
		panel.add(reset);
		panel.setBackground(Color.orange);
		myTextField.setBackground(Color.white);
		myTextArea.setBackground(Color.orange);
		JScrollPane scroll = new JScrollPane(myTextArea); // adding a scroll bar if the text area goes out of screen
		// Adding Components to the frame.
//		frame.getContentPane().add(BorderLayout.NORTH, topLabel);
		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		frame.getContentPane().add(BorderLayout.NORTH, menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, scroll);

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent click) {
		
		MessageWriter writer = new MessageWriter(); // the MessageWriter instance is created
		
		String actionPerformed = click.getActionCommand(); // creating the string instance to hold the action command
		//creating a string to hold the final text that is to be written to file and text area
		String textToAppend = name + " asks: " + mainMessage + "\nDeepThought says: " + writer.getAnswer() + "\n";
		
		switch (actionPerformed) {
		case "Reset":

			writer.erase(); // erasing the file if reset was pushed
			myTextArea.setText(""); // erases the text area
			break;
		case "Send": { // Verifying which button was pushed
			if (myTextField.getText().isEmpty()) { // check if the text field is blank when the "ask" button is pressed.
				myTextArea
						.append("Ask a question will you " + name + ", or do you want me to guess the question too?\n");
			} else {

				setMainMessage(myTextField.getText());

				//appending Q&A to text area
				myTextArea.append(textToAppend); 

				@SuppressWarnings("unused") 
				//writing Q&A to file + console
				MessageWriter writer1 = new MessageWriter(textToAppend); 

			}
		}
			break;
		case "History":
			// Verifying which button was pushed

			Message reader1 = new Message();
			MessageReader reader = new MessageReader(); //here we are invoking the parent class to instantiate the child instance 
			myTextArea.append(reader.read()); // reading from the text file and appending it to the text area the overloaded child function
			System.out.println(reader1.read());  //reading from the ArrayList and writing to console
//			myTextArea.append(reader.read()); //reading from the text file and appending it to the text area
			break;
		case "Help":
			// Verifying which button was pushed
 
			myTextArea.append("\n lol no help here :D \n"); // reading from the text file and appending it to the text area the overloaded child function
			
			default:
			break;
		}
	}
}
//tuesday at 4 