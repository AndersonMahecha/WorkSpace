package Graphs;

import javax.print.attribute.standard.Sides;

import Array_Chain_Stack.ArrayLinearList;
import Array_Chain_Stack.Chain;
import PriorityQueue.MaxHeap;

public class Graphs {
	public static ArrayLinearList FloydWarshall(GraphList graph) {
		
		int n = graph.size;
		ArrayLinearList a = new ArrayLinearList(n);
		
		for(int k=0;k<n;k++) {
			ArrayLinearList b = new ArrayLinearList(n);
			a.add(k, b);
			for(int i=0;i<n;i++) {
				ArrayLinearList c = new ArrayLinearList(n);
				b.add(i, c);
				for(int j=0;j<n;j++) {
					if(k==0) {
						if(j==i) {
							((ArrayLinearList) b.get(i)).add(j,0);
						}
						else if(graph.hasEdge(graph.vertexIn(j),graph.vertexIn(i))!=0) {
							((ArrayLinearList) b.get(i)).add(j,graph.hasEdge(graph.vertexIn(j),graph.vertexIn(i)));
						}
						else {
							((ArrayLinearList) b.get(i)).add(j,Integer.MAX_VALUE/100);
						}
					}
					else if(k>=1){
						int u = Math.min((int)((ArrayLinearList) ((ArrayLinearList) a.get(k-1)).get(j)).get(i),
								(int)((ArrayLinearList) ((ArrayLinearList) a.get(k-1)).get(k)).get(i)+
								(int)((ArrayLinearList) ((ArrayLinearList) a.get(k-1)).get(j)).get(k));
						((ArrayLinearList) ((ArrayLinearList) a.get(k)).get(i)).add(j, u);
					}
				}
			}
		}
		print(a,0);
		System.out.println();
		print(a,1);
		System.out.println();
		print(a,2);
		System.out.println();
		print(a,3);
		System.out.println();
		print(a,4);
		
		return a;		
	}
	
	
	
	public static void print(ArrayLinearList a, int m) {
		int n=a.size();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
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
	
	
	public static int[][][] FloydWarshall2(GraphList graph) {
		int a[][][] = new int[graph.size+1][graph.size+1][graph.size+1];
		int n = graph.size;	
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				
				if(j==i) {
					a[0][i][j] = 0;
				}
				else if(graph.hasEdge(graph.vertexIn(j-1),graph.vertexIn(i-1))!=0) {
					a[0][i][j] = graph.hasEdge(graph.vertexIn(j-1),graph.vertexIn(i-1));
				}
				else {
					a[0][i][j] = Integer.MAX_VALUE/100;
				}
				
			}
		}

		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(k>=1){
						a[k][j][i]=Math.min(a[k-1][j][i], a[k-1][k][i]+a[k-1][j][k]);
					}
				}
			}
		}
		print2(a, 0);
		System.out.println();
		print2(a, 1);
		System.out.println();
		print2(a, 2);
		System.out.println();
		print2(a, 3);
		System.out.println();
		print2(a, 4);
		return a;
		
	}
	
	public static void print2(int a[][][], int n) {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				int k = a[n][j][i];
				if(k==Integer.MAX_VALUE/100) {
					System.out.printf("%5s", "i");
				}
				else {
					System.out.printf("%5d",k);
				}
			}
			System.out.println();
		}
	}


	public static void MSTKruskal(GraphList graph){
		ArrayLinearList a = new ArrayLinearList();
		ArrayLinearList vert = new ArrayLinearList();
		for(int i=0;i<graph.size;i++){
			ArrayLinearList b = new ArrayLinearList();
			b.add(b.size(), graph.Vertex.get(i));
			vert.add(i, b);
		}
		Chain b = graph.outEdges(0);
		MaxHeap m = new MaxHeap();
		while(b.size()>=0){
			m.put((Edge) b.remove(0));
		}
		while(m.size()>=0){
			b.add(b.size(), m.removeMax());
		}
		for(int j=0;j<b.size();j++){
			Edge e = (Edge) b.get(j);
			
		}
		
	}
}