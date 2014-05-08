package xiaoping;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * MostDistantNode can get the most distant from root to its children node.
 * 
 * @author XiaopingLi
 * @version 1.7
 * @param <T>
 */
public class MostDistantNode {

	/**
	 * 
	 * @param root
	 *            Root node
	 * @return maximum height from root the its subchildren.
	 */

	public <T> int getHeight(Node<T> root) {

		// apply BFS to get the maximum length
		// also we need presume there is no cycle in the structure
		if (root == null){
			return 0;
		}
		Queue<Node<T>> q = new LinkedList<Node<T>>();

		HashMap<Node<T>, Integer> map = new HashMap<Node<T>, Integer>();
		q.add(root);
		int level = 0;
		map.put(root, 0);
		while (!q.isEmpty()) {

			Node<T> cur = q.poll();

			// if its children is null, begin next iteration
			if (cur.children == null)
				continue;
			for (Node<T> node : cur.children) {
				q.add(node);
				// add all of the children in the list except one
				map.put(node, map.get(cur) + 1);
			}
		}
		for (Integer j : map.values()) {
			level = Math.max(level, j);
		}
		return level;
	}

	public static void main(String[] args) {
		Node<String> a = new Node<String>("a");
		Node<String> b = new Node<String>("b");
		Node<String> c = new Node<String>("c");
		Node<String> d = new Node<String>("d");
		a.addChild(b);
		a.addChild(c);
		b.addChild(d);

		MostDistantNode maxDistance = new MostDistantNode();
		int result = maxDistance.getHeight(a);
		if (result == 2)
			System.out.print("result shows it is right.\n");
		else
			System.out.println(result);

	}
}
