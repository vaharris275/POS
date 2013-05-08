import java.io.*;


public class Item implements Serializable {
private String name;
private double price;

public Item(){
	setName("");
	setPrice(1.50);
}
public Item(String name){
	setName(name);
	setPrice(1.50);
}
public Item(String name, double price){
	this.setName(name);
	this.setPrice(price);
}

public String toString(){
	String item;
	item = "Name: " + name + "\n";
	item += "Price: " + price;
	return item;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
}
