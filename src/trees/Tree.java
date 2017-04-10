package trees;

public class Tree {
	
	private Node root = null;
	private Node current = null;
	
	public Tree() {
		root = new Node();
		current = root;
	}
	
	public void addEdge(String pVar) {
		Node nextNode;
		
		if((nextNode = current.checkEdges(pVar)) == null) {
			nextNode = new Node();
			Edge pEdge = new Edge(pVar, nextNode);
			current.addEdge(pEdge);
		}
		current = nextNode;
	}
	
	public void nextLine() {
		current = root;
	}
	
	/*für Ausgabe zum Überprüfen*/
	public void dotTreeOutput() {
		System.out.println("digraph {");
		runTree(root);
		System.out.println("}");
	}
	
	public void runTree(Node current) {
		System.out.println(current.hashCode() + "[label=\"\"]");
		for(int i=0; i < current.getSizeList(); i++) {
			System.out.println(current.hashCode() + "->" + current.getEdge(i).getNext().hashCode() + "[label=\"" + current.getEdge(i).getVariable() + "\"]");
			runTree(current.getEdge(i).getNext());
		}
		
	}
	
	
}
