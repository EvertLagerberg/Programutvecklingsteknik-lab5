
public class MyNode {
	
	public String level;
	public String name;

	
	MyNode(String str){
	  level = getLevel(str);
	  name = getName(str);
		
	}
	private String getLevel(String str){
		String s = str.split(" ")[0].replace("<", "").replace(">", "");
		return s;
	}
	private String getName(String str){
		String[] s = str.split("\"");
		if (s.length>1){
			String name = s[1];
			return name;
		}
		else{
			return null;
		}
	}

}
