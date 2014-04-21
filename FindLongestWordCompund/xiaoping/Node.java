package xiaoping;

import java.awt.font.NumericShaper;
import java.util.Collection;
import java.util.LinkedList;

/**
 * 
 * @author XiaopingLi
 * 
 */
public class Node {
	char content;
	// mark end of the word
	boolean marker;
	Collection<Node> child;
	int numberOfWord;

	public Node(char c) {
		child = new LinkedList<Node>();
		marker = false;
		content = c;
		numberOfWord = 1; //set default as 1
	}
	

	/**
	 * Get child nodes of input character type
	 * @param c
	 *            input character
	 * @return childNode of the current node corresponds to input character
	 */
	public Node subNode(char c) {
		if (child != null) {
			for (Node eachChild : child) {
				if (eachChild.content == c) {
					return eachChild;
				}
			}
		}
		//if there is no children of that char
		return null;
	}
}