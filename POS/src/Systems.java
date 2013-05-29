import java.io.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Systems extends JPanel implements ActionListener {
private ArrayListCats arraycats = ArrayListCats.readFiles();
//private JTextArea display = new JTextArea();
private JTextField input = new JTextField("Add a Category");
private JButton select = new JButton("Select");
private JButton receipts = new JButton("Receipts");
private JButton addItem = new JButton("Add Item");
private JButton password = new JButton("Change Password");
private DefaultListModel<String> model = new DefaultListModel<String>();
private JList<String> list = new JList<String>(model);
private JButton backButton = new JButton("Back");

	public Systems(){
		readCategories();
		//add(display);
		addItem.addActionListener(this);
		password.addActionListener(this);
		add(addItem);
		add(password);
		receipts.addActionListener(this);
		add(input);
		input.setVisible(false);
		add(receipts);
		add(list);
		list.setVisible(false);
		backButton.addActionListener(this);
		select.addActionListener(this);
		add(select);
		add(backButton);
	}
	
	public void setAllFalse(){
		addItem.setVisible(false);
		password.setVisible(false);
		receipts.setVisible(false);
		input.setVisible(false);
		list.setVisible(false);
	}
	public void readCategories(){
		for (int i=0; i<arraycats.size(); i++){
			String name = arraycats.get(i).getName();
			model.addElement(name);
		}
	
	}
	public void readItems(int index){
		model.clear();
		Category cat = arraycats.get(index);
		for (int i = 0; i< cat.getSize(); i++){
			String name = cat.findItem(i).getName();
			model.addElement(name);
		}

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
		else if(action.equals("Receipts")){
			setAllFalse();
			list.setVisible(true);
			select.setVisible(true);
			
		}
		else if(action.equals("Add Item")){
			setAllFalse();
			input.setVisible(true);
			}	
		else if(action.equals("Select")){
			int index = list.getSelectedIndex();
			readItems(index);
			list.setVisible(false);
			list.setVisible(true);
		
		}
		
		
		
		
			}

}
