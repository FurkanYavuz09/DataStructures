package file_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 * This is our FileIO class which reads Inventory file(.txt)
 * with a method readInventory().
 */
public class FileIO {
	//we read each line and decide the array size.
	private String line;
	private int count;
	/*
	 * readInventory() reads Inventory file using 2 while loop.
	 * the first loop decides the size of Inventory array.
	 * The second loop reads each line and assigns Items to Inventory array
	 * with another internal loop
	 */
	public String[][] readInventory(){
		String path = "inventory.txt";
		String[][] items = null;
		count = 0;
		int countRow = 0;
		int countColumn = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while((line=br.readLine()) != null) {
				count++;
			}
			br.close();
			
			items = new String[count][3];
			
			BufferedReader br2 = new BufferedReader(new FileReader(path));
			while ((line = br2.readLine()) != null) {
				countColumn = 0;
				StringTokenizer st = new StringTokenizer(line,",");
				while(st.hasMoreElements()) {
					items[countRow][countColumn++] = st.nextElement().toString();
				}
				countRow++;
			}
			br2.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return items;
	}
}