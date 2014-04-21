package xiaoping;

/**
 * 
 * @author XiaopingLi
 * 
 */
public class TrieADT {
	private Node root;

	public TrieADT() {
		// mark of start Node of trie
		root = new Node('*');
	}

	/**
	 * insert method takes a input string as argument, then insert it into trie.
	 * 
	 * @param s
	 *            input String need to be inserted
	 */
	public void insert(String s) {
		Node current = root;
		if (s.length() == 0) // For an empty character
			current.marker = true;// set empty String in the trie
		for (int i = 0; i < s.length(); i++) {
			Node child = current.subNode(s.charAt(i));
			if (child != null) {
				current = child;
				current.numberOfWord++;
			} else {
				current.child.add(new Node(s.charAt(i)));
				current = current.subNode(s.charAt(i));
			}
			// Set character marker to indicate end of the word
			if (i == s.length() - 1)
				current.marker = true;
		}
	}

	/**
	 * 
	 * search input string in the trie. Return true if there is an child node in
	 * the trie contains the whole string. Otherwise, return false.
	 * 
	 * @param s
	 *            input String from text file
	 * @return true or false based whether the trie contains the string
	 */
	public boolean search(String s) {
		Node current = root;
		while (current != null) {
			for (int i = 0; i < s.length(); i++) {
				if (current.subNode(s.charAt(i)) == null)
					return false;
				else
					// update current node to the sub-node
					current = current.subNode(s.charAt(i));
			}
			// if the current node is the last child, return true
			if (current.marker == true)
				return true;
			else
				return false;
		}
		return false;
	}

	/**
	 * 
	 * @param s
	 *            input string
	 * @return true if there is a string s in the trie and delete it. False if
	 *         delete operation fails.
	 */
	public boolean delete(String s) {
		if (search(s)) 
		{
			Node current = root;
			Node temp; 
			while (current != null) {
				for (int i = 0; i < s.length(); i++) {
					temp = current;
					current = current.subNode(s.charAt(i));
					current.numberOfWord--;
					if (current.numberOfWord == 0) {
						temp.child.remove(current);
						break;
					}
				}
				// remove the word
				current.marker = false;
				return true;
			}
		}
		return false;
	}

}