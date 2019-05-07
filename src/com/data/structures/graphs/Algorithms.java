package com.data.structures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Algorithms {
	public static List<Node> shortestPath(Graph graph, Node start, Node end) {
		return DFS(graph, start, end, new ArrayList<Node>(), null);
	}

	public static List<Node> DFS(Graph graph, Node start, Node end, List<Node> path, List<Node> shortest) {
		path.add(start);
		System.out.println("Current DFS Path" + path.toString());

		if (start.equals(end)) {
			return path;
		}

		for (Node cNode : graph.getChildren(start)) {
			if (!path.contains(cNode)) {
				if (shortest == null || path.size() < shortest.size()) {
					List<Node> newPath = DFS(graph, cNode, end, path, shortest);
					if (newPath != null) {
						shortest = newPath;
					}
				}
			} else {
				System.out.println("Already visited Node: " + cNode);
			}
		}

		return shortest;
	}

	public static List<Node> BFS(Graph graph, Node start, Node end) {
		List<Node> initPath = new ArrayList<Node>();
		initPath.add(start);

		Queue<List<Node>> pathQueue = new LinkedList<>();
		pathQueue.add(initPath);

		while (pathQueue.size() != 0) {
			List<Node> tempPath = pathQueue.poll();
			System.out.println("Current BFS path: " + tempPath.toString());
			Node lastNode = tempPath.get(tempPath.size() - 1);
			if (lastNode.equals(end)) {
				return tempPath;
			}
			for (Node cNode : graph.getChildren(lastNode)) {
				if (!tempPath.contains(cNode)) {
					List<Node> newPath = new ArrayList<Node>();
					newPath.addAll(tempPath);
					newPath.add(cNode);
					pathQueue.add(newPath);
				}
			}

		}

		return null;

	}
}
