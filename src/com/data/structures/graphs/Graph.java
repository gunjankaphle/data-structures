package com.data.structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	
	private Map<Node, List<Node>> edges = new HashMap<Node, List<Node>>();
	
	public void addNode(Node node) throws Exception {
		if (edges.containsKey(node)) {
			throw new Exception("Node already exists");
		} else {
			edges.put(node, new ArrayList<Node>());
		}
	}
	
	public void addEdge(Node source, Node destination) throws Exception {
		if (!(edges.containsKey(source) || edges.containsKey(destination))) {
			throw new Exception("Node doesn't exists");
		} else {
			edges.get(source).add(destination);
		}
	}
	
	public List<Node> getChildren(Node source) {
		return edges.get(source);
	}
	
	public boolean hasNode(Node source) {
		return edges.containsKey(source);
	}
	
	public Node getNode(String name) {
		for (Node eachNode : edges.keySet()) {
			if (name == eachNode.getName()) {
				return eachNode;
			}
		}
		return null;
	}
	
	public String toString() {
		String result = "";
		for (Map.Entry<Node, List<Node>> eachNode: edges.entrySet()) {
			Node source = eachNode.getKey();
			for (Node dest: eachNode.getValue()) {
				result = result + source.getName() + "->" + dest.getName() + "\n";
			}
		}
		return result.substring(0, result.length() - 1);
		
	}

}
