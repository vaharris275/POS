import java.io.*;
import java.util.*;
public class Category implements Serializable{

	/**
	 * @param args
	 */
	private ArrayList<Item> item = new ArrayList<Item>();
	private String name;
	
	public Category(){
		this.name= "name";
	}

	public Category(String name){
		this.name = name;
	}
	public int getSize(){
		int size = item.size();
		return size;
	}
	
	public void addItem(Item product){
		item.add(product);
	}
	public void removeItem(Item product){
		item.remove(product);
	}
	public ArrayList<Item> getItem() {
		return item;
	}
	public Item findItem(int index){
		Item thing = item.get(index);
		return thing;
	}

	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
