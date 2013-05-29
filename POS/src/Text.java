import java.io.*;
import java.util.*;
public class Text {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Category soda = new Category("Soda");
		Item coke = new Item("Coke");
		Item rootBeer = new Item("Root Beer");
		Item sprite = new Item ("Sprite");
		soda.addItem(coke);
		soda.addItem(rootBeer);
		soda.addItem(sprite);
		
		Category diet = new Category("Diet Soda");
		Item dietCoke = new Item("Diet Coke");
		Item dietSprite = new Item("Diet Sprite");
		diet.addItem(dietSprite);
		diet.addItem(dietCoke);
		
		Category juice = new Category("Juice");
		Item orange = new Item("Orange");
		Item apple = new Item("Apple");
		juice.addItem(orange);
		juice.addItem(apple);
		
		Category water = new Category("Water");
		Item plain = new Item("Plain Water");
		Item sparkling = new Item("Sparkling Water");
		water.addItem(plain);
		water.addItem(sparkling);
		
		ArrayList<Category> category = new ArrayList<Category>();
		category.add(soda);
		category.add(diet);
		category.add(juice);
		category.add(water);
		
		ArrayListCats cats = new ArrayListCats();
		cats.setList(category);
		
		
		String fileName = "Category.dat";
	ObjectOutputStream ops;
	try{
		ops = new ObjectOutputStream(new FileOutputStream(fileName));
		ops.writeObject(cats);
	} catch(IOException e1){
		System.out.println("Error");
	}

		
		
		ObjectInputStream ips;
		
		ArrayListCats inputcat = null;
	try{
			ips = new ObjectInputStream(new FileInputStream(fileName));
			 inputcat = (ArrayListCats)ips.readObject();
			for (int i=0; i< inputcat.size(); i++){
				Category newca = null;
				newca= inputcat.get(i);
				System.out.println(newca);
			}
		
			
		} catch(IOException e1){
			System.out.println("Error");
		}
		catch(ClassNotFoundException e2){
			System.out.println("Error");
		}
	
		
		
		System.out.println(ArrayListCats.readFiles());
	}

}
