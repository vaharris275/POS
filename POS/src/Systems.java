import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Systems extends JPanel implements ActionListener {
private JTextArea display = new JTextArea();
private JTextField input = new JTextField("Add a Category");

private JButton backButton = new JButton("Back");

	public Systems(){
		add(display);
		backButton.addActionListener(this);
		add(backButton);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		if(action.equals("Back")){
			JPanel temp = Main.getSystemPanel();
			temp.removeAll();
			Panel panel = new Panel();
			temp.add(panel);
			Main.setSystemPanel(temp);
		}
		
	}
}
