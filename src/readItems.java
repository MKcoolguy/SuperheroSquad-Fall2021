import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class readItems {

	public static void main(String[] args) throws FileNotFoundException
	
	{
		
		Scanner reader = new Scanner(new File("src//group-item.txt"));
		
		while(reader.hasNext()) {
			
			String singleItem = reader.nextLine();
			String[] itemsArray = singleItem.split("-");
			int itemRoom = Integer.parseInt(itemsArray[0]);
			String itemName = itemsArray[1];
			String itemDes = itemsArray[2];
			String itemType =  itemsArray[3];
			String itemPower = itemsArray[4];
			//coommmennntt
			
			
		
		
		
		
		

	}

}
}
