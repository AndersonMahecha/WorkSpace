package Graphs;

import Array_Chain_Stack.ArrayLinearList;
import Array_Chain_Stack.Chain;
import HashTable.HashTable;
import PriorityQueue.MaxHeap;

public class Graphs {
	public static ArrayLinearList FloydWarshall(GraphList graph) {
		
		int n = graph.size+1;
		ArrayLinearList a = new ArrayLinearList(n);
		a.add(0, n0(graph));
		for(int k=1;k<n;k++) {
			ArrayLinearList b = new ArrayLinearList();
			fill0(b, n);
			a.add(k, b);
			for(int i=1;i<n;i++) {
				for(int j=1;j<n;j++) {
					int val = Math.min((int) ((ArrayLinearList) ((ArrayLinearList) a.get(k-1)).get(i)).get(j), (int)((ArrayLinearList) ((ArrayLinearList) a.get(k-1)).get(k)).get(j)+
							(int)((ArrayLinearList) ((ArrayLinearList) a.get(k-1)).get(i)).get(k));
					((ArrayLinearList) ((ArrayLinearList) a.get(k)).get(i)).set(j, val);
				}
			}
		}		
		return a;		
	}
	
	public static void fill0(ArrayLinearList b, int n) {
		for(int i=0;i<n;i++) {
			ArrayLinearList c = new ArrayLinearList();
			b.add(i, c);
			for(int j=0;j<n;j++) {
				((ArrayLinearList) b.get(i)).add(j,0);
			}
		}
	}
	
	public static ArrayLinearList n0(GraphList g) {
		ArrayLinearList a = new ArrayLinearList();
		int n = g.size;
		for(int i=0;i<=n;i++) {
			ArrayLinearList b = new ArrayLinearList();
			a.add(i, b);
			for(int j=0;j<=n;j++) {
				if(j==0 || i==0) {
					b.add(j, 0);
				}
				else {
					if(i==j) {
						b.add(j, 0);
					}
					else if(g.hasEdge(g.vertexIn(j-1),g.vertexIn(i-1))!=0) {
						b.add(j, g.hasEdge(g.vertexIn(j-1),g.vertexIn(i-1)));
					}
					else {
						b.add(j, Integer.MAX_VALUE/100);
					}
				}
				
			}
		}
		return a;
	}
	
	private static void print(ArrayLinearList a, int m) {
		int n=a.size();
		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				int k = (int) ((ArrayLinearList) ((ArrayLinearList) a.get(m)).get(j)).get(i);
				if(k==Integer.MAX_VALUE/100){
					System.out.printf("%5s " , "i");
				}
				else{
					System.out.printf("%5d ",k);
				}
			}
			System.out.println();
		}
	}
	
	
	public static ArrayLinearList MSTKruskal(GraphList graph){
		ArrayLinearList a = new ArrayLinearList();
		ArrayLinearList vert = new ArrayLinearList();
		for(int i=0;i<graph.size;i++){
			ArrayLinearList b = new ArrayLinearList();
			b.add(0, graph.Vertex.get(i));
			vert.add(i, b);
		}
		Chain b = graph.outEdges(0);
		MaxHeap m = new MaxHeap();
		int max = b.size();
		for(int k=0;k<max;k++) {
			m.put((Edge) b.remove(0));
		}
		while(m.size()>0){
			b.add(b.size(), m.removeMax());
		}
		for(int j=0;j<b.size();j++){
			Edge e = (Edge) b.get(j);
			int f=-1,t=-1;
			for(int k=0;k<vert.size();k++) {
				ArrayLinearList aux = (ArrayLinearList) vert.get(k);
				for(int i=0;i<aux.size();i++) {
					if(aux.get(i).equals(e.fromVertex)) {
						f=k;
					}
					if(aux.get(i).equals(e.toVertex)) {
						t=k;
					}
				}
			}
			if(f!=t) {
				ArrayLinearList aux = (ArrayLinearList) vert.get(f);
				ArrayLinearList aux2 = (ArrayLinearList) vert.get(t);
				for(int k=0;k<aux2.size();k++) {
					aux.add(0, aux2.get(k));
				}
				vert.remove(t);
				a.add(a.size(), e);
			}
		}
		return a;
		
	}
}
