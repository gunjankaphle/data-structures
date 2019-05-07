package com.data.structures.graphs;

import java.util.List;

public class Main {
	
	public static void main(String...args) throws Exception {
		Graph g = new Graph();
		for (String name: new String[] {"London", "Tokyo", "New York", 
				"Chicago", "Kathmandu", "Frankfurt", "Los Angeles"}) {
			g.addNode(new Node(name));
		}
		
		g.addEdge(g.getNode("London"), g.getNode("Tokyo"));
		g.addEdge(g.getNode("London"), g.getNode("New York"));
		g.addEdge(g.getNode("Tokyo"), g.getNode("London"));
		g.addEdge(g.getNode("Tokyo"), g.getNode("New York"));
		g.addEdge(g.getNode("New York"), g.getNode("Chicago"));
		g.addEdge(g.getNode("Chicago"), g.getNode("Kathmandu"));
		g.addEdge(g.getNode("Chicago"), g.getNode("Frankfurt"));
		g.addEdge(g.getNode("Kathmandu"), g.getNode("Frankfurt"));
		g.addEdge(g.getNode("Kathmandu"), g.getNode("New York"));
		g.addEdge(g.getNode("Los Angeles"), g.getNode("London"));
		
		System.out.println("***************************");
		System.out.println("BFS Search");
		
		List<Node> sp = Algorithms.shortestPath(g, g.getNode("London"), g.getNode("Chicago"));
		
		if (sp != null) {
			System.out.println("Shortest path from" + sp.toString());
		}
		
		System.out.println("***************************");
		System.out.println("DFS Search");
		
		List<Node> bsp = Algorithms.BFS(g, g.getNode("London"), g.getNode("Frankfurt"));
		
		if (sp != null) {
			System.out.println("Shortest path from" + bsp.toString());
		}
		
	}
	
	

}
