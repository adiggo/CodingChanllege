import java.util.*;
import java.io.*;

/**
 * 
 * @author xiaopingLi JumpGame2 can take a text-based input, and find its
 *         minimum hop steps. If there are no way out, output failure.
 * 
 */
public class JumpGame {

	public static void main(String[] args) {
		File file = new File(args[0]);
		ArrayList<Integer> input = new ArrayList<Integer>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));

			String line = null;
			line = in.readLine();
			while ((line != null)) {
				try {
					int a = Integer.parseInt(line);
					input.add(a);
					line = in.readLine();
				} catch (NumberFormatException e) {
					System.out.println("Invalid input: the input should be integers");
				}
			}
			ArrayList<Integer> re = new ArrayList<Integer>();
			re = jump(input);
			StringBuilder c = new StringBuilder();
			if (re.get(0) == -1){
				System.out.println("falure to hop out of array");
			}else{
				for (Integer i : re) {
					c.append(i);
					c.append(",");
				}
				c.append("out");
				System.out.println(c.toString());
			}
			in.close();
		} catch (FileNotFoundException exception) {
			System.out.println("File " + file.getPath()
					+ " not found.Check your file path");
		} catch (IOException exception) {
			System.out.println(exception);
		}
	}

	/**
	 * jump method update its max cover area each time. If it cannot find a way out, output a arraylist insert with -1.
	 * 
	 * @param InputData
	 *            an integer array containing integers from the input
	 * @return the index of the number in the array which leads to the shortest
	 *         hop steps.
	 */
	public static ArrayList<Integer> jump(ArrayList<Integer> InputData) {
		int start = 0;
		int end = 0;
		int count = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();

		// handle A's length is 1
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(0);
		if (InputData.size() == 1)
			return temp;
		boolean canReach = true;
		int[] state = new int[InputData.size()];
		state[0] = InputData.get(0);
		if (state[0] == 0 && InputData.size() > 1) {
			canReach = false;
		}
		for (int i = 1; i < InputData.size(); i++) {
			state[i] = Math.max(state[i - 1], InputData.get(i) + i);
			if (state[i] <= i && i <= InputData.size() - 1) {
				canReach = false;
			}

		}

		ArrayList<Integer> fail = new ArrayList<Integer>();
		fail.add(-1);
		while (end < InputData.size()) {
			int max = 0;
			result.add(start);

			if (canReach == false) {
				return new ArrayList<Integer>(fail);
			}
			for (int i = start; i <= end; i++) {
				if (InputData.get(i) + i > InputData.size() - 1)
					return result;
				if (InputData.get(i) + i > max) {
					result.set(count, i);
					max = InputData.get(i) + i;
				}
			}
			start = end + 1;
			end = max;
			count++;
		}

		return result;
	}

}
