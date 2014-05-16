import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class printtest {
	static ArrayList<String> list;

	public static void main(String[] args) throws IOException {
		
		
	    BufferedReader br = new BufferedReader(new FileReader("TinyLife.txt"));
	    try {
	        list = new ArrayList<String>();
	        String line = br.readLine();

	        while (line != null) {
	            list.add(line);
	            //System.out.println(line);
	            line = br.readLine();
	        }
	     
	    } finally {
	        br.close();
	    }
	    
	 for(String str:list){
		 
		 System.out.println(str);
	 }   
	

	}

}
