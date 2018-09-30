package activity;

import java.util.Scanner;

import Array_Chain_Stack.ArrayLinearList;
import Graphs.GraphList;
import Graphs.Graphs;

public class SMTP {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		for(int i=0;i<cases;i++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int s = in.nextInt();
			int t = in.nextInt();
			GraphList g = new GraphList(true);
			for(int j=0;j<n;j++) {
				g.addVertex(j);
			}
			for(int j=0;j<m;j++) {
				g.addEdge(in.nextInt(), in.nextInt(), in.nextInt());
			}
			ArrayLinearList r = Graphs.FloydWarshall(g);
			System.out.print("Case #"+(i+1)+": ");
			int a = (int) ((ArrayLinearList) ((ArrayLinearList) r.get(r.size()-1)).get(s+1)).get(t+1);
			if(a == Integer.MAX_VALUE/100) {
				System.out.println("unreachable");
			}
			else {
				System.out.println(a);
			}
			
		}
	}
}
