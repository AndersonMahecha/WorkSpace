package Graphs;

import Array_Chain_Stack.Chain;
/**
 * Interface that represents a Graph
 * @author Anderson Mahecha
 *
 */
public interface Graph {
	/**
	 * 
	 * @param vertex
	 */
	void addVertex(Object vertex);
	/**
	 * 
	 * @param remove
	 * @return
	 */
	Object removeVertex(Object remove);
	/**
	 * 
	 * @param fromVert
	 * @param toVert
	 */
	void addEdge(Object fromVert, Object toVert);
	/**
	 * 
	 * @param fromVert
	 * @param toVert
	 * @param weight
	 */
	void addEdge(Object fromVert, Object toVert, float weight);
	/**
	 * 
	 * @param fromVert
	 * @param toVert
	 * @return
	 */
	float removeEdge(Object fromVert, Object toVert);
	/**
	 * 
	 * @param fromVert
	 * @param toVert
	 * @return
	 */
	float hasEdge(Object fromVert, Object toVert);
	/**
	 * 
	 * @param i
	 * @return
	 */
	Chain outEdges(int i);
	/**
	 * 
	 * @param i
	 * @return
	 */
	Chain inEdges(int i);
}
