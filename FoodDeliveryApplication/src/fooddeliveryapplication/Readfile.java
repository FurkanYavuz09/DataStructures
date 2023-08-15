package fooddeliveryapplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Readfile {
	//we read each line and decide the array size.
		private String line;
		private int count;
		private String[][] fileArray;
		
		
		public Readfile() {
			this.fileArray=this.read();
		}
		
		public String[][] getFileArray() {
			return fileArray;
		}
		
		public String[][] read(){
			String path = "CENG112_HW4.csv";
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
				
				items = new String[count-1][7];
				
				BufferedReader br2 = new BufferedReader(new FileReader(path));
				br2.readLine();
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
