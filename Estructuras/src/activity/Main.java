package activity;

import Graphs.GraphList;
import Graphs.Graphs;

public class Main {

	public static void main(String[] args) {
		GraphList g = new GraphList(true);
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");
		g.addVertex("h");
		g.addVertex("i");
		g.addEdge("a", "b", 4);
		g.addEdge("a", "h", 8);
		g.addEdge("b", "h", 11);
		g.addEdge("b", "c", 8);
		g.addEdge("c", "d", 7);
		g.addEdge("h", "i", 7);
		g.addEdge("i", "c", 2);
		g.addEdge("h", "g", 1);
		g.addEdge("i", "g", 6);
		g.addEdge("g", "f", 2);
		g.addEdge("c", "f", 4);
		g.addEdge("f", "e", 10);
		g.addEdge("f", "d", 14);
		g.addEdge("d", "e", 9);
		System.out.println("Hola");
		System.out.println(Graphs.MSTKruskal(g));
		System.out.println("Hola");
	}

}
