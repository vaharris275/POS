import java.io.*;
import java.util.ArrayList;
public class ArrayListCats implements Serializable{

	/**
	 * @param args
	 */
	
	private ArrayList<Category> list = new ArrayList<Category>();
	
	public ArrayList<Category> getList() {
		return list;
	}
	public void setList(ArrayList<Category> list) {
		this.list = list;
	}
	public void add(Category category){
		list.add(category);
	}
	public void removeCat(Category category){
		list.remove(category);
	}
	public int size(){
		return list.size();
	}
	public Category get(int index){
		return list.get(index);
	}
	
	public static ArrayListCats readFiles(){
		String fileName = "Category.dat";
		ObjectInputStream ips;
			ArrayListCats inputcat = null;
			try{
				ips = new ObjectInputStream(new FileInputStream(fileName));
				 inputcat = (ArrayListCats)ips.readObject();
				 ips.close();
			} catch(IOException e1){
				System.out.println("Error h");
			}
			catch(ClassNotFoundException e2){
				System.out.println("Error i");
			}
			
			return inputcat;

		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
