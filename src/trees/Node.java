package trees;

import java.util.ArrayList;

public class Node {

	private ArrayList<Edge> listEdges;
	
	public Node() {
		listEdges = new ArrayList<Edge>();
	}
	
	public void addEdge(Edge pEdge) {
		listEdges.add(pEdge);
	}
	
	public Node checkEdges(String pVar) {
		Node nextNode = null;
		Edge pEdge = null;
		
		for(int i=0; i<listEdges.size(); i++) {
			pEdge = listEdges.get(i);
			if(pEdge.getVariable().equals(pVar)) {
				nextNode = pEdge.getNext();
				break;
			}
		}
		return nextNode;
	}
	
	/*Zur Zeit nur für Ausgabe*/
	public int getSizeList() {
		return listEdges.size();
	}
	
	public Edge getEdge(int i) {
		return listEdges.get(i);
	}
}
