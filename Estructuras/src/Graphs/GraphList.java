package Graphs;

import Array_Chain_Stack.ArrayLinearList;
import Array_Chain_Stack.Chain;

public class GraphList implements Graph{
	ArrayLinearList Vertex;
	ArrayLinearList Adjacency;
	int size;
	
	
	public GraphList() {
		super();
		Vertex = new ArrayLinearList();
		Adjacency = new ArrayLinearList();
		size = 0;
	}

	@Override
	public void addVertex(Object vertex) {
		Vertex.add(size, vertex);
		Adjacency.add(size, new Chain());
		size++;
	}

	@Override
	public Object removeVertex(Object remove) {
		int a = Vertex.indexOf(remove);
		if(a>=0) {
			Vertex.remove(a);
			for(int i=0;i<size;i++) {
				Chain aux = (Chain) Vertex.get(i);
				
			}
			Adjacency.remove(a);
		}
		return null;
	}

	@Override
	public void addEdge(Object fromVert, Object toVert) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(Object fromVert, Object toVert, int weight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int removeEdge(Object fromVert, Object toVert) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hasEdge(Object fromVert, Object toVert) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Chain outEdges(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chain inEdges(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
