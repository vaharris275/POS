import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.*;

public class ItemPanel extends JPanel implements ActionListener {
private ArrayListCats arraycats = ArrayListCats.readFiles();

private  ReceiptPanel receipt = new ReceiptPanel();
private JPanel sodaPanel = new JPanel();

private JButton checkout = new JButton("Check Out");

public ItemPanel(){
	this.setLayout(new FlowLayout());
	this.add(sodaPanel);
	this.add(receipt);
	checkout.addActionListener(this);
	this.add(checkout);
}



public void clearButtons(){
	sodaPanel.removeAll();

	
}


public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	String action= e.getActionCommand();
	

	 if(action.equals("Check Out")){
		receipt.saveReceipt();
		receipt.newReceipt();
	}
		
}

public void initializeItems(){
	for (int i=0; i<arraycats.size(); i++){
		ArrayList<Item> item = arraycats.get(i).getItem();
		for(int n=0; n<item.size(); n++){
			String name = item.get(n).getName();
		    JButton button = new JButton(name);
		    button.setActionCommand(name);
		    button.addActionListener(this);
		    this.add(button);
		    button.setVisible(false);
		   
		}
	}

}


public JPanel getSodaPanel() {
	return sodaPanel;
}



public void setSodaPanel(JPanel sodaPanel) {
	this.sodaPanel = sodaPanel;
	sodaPanel.setVisible(false);
	sodaPanel.setVisible(true);
}



public void initializeItem(int index){
		ArrayList<Item> item = arraycats.get(index).getItem();
		for(int n=0; n<item.size(); n++){
			String name = item.get(n).getName();
		    JButton button = new JButton(name);
		    button.setActionCommand(name);
		    button.setVisible(true);
		    sodaPanel.add(button);
		    
		   
		}
	}

}
