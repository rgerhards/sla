package trees;

public class Edge {

	private Node nextNode = null;
	private String variable = "";
	
	
	public Edge(String pVariable, Node pNextNode) {
		variable = pVariable;
		nextNode = pNextNode;
	}
	
	public void setVariable(String pVariable) {
		variable = pVariable;
	}
	
	public String getVariable() {
		return variable;
	}
	
	public void setNext(Node pNode) {
		nextNode = pNode;
	}
	
	public Node getNext() {
		return nextNode;
	}
}
