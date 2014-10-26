package xiaoping.zillow;

import java.util.Comparator;
import java.util.Iterator;

/**
 * 
 * 
 * @author XiaopingLi
 * 
 * @param <T>
 *            Type parameter
 * 
 */
public class TrinaryTree<T> {
	private NodeHolder<T> root = new NodeHolder<T>();
	private Comparator<T> comparator;

	public TrinaryTree(Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		this.comparator = comparator;
	}

	public static <C extends Comparable<C>> TrinaryTree<C> create() {
		return new TrinaryTree<C>(new Comparator<C>() {
			public int compare(C t1, C t2) {
				return t1.compareTo(t2);
			}
		});
	}

	public void insert(T value) {
		// Don't permit null values. Saves us from doing null checks later.
		if (value == null) {
			throw new IllegalArgumentException(
					"Attempted null insert detected.");
		}
		root.add(new TrinaryNode<T>(value, comparator));
	}

	public boolean delete(T value) {
		return root.delete(value);
	}

	public NodeHolder<T> getRoot() {
		return root;
	}

	// for test
	public Iterator<T> iterator() {
		return new InorderTraversal<T>(root);
	}

}
