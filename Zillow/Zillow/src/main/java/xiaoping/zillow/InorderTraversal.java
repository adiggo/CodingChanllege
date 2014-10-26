package xiaoping.zillow;

import java.util.Iterator;

/**
 * 
 * InorderTraversal is used for test case. Since we need test the correctness of
 * the code, we need to compare the order of
 * 
 * @author XiaopingLi
 * 
 * @param <T>
 *            Type parameter
 */
public class InorderTraversal<T> implements Iterator<T> {

	private NodeHolder<T> root;

	private InorderTraversal<T> left;
	private InorderTraversal<T> middle;
	private InorderTraversal<T> right;
	private TrinaryNode<T> current;
	private TrinaryNode<T> next;

	private boolean isEmpty;
	private boolean isLast = false;

	public InorderTraversal(NodeHolder<T> root) {
		this.root = root;
		if (root.get() == null) {
			isEmpty = true;
			left = null;
			middle = null;
			right = null;

		} else {
			isEmpty = false;
			left = new InorderTraversal<T>(root.get().getLeft());
			middle = new InorderTraversal<T>(root.get().getMiddle());
			right = new InorderTraversal<T>(root.get().getRight());
		}
	}

	private TrinaryNode<T> nextNode() {
		if (isEmpty) {
			return null;
		}
		// recurse to go to left
		TrinaryNode<T> next = left.nextNode();
		// get the most_left as the first output.
		if (next != null) {
			return next;
		}
		if (!isLast) {
			isLast = true;
			return root.get();
		}
		// go to middle
		next = middle.nextNode();
		if (next != null) {
			return next;
		}

		next = right.nextNode();
		if (next != null) {
			return next;
		}
		return null;

	}

	public boolean hasNext() {
		if (next == null) {
			next = nextNode();
		}
		return next != null;
	}

	public T next() {
		if (hasNext()) {
			current = next;
			next = null;
			return current.getValue();
		}
		return null;
	}

	public void remove() {
		current.remove();

	}
}
