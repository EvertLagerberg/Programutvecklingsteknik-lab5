
public class MyNode {
	
	public String level;

	
	MyNode(String str){
	  level = getLevel(str);
		
	}
	private String getLevel(String str){
		String s = str.split(" ")[0].replace("<", "").replace(">", "");
		return s;
	}

}
