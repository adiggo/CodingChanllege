package xiaoping.zillow;

/**
 * 
 * @author XiaopingLi
 * 
 * @param <T>
 *            Type parameter
 */
public class NodeHolder<T> {
	private TrinaryNode<T> node;

	/**
	 * 
	 * @return The node in the nodeholder.
	 */
	TrinaryNode<T> get() {
		return node;
	}

	void add(TrinaryNode<T> node) {
		if (this.node == null) {
			this.node = node;
			node.isOwner(this);
		} else {
			this.node.add(node);
		}
	}

	boolean delete(T value) {
		if (this.node == null) {
			return false;
		} else {
			return this.node.delete(value);
		}
	}

	void clear() {
		this.node = null;
	}
}
