import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Login extends JPanel implements ActionListener{
	private JPasswordField pass;
	private JButton okaybutton = new JButton("OK");
	private JButton cheat = new JButton("Cheat");
	private static boolean systemAccess = false;

	public Login(){
	
		pass = new JPasswordField(10);
		add(pass);
		okaybutton.addActionListener(this);
	     add(okaybutton);
		cheat.addActionListener(this);
		add(cheat);
	}
	public void actionPerformed(ActionEvent e){
		String action = e.getActionCommand();
		
		if(action.equals("OK")){
		char[] input = pass.getPassword();
		String password = new String(input);
		if(isPasswordCorrect(password)){
			setPanel(true);
			}else{
				JOptionPane.showMessageDialog(null, "Incorrect Password");
			}
		}
		
		else if (action.equals("Cheat")){
			setPanel(true);
			Panel.setSystemAccess(systemAccess);
		}
		
	}
	public void setPanel(boolean value){
		if(value){
			Panel.setSystemAccess(systemAccess);
			JPanel temp = Main.getSystemPanel();
			temp.removeAll();
			Panel panel = new Panel();
			temp.add(panel);
			Main.setSystemPanel(temp);
		}
		else
			;
	}
	public boolean isPasswordCorrect(String password){
		String fileName = "POS.txt";
		Scanner inputStream= null;
		//System.out.println("password" + password);
		boolean access=false;
		try{
			inputStream = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e){
			System.out.println("Error opening the file");
		}
		while(inputStream.hasNextLine()){
			String line = inputStream.nextLine();
			if(line.equals(password)){
				access=true;
				systemAccess=false;}
			
			else if (line.startsWith("A")){
				line = line.replaceAll("A ", "").trim();
				if(line.equals(password)){
					access=true;
				    systemAccess= true;}
			}
			else if (line.startsWith("S")){
				line= line.replaceAll("S", "").trim();
				if(line.equals(password)){
					access=true;	
				   systemAccess=false;}
			}
		} 
		inputStream.close();
		return access;
	}
}
