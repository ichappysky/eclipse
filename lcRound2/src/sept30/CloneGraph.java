package sept30;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import common.UndirectedGraphNode;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * @author yongz
 * 
 */
public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> candidates = new LinkedList<UndirectedGraphNode>();
		UndirectedGraphNode result = new UndirectedGraphNode(node.label);
		visited.put(node, result);
		candidates.offer(node);
		while (!candidates.isEmpty()) {
			UndirectedGraphNode cur = candidates.poll();
			UndirectedGraphNode copy = visited.get(cur);
			for (UndirectedGraphNode neighbor : cur.neighbors) {
				UndirectedGraphNode copyNeighbor;
				if (visited.containsKey(neighbor)) {
					copyNeighbor = visited.get(neighbor);
				} else {
					copyNeighbor = new UndirectedGraphNode(neighbor.label);
					visited.put(neighbor, copyNeighbor);
					candidates.offer(neighbor);
				}
				copy.neighbors.add(copyNeighbor);

			}
		}
		return result;
	}

	public static void main(String[] x) {
		// 1,5#2,5#3#4,4#5,5#
		UndirectedGraphNode zero = new UndirectedGraphNode(0);
		UndirectedGraphNode one = new UndirectedGraphNode(1);
		UndirectedGraphNode two = new UndirectedGraphNode(2);
		UndirectedGraphNode three = new UndirectedGraphNode(3);
		UndirectedGraphNode four = new UndirectedGraphNode(4);
		UndirectedGraphNode five = new UndirectedGraphNode(5);
		zero.neighbors.add(one);
		zero.neighbors.add(five);
		one.neighbors.add(two);
		one.neighbors.add(five);
		two.neighbors.add(three);
		three.neighbors.add(four);
		four.neighbors.add(five);
		four.neighbors.add(five);

		CloneGraph t = new CloneGraph();
		UndirectedGraphNode r = t.cloneGraph(zero);
		System.out.println(r);
	}
}
