import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TrianglesInGraph {

	public static void main(String[] args) {
		Edge e1 = new Edge(0, 1);
		Edge e2 = new Edge(2, 1);
		Edge e3 = new Edge(0, 2);
		Edge e4 = new Edge(4, 1);
		Edge e5 = new Edge(0, 4);
		List adjList = new ArrayList<>();
		adjList.add(e1);
		adjList.add(e2);
		adjList.add(e3);
		adjList.add(e4);
		adjList.add(e5);
		System.out.println(getNumberOfTriangles1(adjList));

	}
	
	private static class Edge {
		private final Object from;
		private final Object to;
		
		public Edge(Object from, Object to){
			this.from = from;
			this.to = to;
		}
		
		public Object getFrom(){return from;}
		public Object getTo(){return to;}
		
		@Override
		public String toString(){
			return "(" + ((from!=null) ? from.toString() : null) + "," + ((to!=null) ? to.toString() : null) + ")";
		}
	}
	
	public static Map<Object,Set<Object>> buildAdjacencyMap(List<Edge> edges){
		if ((edges==null) || (edges.isEmpty())){
			return Collections.<Object,Set<Object>>emptyMap();
		}
		
		Map<Object,Set<Object>> graph = new HashMap<>();
		for (Edge e : edges){
			if (!graph.containsKey(e.getFrom())){
				graph.put(e.getFrom(), new HashSet<Object>());
			}
			if (!graph.containsKey(e.getTo())){
				graph.put(e.getTo(), new HashSet<Object>());
			}
			graph.get(e.getFrom()).add(e.getTo());
			graph.get(e.getTo()).add(e.getFrom());
		}
		
		return graph;
	}
	
	public static int getNumberOfTriangles1(List<Edge> edges){
		Map<Object,Set<Object>> graph = buildAdjacencyMap(edges);
		
		int triangles = 0;
		for (Set<Object> neighbors : graph.values()){
			for (Object v2 : neighbors){
				for (Object v3 : neighbors){
					if ((!v2.equals(v3)) && (graph.get(v2).contains(v3))){
						triangles++;
					}
				}
			}
		}
		
		return (triangles/6);
	}
	
	public static class Vertex { List<Vertex> Adjacents; }
}
