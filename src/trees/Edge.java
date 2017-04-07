package trees;

public abstract class Edge {

	private Node nextNode = null;
	
	
	public void setNext(Node pNode) {
		nextNode = pNode;
	}
	
	public Node getNext() {
		return nextNode;
	}
}
