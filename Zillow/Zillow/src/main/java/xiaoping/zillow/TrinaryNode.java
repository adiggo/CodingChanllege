package xiaoping.zillow;

import java.util.Comparator;

/**
 * 
 * @author XiaopingLi
 * 
 * @param <T>
 *            Type parameter
 */
public class TrinaryNode<T> {

	private T value;
	private Comparator<T> comparator;

	private NodeHolder<T> owner;

	private NodeHolder<T> left = new NodeHolder<T>();
	private NodeHolder<T> middle = new NodeHolder<T>();
	private NodeHolder<T> right = new NodeHolder<T>();

	public TrinaryNode(T value, Comparator<T> comparator) {
		this.value = value;
		this.comparator = comparator;
	}

	public void setOwner(NodeHolder<T> owner) {
		this.owner = owner;
	}

	/* package-private */T getValue() {
		return value;
	}

	/**
	 * 
	 * @param newValue
	 *            new value needed to insert into Trinary Node
	 */
	void add(TrinaryNode<T> newValue) {
		int comparison = compare(newValue.getValue());
		if (comparison < 0)
			left.add(newValue);
		else if (comparison > 0)
			right.add(newValue);
		else
			middle.add(newValue);
	}

	void isOwner(NodeHolder<T> owner) {
		this.owner = owner;
	}

	boolean delete(T value) {
		int comparison = compare(value);
		// recurse to do the delete operation if comparison is not equal to
		// zero.
		if (comparison < 0) {
			return left.delete(value);
		} else if (comparison > 0) {
			return right.delete(value);
		}

		remove();
		return true;
	}

	int compare(T value) {
		return comparator.compare(value, this.value);
	}

	void remove() {

		NodeHolder<T> formerOwner = owner;
		formerOwner.clear();

		TrinaryNode<T> leftNode = left.get();
		TrinaryNode<T> rightNode = right.get();
		TrinaryNode<T> middleNode = middle.get();
		if (leftNode != null) {
			formerOwner.add(leftNode);
		}
		if (middleNode != null) {
			formerOwner.add(middleNode);
		}
		if (rightNode != null) {
			formerOwner.add(rightNode);
		}
	}

	NodeHolder<T> getLeft() {
		return left;
	}

	NodeHolder<T> getRight() {
		return right;
	}

	NodeHolder<T> getMiddle() {
		return middle;
	}
}
