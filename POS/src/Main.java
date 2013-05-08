
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Main extends JFrame {
private static JPanel systemPanel = new JPanel(new FlowLayout());



public Main(){
	getContentPane().add(systemPanel);
	Login login = new Login();
	systemPanel.add(login);
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Main frame = new Main();
	frame.setVisible(true);
	Dimension d = new Dimension(500,400);
	frame.setSize(d);
	}
	

	public static JPanel getSystemPanel() {
		return systemPanel;
	}
	public static void setSystemPanel(JPanel otherPanel) {
		systemPanel = otherPanel;
		refresh(systemPanel);
		
	}
	
public static void refresh(JPanel panel){
	panel.setVisible(false);
	panel.setVisible(true);
}
	
}
