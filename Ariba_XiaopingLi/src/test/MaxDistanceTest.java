package test;

import static org.junit.Assert.*;

import org.junit.Test;

import xiaoping.MostDistantNode;
import xiaoping.Node;

/**
 * 
 * @author Xiaoping Li
 * @version 1.7
 * 
 */

public class MaxDistanceTest {

	/**
	 * Test when root's children has different maximum path from root node to
	 * most distant node
	 */
	@Test
	public <T> void test() {

		MostDistantNode maxDis = new MostDistantNode();
		// initialize data for node
		Node<String> n1 = new Node<String>("a");
		Node<String> n2 = new Node<String>("b");
		Node<String> n3 = new Node<String>("c");
		Node<String> n4 = new Node<String>("d");
		Node<String> n5 = new Node<String>("e");
		Node<String> n6 = new Node<String>("f");
		n1.children.add(n2);
		n1.children.add(n3);
		n2.children.add(n4);
		n2.children.add(n5);
		n5.children.add(n3);

		assertEquals(maxDis.getHeight(n1), 3);

		n1.children.add(n2);
		n1.children.add(n3);
		n2.children.add(n4);
		n2.children.add(n5);
		n5.children.add(n3);
		n3.children.add(n6);
		assertEquals(maxDis.getHeight(n1), 4);

	}

}
