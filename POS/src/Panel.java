import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class Panel extends JPanel implements ActionListener {
	private ArrayListCats arraycats = ArrayListCats.readFiles();
    private JButton clearB = new JButton("Clear");
    private JButton checkout = new JButton("Check Out");
    private  ReceiptPanel receipt = new ReceiptPanel();
    private Item choice;
    private JPanel itemPanel = new JPanel();
    private JButton systemB = new JButton("System");
    private JButton logout = new JButton("Log Out");
    private static int activeIndex;
    private static boolean systemAccess = false;
    
    
	public Panel(){
	  initializeCategories();
	   this.add(itemPanel);
	   itemPanel.setBackground(Color.BLUE);
	   clearB.addActionListener(this);
	   checkout.addActionListener(this);
	   add(checkout);
	   logout.addActionListener(this);
	   add(logout);
	   this.add(clearB);
	   this.add(receipt);
	 
	   
	   if(systemAccess){
		   this.add(systemB);
		   systemB.addActionListener(this);
	   }
   }
	
	public static void setSystemAccess(boolean access){
		systemAccess = access;
	}

	public static boolean isSystemAccess() {
		return systemAccess;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		
        if(action.equals("Clear")){
		itemPanel.removeAll();
		itemPanel.setVisible(false);
    	itemPanel.setVisible(true);
    	receipt.newReceipt();
		}
		
        else if (action.equals("System")){
        	JPanel container = Main.getSystemPanel();
        	container.removeAll();
        	Systems system = new Systems();
        	container.add(system);
        	Main.setSystemPanel(container);
        	
        }
        else if(action.equals("Check Out")){
        	if(receipt.getListofItems()!= null){
    		receipt.saveReceipt();
    		receipt.newReceipt();
        	}
    	}
    		
        else if(action.equals("Log Out")){
        	JPanel temp = Main.getSystemPanel();
        	temp.removeAll();
        	Login login = new Login();
        	temp.add(login);
        	Main.setSystemPanel(temp);
        	
        	
        }
        else if(isNumeric(action)){
        	System.out.println(action);
        	activeIndex= Integer.parseInt(action);
        	initializeItem(activeIndex);
        	
        	itemPanel.setVisible(false);
        	itemPanel.setVisible(true);
        	
        }else if (isName(action)){
        		receipt.addItem(choice.getName(), choice.getPrice());
        	}
        }
         
        
	public boolean isName(String input){
		boolean answer = false;
		Category category = arraycats.get(activeIndex);
		ArrayList<Item> item = category.getItem();
		for(int n=0; n<item.size(); n++){
			String name = item.get(n).getName();
			if(input.equals(name)){
				answer = true;
				choice = item.get(n);
			}
		}
        	return answer;
	}
	public void initializeCategories(){
		for (int i=0; i<arraycats.size(); i++){
			String name = arraycats.get(i).getName();
			JButton button = new JButton(name);
			button.setActionCommand(""+i);
			button.addActionListener(this);
			this.add(button);
		}
	
	}
	
	public void initializeItem(int index){
		itemPanel.removeAll();
		ArrayList<Item> item = arraycats.get(index).getItem();
		for(int n=0; n<item.size(); n++){
			String name = item.get(n).getName();
		    JButton button = new JButton(name);
		    button.setActionCommand(name);
		    button.addActionListener(this);
		    button.setVisible(true);
		    itemPanel.add(button);
		}
	}
	
	public boolean isNumeric(String input){
		boolean answer = false;
		try{
		   Integer.parseInt(input);
			answer = true;
		}catch(NumberFormatException nfe){
			answer =false;
		}
		return answer;
	}
}


