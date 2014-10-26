package xiaoping.zillow;



import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class TrinaryTreeTest {

	/**
	 * Test for insertion of Trinary tree
	 */
	@Test
	public void insertTest() {
		TrinaryTree<Integer> tree = TrinaryTree.create();
		for (int value : new int[] { 4, 8, 9, 7, 4, 5, 5, 9, 6, 4, 6 }) {
			tree.insert(value);
		}

		// Iterate the tree and ensure that all values are present.
		int[] result = new int[11];
		int index = 0;
		for (Iterator<Integer> iter = tree.iterator(); iter.hasNext();) {
			result[index++] = iter.next();
		}

		Assert.assertArrayEquals(result, new int[] { 4, 4, 4, 5, 5, 6, 6, 7, 8,
				9, 9 });
	}

	@Test
	public void deleteTest() {
		TrinaryTree<Integer> tree = TrinaryTree.create();
		for (int value : new int[] { 4, 8, 9, 7, 4, 5, 5, 9, 6, 4, 6 }) {
			tree.insert(value);
		}

		// Iterate the tree and ensure that all values are present.
		int[] result = new int[11];
		int index = 0;
		for (Iterator<Integer> iter = tree.iterator(); iter.hasNext();) {
			result[index++] = iter.next();
		}

		Assert.assertArrayEquals(result, new int[] { 4, 4, 4, 5, 5, 6, 6, 7, 8,
				9, 9 });
		tree.delete(5);
		int[] newResult = new int[10];
		int newIndex = 0;
		for (Iterator<Integer> iter = tree.iterator(); iter.hasNext();) {
			newResult[newIndex++] = iter.next();
		}
		Assert.assertArrayEquals(newResult, new int[] { 4, 4, 4, 5, 6, 6, 7, 8,
				9, 9 });
	}
}
