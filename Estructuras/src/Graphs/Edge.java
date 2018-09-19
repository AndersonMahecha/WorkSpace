package Graphs;

public class Edge {
	int w;
	Object toVertex;
	Object fromVertex;
	
	public Edge(int w, Object toVertex, Object fromVertex) {
		super();
		this.w = w;
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
	}


	public Edge(Object toVertex, Object fromVertex) {
		super();
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
	}
	
	@Override
	public String toString() {
		return "Vertice: "+fromVertex+" "+toVertex+" Valor:"+w;
	}
	
	
	
	
	
}
