package activity;

import java.util.Scanner;

import Array_Chain_Stack.ArrayLinearList;
import Graphs.Edge;
import Graphs.GraphList;
import Graphs.Graphs;

public class MST {
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int cases = in.nextInt();
		for(int i=0;i<cases;i++) {
			GraphList g = new GraphList(true);
			int fr= in.nextInt();
			for(int j=0;j<fr;j++) {
				g.addVertex(j);
			}
			ArrayLinearList points = new ArrayLinearList();
			in.nextLine();
			for(int j=0;j<fr*2;j+=2) {
				String l = in.nextLine();
				l.replaceAll(".", ",");
				String p[] = l.split(" ");
				points.add(j, (int)Float.parseFloat(p[0]));
				points.add(j+1, (int)Float.parseFloat(p[1]));
			}
			
			for(int j=0;j<fr;j++) {
				for(int k=j+1;k<fr;k++) {
						double dis =  Math.sqrt(Math.pow((int)points.get(j*2)-(int)points.get(k*2), 2)+Math.pow((int)points.get(j*2+1)-(int)points.get(k*2+1), 2));
						g.addEdge(j, k, (float)dis);
					
				}
			}
			ArrayLinearList res = Graphs.MSTKruskal(g);
			float resp = 0;
			for(int j=0;j<res.size();j++) {
				Edge e = (Edge) res.get(j);
				resp+=e.w;
			}
			System.out.printf("%.2f\n",resp);
		}
	}
}
