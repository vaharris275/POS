import java.awt.*;
import javax.swing.*;

public class Buttons {
	private static JButton button;
	
	public Buttons(String buttontxt, String action){
		button = new JButton("buttontxt");
		button.setActionCommand(action);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Category category = new Category("cheese");
		Item book = new Item("book");
		Item car = new Item("car");
		category.addItem(car);
		category.addItem(book);
		System.out.println(category.getItem());
		category.removeItem(car);
		System.out.println(category.getItem());
		

	}
}
