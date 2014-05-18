import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class Tree extends TreeFrame {

	static ArrayList<String> list;
	static ArrayList<MyNode> noder;
	MyNode root;

	static int position = 0;
	static int i = 0;
	static String infil = null;

	void initTree() {
		root = noder.get(0);
		String startLevel = root.level;
		String endLevel = "";
		while (!endLevel.equals("/" + startLevel)) {
			position++;
			endLevel = noder.get(position).level;
			if (!noder.get(position).level.startsWith("/")) {
				addChild(noder.get(position), root);
			}
		}
		treeModel = new DefaultTreeModel(root);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tree = new JTree(treeModel);
	}

	public void addChild(MyNode child, MyNode parent) {
		parent.add(child);
		child.setParent(parent);
		if (ifDic(child)) {
			String startLevel = child.level;
			String endLevel = "";
			while (!endLevel.equals("/" + startLevel)) {
				position++;
				endLevel = noder.get(position).level;
				if (!noder.get(position).level.startsWith("/")) {
					addChild(noder.get(position), child);
				}
			}
		}
	}

	public boolean ifDic(MyNode nod) {
		return (!("/" + nod.level).equals(noder.get(position + 1).level) && !nod.level
				.startsWith("/"));
	}


    void showDetails(TreePath path){
    String info ="";
	if (path == null){
	    return;
	} else {
		System.out.println(path);
	}
	String pathname = path.getLastPathComponent().toString();
	System.out.println("path: " + pathname);
	for (MyNode nod: noder){

		if(nod.name != null){
		if (nod.name.equals(pathname)){
			System.out.println(nod.name + "Parent" + nod.getParent());
			info += nod.level+": ";
			info += nod.name;
			info += nod.info;
			info += "\n";
			info += "men allt som är " + nod.name;
			while(nod.getParent()!=null){
				info += " är " + nod.getParent();
				nod = (MyNode) nod.getParent();
			}

		}		
	}
	}
	JOptionPane.showMessageDialog(this, info);
    }



	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			infil = "Liv.xml";
		} else {
			infil = args[0];
		}
		list = new ArrayList<String>();
		noder = new ArrayList<MyNode>();
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(
				new FileInputStream(infil), "UTF-8"));

		// Vid XML-fil, l�s bort XML taggen
		if (infil.split("\\.")[1].equals("xml")) {
			br.readLine();
		}
		String line = br.readLine();
		while (line != null) {
			list.add(line);
			// System.out.println(line);
			line = br.readLine();
		}
		br.close();

		for (String str : list) {
			noder.add(new MyNode(str));
		}
		new Tree();
	}
}