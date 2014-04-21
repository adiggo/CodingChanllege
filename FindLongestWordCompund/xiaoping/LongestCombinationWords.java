package xiaoping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * LongestCombinationWords takes text input file as argument, and finds the
 * first and second longest length of the word made by other words in the text
 * file.
 * 
 * @author XiaopingLi LongestCombinationWords can find the longest combination
 *         of other words appeared in the input text file.
 * @version 1.7.0
 * 
 */
public class LongestCombinationWords {

	private static TrieADT trie = new TrieADT();

	public static void main(String[] args) {

		File file = new File(args[0]);
		List<String> inputWord = new ArrayList<String>();
		try {
			// if no input argument
			if (args.length == 0) {
				System.out
						.println("Usage:  java LongestCobinationWords filenamePath");
				return;
			}
			BufferedReader in = new BufferedReader(new FileReader(file));
			// get the word out of the text file separated by "\n"
			String line = null;
			line = in.readLine();
			while ((line != null)) {
				inputWord.add(line);
				line = in.readLine();
			}
			System.out.println("Total number of words :  " + inputWord.size());
			String[] wordsSort = new String[inputWord.size()];
			wordsSort = inputWord.toArray(new String[inputWord.size()]);

			// sort the String array based on the length of the input String
			// so that we can get the string array based on the words length
			Arrays.sort(wordsSort, new Comparator<String>() {
				public int compare(String input1, String input2) {
					if (input1.length() < input2.length())
						return 1;
					else if (input1.length() > input2.length())
						return -1;
					else
						// for both string of equal length
						return 0;
				}
			});
			for (String word : wordsSort) {
				trie.insert(word);
			}
			ArrayList<String> output = new ArrayList<String>();
			output = longestWords(wordsSort);
			System.out.println("First Longest word is " + output.get(0));
			System.out.println("Second Longest word is " + output.get(1));
			System.out
					.println("Total amount of words that are made up by other words in the input file:   "
							+ output.size());
			in.close();
		} catch (FileNotFoundException exception) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param inputWords
	 *            input sorted list
	 * @return arraylist, at index 0, the element is the longest words contained
	 *         max other words of the input file
	 */
	public static ArrayList<String> longestWords(String[] inputWords) {
		ArrayList<String> wordList = new ArrayList<String>();
		for (String word : inputWords) {
			// System.out.println(word);
			if (wordCompoundOfOthers(word, true)) {
				wordList.add(word);
			}
		}
		return wordList;

	}

	/**
	 * 
	 * @param word
	 *            each string in the input file
	 * @param isValidWord
	 *            whether the string is a full word of the input file
	 * @return
	 */
	public static boolean wordCompoundOfOthers(String word, boolean isValidWord) {
		// delete itself. If the word is made by other word, then the string is
		// still in the trie
		if (isValidWord) {
			trie.delete(word);
		}
		// Loop over the length of the word
		for (int i = 0; i < word.length(); i++) {
			if (trie.search(word.substring(0, i + 1))) {
				// two situation:
				// if there is another word same as the previous word, then add
				// the word into our output list
				// there are several other words make up of the word.
				int l = word.length();
				if (i + 1 == l
						|| wordCompoundOfOthers(
								word.substring(i + 1, l), false)) {
					return true;
				}
			}
		}
		// restore trie as before
		if (isValidWord) {
			trie.insert(word);
		}
		return false;

	}

}
