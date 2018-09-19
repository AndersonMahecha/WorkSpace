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
		Object res = Adjacency.get(a);
		if(a>=0) {
			Vertex.remove(a);
			for(int i=0;i<size;i++) {
				Chain aux = (Chain) Vertex.get(i);
				for(int j=0;j<aux.size();j++) {
					if(aux.get(j).equals(remove)) {
						aux.remove(j);
						break;
					}
				}
			}
			Adjacency.remove(a);
			size--;
		}
		return res;
	}

	@Override
	public void addEdge(Object fromVert, Object toVert) {
		int a = Vertex.indexOf(fromVert);
		int b = Vertex.indexOf(toVert);
		if(a!=-1 && b!=-1) {
			((Chain) Adjacency.get(a)).add(0,new Edge(toVert, fromVert));
		}
		else {
			if(a==1)
				throw new IllegalArgumentException("The From Vertex dont Exist");
			if(b==1)
				throw new IllegalArgumentException("The To Vertex dont Exist");
		}
		
	}

	@Override
	public void addEdge(Object fromVert, Object toVert, int weight) {
		int a = Vertex.indexOf(fromVert);
		int b = Vertex.indexOf(toVert);
		if(a!=-1 && b!=-1) {
			((Chain) Adjacency.get(a)).add(0,new Edge(weight, toVert, fromVert));
		}
		else {
			if(a==-1)
				throw new IllegalArgumentException("The From Vertex dont Exist");
			if(b==-1)
				throw new IllegalArgumentException("The To Vertex dont Exist");
		}
	}

	@Override
	public int removeEdge(Object fromVert, Object toVert) {
		int a = Vertex.indexOf(fromVert);
		int b = Vertex.indexOf(toVert);
		int re = 0;
		if(a!=-1 && b!=-1) {
			Chain c = (Chain) Adjacency.get(a);
			for(int i=0;i<c.size();i++) {
				if(((Edge) c.get(i)).toVertex.equals(toVert)) {
					re = ((Edge) c.get(i)).w;
					c.remove(i);
				}
			}
		}
		else {
			if(a==1)
				throw new IllegalArgumentException("The From Vertex dont Exist");
			if(b==1)
				throw new IllegalArgumentException("The To Vertex dont Exist");
		}
		return re;
	}

	@Override
	public int hasEdge(Object fromVert, Object toVert) {
		for(int i=0;i<size;i++) {
			if(Vertex.get(i).equals(fromVert)) {
				Chain a = (Chain) Adjacency.get(i);
				for(int j=0;j<a.size();j++) {
					Edge e = (Edge) a.get(j);
					if(e.toVertex.equals(toVert)){
						return e.w;
					}
				}
				break;
			}
		}
		return 0;
	}
	
	public Object vertexIn(int i) {
		if(i<=size) {
			return Vertex.get(i);
		}
		else {
			throw new IndexOutOfBoundsException("The vertex dont exist");
		}
	}

	@Override
	public Chain outEdges(int i) {
		Chain c = new Chain();
		for(int j=0;j<size;j++){
			Chain a = (Chain) Adjacency.get(j);
			for(int k=0;k<a.size();k++){
				c.add(c.size(), a.get(k));
			}
		}
		return c;
	}

	@Override
	public Chain inEdges(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		String a = "";
		for(int i=0;i<size;i++) {
			Chain c = (Chain) Adjacency.get(i);
			a+=Vertex.get(i);
			a+=":";
			for(int j=0;j<c.size();j++) {
				a+=c.get(j).toString()+",";
			}
			a+="\n";
		}
		return a;
	}
}
