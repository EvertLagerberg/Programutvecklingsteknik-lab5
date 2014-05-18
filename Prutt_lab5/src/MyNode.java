import javax.swing.tree.DefaultMutableTreeNode;


public class MyNode extends DefaultMutableTreeNode{
	
	public String level;
	public String name;
	public String info;


	
	MyNode(String str){
	  level = SetLevel(str);
	  name = SetName(str);
	  info = SetInfo(str);
		
	}
	public String SetLevel(String str){
		String s = str.split(" ")[0].replace("<", "").replace(">", "");
		return s;
	}
	public String SetName(String str){
		String[] s = str.split("\"");
		if (s.length>1){
			String name = s[1];
			return name;
		}
		else{
			return null;
		}
	}
	
	public String SetInfo(String str){
		String[] s = str.split(">");
		if (s.length>1){
		return s[1];
		}
		
		
		return null;
	}
	
	public String toString(){
		return name;
	}

}
