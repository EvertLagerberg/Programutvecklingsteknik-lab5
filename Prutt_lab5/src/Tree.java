import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class Tree extends TreeFrame{
	
	static ArrayList<String> list;
	
    void initTree(){
    
		root = new DefaultMutableTreeNode("Liv");
		treeModel = new DefaultTreeModel(root);
		DefaultMutableTreeNode nod = new DefaultMutableTreeNode("VŠxter");
		DefaultMutableTreeNode nod2 = new DefaultMutableTreeNode("Djur");
		DefaultMutableTreeNode nod3 = new DefaultMutableTreeNode("Svampar");
		root.add(nod);
		root.add(nod2);
		root.add(nod3);
		
		
		
		
		tree = new JTree( treeModel );
	}
    
    public static void main(String[] args) {
    	list = new ArrayList<String>();
	    BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("TinyLife.txt"));
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
	    	 System.out.println(str);
	     }
	    
    	new Tree();
        }
}
