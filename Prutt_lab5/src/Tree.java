import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class Tree extends TreeFrame{
	
	static ArrayList<String> list;
	static ArrayList<MyNode> noder;
	static ArrayList<MyNode> inside;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode gren;
	static int position=0;
	static int i=0;
	
    void initTree(){
    	root = new DefaultMutableTreeNode(noder.get(0).level);
    	String startLevel = noder.get(0).level;
    	String endLevel = "";
    	while(! endLevel.equals("/"+startLevel)){
    		position++;
    		if(noder.get(position).level.startsWith("/")){
    			System.out.println("----");
    			endLevel = noder.get(position).level;
    		}
    		else{
    			endLevel = noder.get(position).level;	
    			addChild(noder.get(position),root);
    		}
    	}
		treeModel = new DefaultTreeModel(root);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tree = new JTree( treeModel );
	}
    
    public void addChild(MyNode nod,DefaultMutableTreeNode parent){
    		DefaultMutableTreeNode child = new DefaultMutableTreeNode(nod.level);
			parent.add(child);
			System.out.println(nod.level);
    		if(ifDic(nod)){
    			String startLevel =nod.level;
    			String endLevel = "";
    			while(! endLevel.equals("/"+startLevel)){
    	    		position++;
    	    		if(noder.get(position).level.startsWith("/")){
    	    			System.out.println("----");
    	    			endLevel = noder.get(position).level;
    	    		}
    	    		else{
    	    			endLevel = noder.get(position).level;	
    	    			addChild(noder.get(position),child);
    	    		}
    	    	}
    		}
    	}
    	  
    
    public boolean ifDic(MyNode nod){
        	return (! ("/"+nod.level).equals(noder.get(position+1).level) && ! nod.level.startsWith("/"));
  }
    
    
    public ArrayList<MyNode> getInside(){
    	inside = new ArrayList<MyNode>();
    	int i = position;
    	String level = "";
    	while (! level.equals("/"+noder.get(position).level)){
    		level = noder.get(i+1).level;
    		inside.add(noder.get(i));
    		i++;	
    	}
		return inside;
    }
    
    public static void main(String[] args) {
    	list = new ArrayList<String>();
    	noder = new ArrayList<MyNode>();
    	BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("Liv.txt"));
		     String line = br.readLine();
		    
		     while (line != null) {
		            list.add(line);
		            //System.out.println(line);
		            line = br.readLine();
		        }
		     br.close();
		    
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String str:list){
			noder.add(new MyNode(str));
		}
    	new Tree();
        }
}
