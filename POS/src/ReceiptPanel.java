import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.*;

public class ReceiptPanel extends JPanel {
	private JTextArea receipt = new JTextArea("");
	private  double total=0.0;
	private String listofItems = "";
	private int numofLines = 1;
	private static int count =0;
	private int[] counts = new int[20];
	private int index=0;
	private static String timeStamp;

	public ReceiptPanel(){
	//	checkCount();
		this.setLayout(new GridLayout(0,1));
		this.add(receipt);
		
	}
	public void addItem(String name, double price){
		listofItems = listofItems + "\n" + name + price;
		total += price;
		receipt.setText(listofItems + "\n" + total);
		setNumofLines(getNumofLines() + 1);
		
	}
	public String getListofItems() {
		return listofItems;
	}
	public void setListofItems(String listofItems) {
		this.listofItems = listofItems;
	}
	public int getNumofLines() {
		return numofLines;
	}
	public void setNumofLines(int numofLines) {
		this.numofLines = numofLines;
	}
	public void checkCount(){
		String fileName = "NumofReceipts.txt";
		Scanner inputStream=null;
		try{
			inputStream = new Scanner(new File(fileName));
		}catch(FileNotFoundException e){
			System.out.println("File does not exist");
		}
		while(inputStream.hasNextLine()){
			count++;
			
		}
		
	}
	public void saveReceipt(){
		findTimeStamp();
		String fileName = "Receipt" + timeStamp + ".txt";
		PrintWriter outputStream = null;
		PrintWriter otherOutput = null;
		try{
			outputStream = new PrintWriter(new FileOutputStream (fileName));
			otherOutput = new PrintWriter(new FileOutputStream("NumOfReceipts.txt"));
			
		}catch(FileNotFoundException e){
			System.exit(0);
		}
		outputStream.println(timeStamp + "\n");
		outputStream.println(listofItems);
		outputStream.close();
		otherOutput.println(timeStamp);
		otherOutput.close();
		
	}
	public void newReceipt(){
	receipt.setText("");
	total=0.0;
	listofItems = "";
	numofLines = 1;
	}
	
	public static String getTimeStamp() {
		return timeStamp;
	}
	public static void setTimeStamp(String timeStamp) {
		ReceiptPanel.timeStamp = timeStamp;
	}
	public static void findTimeStamp(){
		java.util.Date date = new java.util.Date();
		Timestamp time = new Timestamp(date.getTime());
		String timest = time.toString();
		timest = timest.replaceAll(" ", ".");
		timeStamp = timest.replaceAll(":", "-");
		
	}
}
