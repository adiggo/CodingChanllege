package xiaoping;

import java.util.LinkedList;
import java.util.List;

/**
 * Node class implements a hierarchy data structure
 * 
 * @author Xiaoping Li
 * @version 1.7
 * 
 */
public class Node<T> {
	public List<Node<T>> children;
	T t;

	public Node(){
		children = new LinkedList<Node<T>>();
	}
	public Node(T t) {
		this.t = t;
		children = new LinkedList<Node<T>>();
	}

	/**
	 * add child into t's children list
	 * 
	 * @param child
	 *            child need to be added
	 */
	void addChild(Node<T> child) {
		children.add(child);
	}

}
