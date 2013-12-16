package chapter04TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

import common.Graph;
import common.Node;
import common.NodeState;

public class HasRouteBetweenTwoNodes {
	public static boolean searchBSF(Graph g, Node start, Node end) {
		if (start == null || end == null) {
			return false;
		}

		Queue<Node> queue = new LinkedList<Node>();
		start.state = NodeState.Visiting;
		queue.offer(start);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			cur.state = NodeState.Visiting;
			if (cur == end) {
				return true;
			}
			for (Node neighbor : cur.getAdjacent()) {
				if (neighbor.state == NodeState.Unvisited) {
					queue.offer(neighbor);
				}
			}
		}
		return false;
	}

	public static void main(String a[]) {
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[5];
		Node end = n[2];
		System.out.println(searchBSF(g, start, end));
	}

	public static Graph createNewGraph() {
		Graph g = new Graph();
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			temp[i].state = NodeState.Unvisited;
			g.addNode(temp[i]);
		}
		return g;
	}
}
