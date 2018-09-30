package Graphs;
public class Edge implements Comparable<Edge>{
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


	@Override
	public int compareTo(Edge o) {
		if(w>o.w){
			return -1;
		}
		else if(w<o.w){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	
	
	
	
}