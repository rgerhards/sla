package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import trees.Node;
import trees.Tree;


public class TreeTable {

	private DefaultMutableTreeNode root;
	private Tree tree;
	
	public void createTreeTable(Tree pTree) {
		tree = pTree;
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		root = new DefaultMutableTreeNode("root");
		runTree(pTree.getRoot(), root);
		
		JTree jTree = new JTree(root);
		frame.add(new JScrollPane(jTree));
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public void runTree(Node currentNode, DefaultMutableTreeNode currentFolder) {
		
		for(int i=0; i < currentNode.getSizeList(); i++) {
			DefaultMutableTreeNode tmp = new DefaultMutableTreeNode(currentNode.getEdge(i).getVariable());
			currentFolder.add(tmp);
			runTree(currentNode.getEdge(i).getNext(), tmp);
		}
	}
}
